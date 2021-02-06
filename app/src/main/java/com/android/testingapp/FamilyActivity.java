package com.android.testingapp;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList <String> words = new ArrayList<>();
        int index = 0;
        while (index <1000){
            words.add(" "+index);
            index++;
        }

        ArrayAdapter itemsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,words);

        ListView listView = findViewById(R.id.family_list);
        listView.setAdapter(itemsAdapter);
    }
}