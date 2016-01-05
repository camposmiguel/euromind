package com.miguelcr.webbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    WebView browser;
    EditText editTextAddress;
    ImageButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference to the webView component
        browser = (WebView)findViewById(R.id.webView);
        editTextAddress = (EditText)findViewById(R.id.editTextAddress);
        btnSearch = (ImageButton)findViewById(R.id.buttonSearch);

        btnSearch.setOnClickListener(this);

        // This line of code prevent that Android opens native browser
        browser.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onClick(View v) {
        String address = editTextAddress.getText().toString();

        if(address.startsWith("http://")) {
            browser.loadUrl(address);
        } else {
            browser.loadUrl("http://"+address);
        }
    }
}
