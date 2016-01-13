package com.miguelcr.listviewcustom;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by miguelcampos on 11/1/16.
 */
public class FruitAdapter extends ArrayAdapter<FruitItem> {
    private final Context context;
    private final ArrayList<FruitItem> values;


    public FruitAdapter(Context context, ArrayList<FruitItem> values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int layoutToLoad = R.layout.fruit_list_item;

        View layoutItem = inflater.inflate(layoutToLoad, parent, false);

        // We get the current fruit that we're painting in
        // the list
        FruitItem currentFruit = values.get(position);

        // 1st Block: get the data of the current fruitITem
        int iconCurrentFruit = currentFruit.getIcon();
        String nameCurrentFruit = currentFruit.getName();

        // 2nd block: set the data into the layout
        ImageView icon = (ImageView) layoutItem.findViewById(R.id.imageViewFruit);
        TextView name = (TextView) layoutItem.findViewById(R.id.textViewFruitName);
        RelativeLayout layout = (RelativeLayout) layoutItem.findViewById(R.id.itemLayout);

        icon.setImageResource(iconCurrentFruit);
        name.setText(nameCurrentFruit);

        if(position%2==0) { // Even
            layout.setBackgroundColor(Color.GRAY);
        }

        return layoutItem;
    }
}
