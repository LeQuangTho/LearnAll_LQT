package com.example.appmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        // Ánh xạ
        listView = (ListView) findViewById(R.id.listView);

        // ArrayList
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("List View Item 1");
        arrayList.add("List View Item 2");
        arrayList.add("List View Item 3");
        arrayList.add("List View Item 4");
        arrayList.add("List View Item 5");
        arrayList.add("List View Item 6");
        arrayList.add("List View Item 7");
        arrayList.add("List View Item 8");
        arrayList.add("List View Item 9");
        arrayList.add("List View Item 10");
        arrayList.add("List View Item 11");
        arrayList.add("List View Item 12");

        ArrayAdapter adapter = new ArrayAdapter(ListViewActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "Item " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}