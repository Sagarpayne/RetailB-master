package com.sagar.retb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class DisplayLaptops extends AppCompatActivity {
    private final String android_version_names[] = {
            "LENOVO",
            "Acer",
            "Asus",
            "HP",
            "LENOVO",

    "Dell"};

    private final String android_image_urls[] = {
            "https://dri1.img.digitalrivercontent.net/Storefront/Company/msintl/images/English/en-INTL-Lenovo-Z50-QF9-00446/en-INTL-L-Lenovo-Z50-QF9-00446-mnco.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/41Cc8RMykRL._SL500_AC_SS350_.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/518aFtg0t9L._SY355_.jpg",
            "https://media.hpshopping.in/catalog/product/cache/00b8f07a3b9d695b2e5226138af9507a/2/V/2VR52PA-1.png",
            "https://dri1.img.digitalrivercontent.net/Storefront/Company/msintl/images/English/en-INTL-Lenovo-Z50-QF9-00446/en-INTL-L-Lenovo-Z50-QF9-00446-mnco.jpg",
            "https://images-na.ssl-images-amazon.com/images/I/81ZZvtgIynL._SX425_.jpg"


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);


        initViews();
    }
    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Products> productses = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(), productses);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<Products> prepareData(){

        ArrayList<Products> android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            Products products = new Products();
            products.setAndroid_version_name(android_version_names[i]);
            products.setAndroid_image_url(android_image_urls[i]);
            android_version.add(products);
        }
        return android_version;
    }

    public void showLaptopDetails(View view)
    {
        Intent intent = new Intent(this, DisplayLaptop.class);

        startActivity(intent);
    }
}
