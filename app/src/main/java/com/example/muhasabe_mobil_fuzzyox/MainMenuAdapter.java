package com.example.muhasabe_mobil_fuzzyox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainMenuAdapter extends ArrayAdapter<String> {

    private String[] items ;
    private int[] item_icon;
    Context context ;
    private ImageView itemImage;
    private TextView itemText;

    public MainMenuAdapter(String[] items, int[] item_icon, Context context){
         super(context, R.layout.activity_menu_item, items);
        this.items = items;
        this.item_icon = item_icon;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_menu_item , null);

        if (v != null){
            itemText = v.findViewById(R.id.activity_menu_item_itemName);
            itemImage = v.findViewById(R.id.activity_menu_item_itemLogo);

            itemText.setText(items[position]);
            itemImage.setBackgroundResource(item_icon[position]);

        }
        return v;
    }
}
