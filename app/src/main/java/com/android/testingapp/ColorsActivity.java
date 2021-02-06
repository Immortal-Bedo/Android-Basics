package com.android.testingapp;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList <String> words = new ArrayList();
        words.add("one");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");

        ArrayAdapter itemsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,words);

        ListView listView = findViewById(R.id.colors_list);
        listView.setAdapter(itemsAdapter);


    }

}