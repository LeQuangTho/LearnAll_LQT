package com.lqt.provaider;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ContentResolver contentResolver;
    Button button, buttonSD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if(checkSelfPermission("READ_CONTACTS") != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS,
                            Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
                }
                contentResolver = getContentResolver();
                Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                        new String[]{ContactsContract.Contacts.DISPLAY_NAME,ContactsContract.Contacts._ID},
                        null,
                        null,
                        null
                );

                //hiển thị dnah bạ
                List<String> list =  new ArrayList<>();
                while(cursor.moveToNext()){
                    long id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    Cursor c = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER},
                            ContactsContract.CommonDataKinds.Phone._ID +" =? ",
                            new String[]{String.valueOf(id)},
                            null);
                    String dt = "";
                    while(c.moveToNext()){
                        dt+= c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))+" .";
                    }
                    list.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))+"( " + dt +" )");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,list);
                listView.setAdapter(adapter);
            }
        });

        buttonSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] projection = new String[]{"_display_name", "date_added", "mime_type"};
                CursorLoader loader =  new CursorLoader(MainActivity.this,
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        projection,
                        (String)null,
                        (String[])null,
                        (String)null);
                Cursor c = loader.loadInBackground();
                c.moveToFirst();
                String s = " ";
                while (!c.isAfterLast()){
                    for(int i = 0; i<c.getColumnCount();i++){
                        s += c.getString(i) +" - ";
                    }
                    s+= "\n";
                    c.moveToNext();
                    Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();
                    c.close();
                }

            }
        });
    }

    private void AnhXa() {
         listView = (ListView) findViewById(R.id.ListView) ;
         button = (Button) findViewById(R.id.button);
         buttonSD = (Button) findViewById(R.id.buttonSD);
    }
}