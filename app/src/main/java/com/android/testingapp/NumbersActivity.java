package com.android.testingapp;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList <String> words = new ArrayList();
        words.add("one");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");
        words.add("a7a");

        ArrayAdapter itemsAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,words);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);



    }
}
