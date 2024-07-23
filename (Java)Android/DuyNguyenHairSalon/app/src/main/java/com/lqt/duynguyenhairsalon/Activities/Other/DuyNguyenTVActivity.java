package com.lqt.duynguyenhairsalon.Activities.Other;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.lqt.duynguyenhairsalon.Model.Adapters.DuyNguyenTVAdapter2;
import com.lqt.duynguyenhairsalon.Model.VideoYouTube;
import com.lqt.duynguyenhairsalon.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DuyNguyenTVActivity extends AppCompatActivity {

    private ImageView imageViewBack;
    private List<VideoYouTube> playListYouTube;
    private DuyNguyenTVAdapter2 duyNguyenTVAdapter2;
    private RecyclerView recyclerView;

    private int totalResults;

    //Tách url thành nhiều thành phần
    private String playlistId = "PLbplMzmYtClB5RqnCS1xcSbkcl_RA9bks";
    private String key = "AIzaSyC5OO_rliGtqP8EPL4Io8SaFrBi6tOlk6o";
    private static String pageToken = "";
    private String Url = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + playlistId + "&key=" + key + "&maxResults=50&pageToken=";

    /*
     * https://www.googleapis.com/youtube/v3/playlistItems?
     * part=snippet
     * &playlistId={List}
     * &key=AIzaSyC5OO_rliGtqP8EPL4Io8SaFrBi6tOlk6o
     * &maxResults=50&pageToken=xxxxxx;
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duy_nguyen_t_v);

        initView();

        setListen();

//        checkTotalResults(Url);

        getJSonYouTube(Url);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
    }

    private void loadList() {
        duyNguyenTVAdapter2 = new DuyNguyenTVAdapter2(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        duyNguyenTVAdapter2.setData(playListYouTube);
        recyclerView.setAdapter(duyNguyenTVAdapter2);
    }

    private void setListen() {
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void checkTotalResults(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    totalResults = response.getJSONObject("pageInfo").getInt("totalResults");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DuyNguyenTVActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void getJSonYouTube(String url) {
        if (playListYouTube == null) {
            playListYouTube = new ArrayList<>();
        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url + pageToken, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonItems = response.getJSONArray("items");

                    String title = "";
                    String urlThumn = "";
                    String idVideo = "";

                    // Đoạn này lưu ý phải gọi đệ quy
                    if (totalResults == 0) {
                        totalResults -= response.getJSONObject("pageInfo").getInt("resultsPerPage");
                        getJSonYouTube(Url + response.getString("nextPageToken"));
                    }

                    for (int i = 0; i < jsonItems.length(); i++) {
                        //lấy ra Snippet
                        JSONObject jsonItem = jsonItems.getJSONObject(i);
                        JSONObject jsonSnippet = jsonItem.getJSONObject("snippet");

                        //lấy title
                        title = jsonSnippet.getString("title");

                        //lấy ảnh nhỏ của video
                        JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");
                        JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");
                        urlThumn = jsonMedium.getString("url");

                        //lấy id video
                        JSONObject jsonResourceId = jsonSnippet.getJSONObject("resourceId");
                        idVideo = jsonResourceId.getString("videoId");

                        playListYouTube.add(new VideoYouTube(idVideo, urlThumn, title));
                        loadList();
                    }
                    getJSonYouTube(Url + response.getString("nextPageToken"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DuyNguyenTVActivity.this, "Lỗi!", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonObjectRequest);
    }

    private void initView() {
        imageViewBack = findViewById(R.id.imageViewBack);
        recyclerView = findViewById(R.id.recyclerView_PlayList);
    }
}