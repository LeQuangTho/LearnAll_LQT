package com.lqt.restapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView listView;
    CustomAdapter customAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        customAdapter = new CustomAdapter(this);
        layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        listView.setLayoutManager(layoutManager);
        AsyncTask<String, Void, String> content = new RSSFeed().execute("https://hau-truong/...");

    }

    private void AnhXa() {
        listView = (RecyclerView) findViewById(R.id.listView_Khach);
    }

    //    ArrayList<String> arrayList = new ArrayList<>();
//    ArrayList<String> arrayLink = new ArrayList<>();
    List<Khach> khaches = new ArrayList<>();

    //lấy dữ liệu từ server
    public class RSSFeed extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuffer content = new StringBuffer();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = ""; //lấy title
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line); //lấy item i
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content.toString();
        }

        //Post dữ liệu lên client
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLParse xmlParse = new XMLParse();

            try {
                Document document = xmlParse.getDocument(s);
                NodeList nodeList = document.getElementsByTagName("tblKhach");
                String title = "";
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Element element = (Element) nodeList.item(i);
                    khaches.add(new Khach(xmlParse.getValue(element, "Makhach")
                            , xmlParse.getValue(element, "TenKhach")
                            , xmlParse.getValue(element, "DiaChi")
                            , xmlParse.getValue(element, "DienThoai")));
//                    title += xmlParse.getValue(element, "title");
//                    arrayList.add(title);
//                    arrayLink.add(xmlParse.getValue(element, "link"));

                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }

            Toast.makeText(MainActivity.this, ""+khaches.size(), Toast.LENGTH_SHORT).show();
            customAdapter.setData(khaches);
            listView.setAdapter(customAdapter);
        }
    }
}