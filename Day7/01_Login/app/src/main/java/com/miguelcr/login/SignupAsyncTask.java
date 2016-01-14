package com.miguelcr.login;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import org.json.JSONArray;

import java.io.IOException;

/**
 * Created by miguelcampos on 14/1/16.
 */
public class SignupAsyncTask extends AsyncTask<String, Void, String> {

        private GoogleCloudMessaging gcm;
        private Context context;
        private String regId;
        JSONArray response = new JSONArray();
        String nombre;

        // TODO: change to your own sender ID to Google Developers Console project number, as per instructions above
        private static final String SENDER_ID = "93663396119";

        public SignupAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {

            String msg = "";
            String log = params[0];
            nombre = params[0];
            try {
                if (gcm == null) {
                    gcm = GoogleCloudMessaging.getInstance(context);
                }

                try {
                    regId = gcm.register(SENDER_ID);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // We

                msg = "Device registered, registration ID=" + regId;



                // You should send the registration ID to your server over HTTP,
                // so it can use GCM/HTTP or CCS to send messages to your app.
                // The request to your server should be authenticated if your app
                // is using accounts.
                sendRegistrationIdToBackend();


            } catch (IOException ex) {
                ex.printStackTrace();
                msg = "Error: " + ex.getMessage();
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String msg) {
            Logger.getLogger("REGISTRATION").log(Level.INFO, msg);
            Intent i = new Intent(context, PestaActivity.class);
            context.startActivity(i);


        }

        private void sendRegistrationIdToBackend() {
            URL url = null;
            HttpURLConnection urlConnection = null;
            Log.v("CatalogClient", "Entra en sendRegistration");

            String registro = "http://miguelcr.hol.es/talkme/register?regId=" +regId+"&nickname="+ nombre;
            Log.i("LogAsyn",registro);
            try {
                url = new URL(registro);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                urlConnection = (HttpURLConnection) url.openConnection();

                int responseCode = urlConnection.getResponseCode();

                if(responseCode == HttpStatusCodes.STATUS_CODE_OK){
                    String responseString = readStream(urlConnection.getInputStream());
                    Log.v("CatalogClient", responseString);
                    try {
                        response = new JSONArray(responseString);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.v("CatalogClient", "Response code:"+ responseCode);
                }
            } catch (IOException e) {
                Log.v("CatalogClient", "Error conexión");
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }

        }

        private String readStream(InputStream in) {
            BufferedReader reader = null;
            StringBuffer response = new StringBuffer();
            try {
                reader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return response.toString();
        }

}
