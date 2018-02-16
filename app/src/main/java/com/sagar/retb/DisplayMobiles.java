package com.sagar.retb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DisplayMobiles extends AppCompatActivity {
    private final String android_version_names[] = {
            "Apple",
            "Infocus",
            "karbonn",
            "Samsung",
            "Moto g",

            "Microsoft"};

    private final String android_image_urls[] = {
            "http://www.iclarified.com/images/news/25488/96773/96773-640.jpg",
            "http://www.iclarified.com/images/news/25488/96773/96773-640.jpg",
            "http://www.iclarified.com/images/news/25488/96773/96773-640.jpg",
            "http://www.iclarified.com/images/news/25488/96773/96773-640.jpg",
            "http://www.iclarified.com/images/news/25488/96773/96773-640.jpg",
            "http://www.iclarified.com/images/news/25488/96773/96773-640.jpg",

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
}
