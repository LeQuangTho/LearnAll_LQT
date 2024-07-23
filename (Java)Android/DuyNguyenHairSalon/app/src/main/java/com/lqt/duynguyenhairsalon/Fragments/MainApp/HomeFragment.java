package com.lqt.duynguyenhairsalon.Fragments.MainApp;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.lqt.duynguyenhairsalon.Activities.Booking.Admin.BookingActivity;
import com.lqt.duynguyenhairsalon.Activities.HistoryCutActivity;
import com.lqt.duynguyenhairsalon.Activities.Home.NotificationActivity;
import com.lqt.duynguyenhairsalon.Activities.MemberActivity;
import com.lqt.duynguyenhairsalon.Activities.Other.DuyNguyenTVActivity;
import com.lqt.duynguyenhairsalon.Activities.Other.LoadWebViewActivity;
import com.lqt.duynguyenhairsalon.Activities.RewardsActivity;
import com.lqt.duynguyenhairsalon.Model.Adapters.DuyNguyenTVAdapter;
import com.lqt.duynguyenhairsalon.Model.Adapters.PhotoAdapter;
import com.lqt.duynguyenhairsalon.Model.Photo;
import com.lqt.duynguyenhairsalon.Model.SystemHelper;
import com.lqt.duynguyenhairsalon.Model.VideoYouTube;
import com.lqt.duynguyenhairsalon.R;
import com.lqt.duynguyenhairsalon.SharedPreferences.DataLocalManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    /*
     * Đối với fragment
     * thì mình chọn cách gán thẳng 1 tk context
     * sau đó sử dụng cho nhanh
     * */

    //View
    private View view;
    private ViewPager viewPagerSlider;
    private CircleIndicator circleIndicator;
    private RecyclerView recyclerViewDuyNguyenTV;
    private Button buttonCall;
    private TextView textViewXemThemTV, textViewSignupRank;
    private ImageView imageViewHistoryCut, imageViewNotification;
    private BottomNavigationView bottomNavigationView;

    //Adapter
    private DuyNguyenTVAdapter duyNguyenTVAdapter;
    private PhotoAdapter photoAdapter;

    //Param
    private SystemHelper systemHelper;
    private String playlistId = "PLbplMzmYtClB5RqnCS1xcSbkcl_RA9bks";
    private String key = "AIzaSyC5OO_rliGtqP8EPL4Io8SaFrBi6tOlk6o";
    private String Url = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=" + playlistId + "&key=" + key + "&maxResults=5";
    private boolean isAdmin;
    private List<Photo> photoList;
    private Timer timer;

    //List
    private List<VideoYouTube> playListYouTube;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        systemHelper = new SystemHelper(view.getContext());

        initView();

        setSlider();

        autoSlideImage();

        getJSonYouTube(Url);

        setDataLookBook();

        setListenFragment();

        return view;
    }

    private void autoSlideImage() {
        if (photoList == null || photoList.isEmpty() || viewPagerSlider == null) {
            return;
        }

        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPagerSlider.getCurrentItem();
                        int totalItem = photoList.size() - 1;
                        if (currentItem < totalItem) {
                            currentItem++;
                            viewPagerSlider.setCurrentItem(currentItem);
                        } else {
                            viewPagerSlider.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 500, 3000);
    }


    /*
     * Hàm này sẽ chứa sự kiện ở trong fragment này
     * */
    private void setListenFragment() {
        //listen button call
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPermisstion();
            }
        });

        textViewXemThemTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DuyNguyenTVActivity.class);
                startActivity(intent);
            }
        });

        textViewSignupRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoadWebViewActivity.class);
                intent.putExtra("LINK", "https://30shine.com/shine-member/");
                startActivity(intent);
            }
        });

        imageViewHistoryCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), HistoryCutActivity.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_booking:
                        if (isAdmin) {
                            Intent intent = new Intent(getContext(), BookingActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(getContext(), com.lqt.duynguyenhairsalon.Activities.Booking.Customer.BookingActivity.class);
                            startActivity(intent);
                        }
                        break;
                    case R.id.menu_history:
                        Intent intent2 = new Intent(getContext(), HistoryCutActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.menu_member:
                        Intent intent3 = new Intent(getContext(), MemberActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.menu_rewards:
                        Intent intent4 = new Intent(getContext(), RewardsActivity.class);
                        startActivity(intent4);
                        break;
                }

                return true;
            }
        });

        imageViewNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NotificationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void callPermisstion() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:0973271208"));
                startActivity(intent);
            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(view.getContext(), "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        TedPermission.with(view.getContext())
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check();
    }


    /*
     * hàm này chỉ để thử add view động
     * sau này có cơ sở dữ liệu sẽ làm chuẩn hơn.
     * */
    private void setDataLookBook() {

        int images[] = {R.drawable.demo1
                , R.drawable.demo2
                , R.drawable.demo3
                , R.drawable.demo4
                , R.drawable.demo5};

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayoutDuyNguyenLookBook);

        //Vì là set code động nên ta phải tạo params

        LinearLayout.LayoutParams linearLayoutParam = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams cardViewLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);

        linearLayoutParam.setMargins(systemHelper.dpToPx(10), systemHelper.dpToPx(10), systemHelper.dpToPx(10), 0);


        for (int i = 0; i < 5; i++) {
            CardView cardView = new CardView(view.getContext());
            ImageView imageView = new ImageView(view.getContext());
            //set LayoutParams
            cardView.setLayoutParams(linearLayoutParam);
            imageView.setLayoutParams(cardViewLayoutParams);

            cardView.setRadius(systemHelper.dpToPx(12));
            imageView.setAdjustViewBounds(true);
            imageView.setImageResource(images[i]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), LoadWebViewActivity.class);
                    intent.putExtra("LINK", "https://30shine.com/lookbook");
                    startActivity(intent);
                }
            });

            //add lần lượt các view vào
            cardView.addView(imageView);
            linearLayout.addView(cardView);
        }

    }

    /*
     * set data cho slider
     * */
    private void setSlider() {
        photoList = getListPhoto();

        photoAdapter = new PhotoAdapter(getContext(), photoList);

        viewPagerSlider.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPagerSlider);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
    }

    private List<Photo> getListPhoto() {
        List<Photo> photos = new ArrayList<>();

        photos.add(new Photo(R.drawable.demo1));
        photos.add(new Photo(R.drawable.demo2));
        photos.add(new Photo(R.drawable.demo3));
        photos.add(new Photo(R.drawable.demo4));
        photos.add(new Photo(R.drawable.demo5));

        return photos;
    }

    private void getJSonYouTube(String url) {
        if (playListYouTube == null) {
            playListYouTube = new ArrayList<>();
        }
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonItems = response.getJSONArray("items");

                    String title = "";
                    String urlThumn = "";
                    String idVideo = "";

                    for (int i = 0; i < jsonItems.length(); i++) {
                        //lấy ra Snippet
                        JSONObject jsonItem = jsonItems.getJSONObject(i);
                        JSONObject jsonSnippet = jsonItem.getJSONObject("snippet");

                        //lấy title
                        title = jsonSnippet.getString("title");

                        //lấy ảnh nhỏ của video *lưu ý nếu lấy maxres sẽ load rất lâu và không đủ data
                        JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");
                        JSONObject jsonStandard = jsonThumbnail.getJSONObject("standard");
                        urlThumn = jsonStandard.getString("url");

                        //lấy id video
                        JSONObject jsonResourceId = jsonSnippet.getJSONObject("resourceId");
                        idVideo = jsonResourceId.getString("videoId");

                        playListYouTube.add(new VideoYouTube(idVideo, urlThumn, title));
                        loadList();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Lỗi!", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

    private void loadList() {
        duyNguyenTVAdapter = new DuyNguyenTVAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                , LinearLayoutManager.HORIZONTAL
                , false);
        recyclerViewDuyNguyenTV.setLayoutManager(linearLayoutManager);
        duyNguyenTVAdapter.setData(playListYouTube);
        recyclerViewDuyNguyenTV.setAdapter(duyNguyenTVAdapter);
    }

    /*
     * Ánh xạ thông thương
     * */
    private void initView() {
        recyclerViewDuyNguyenTV = view.findViewById(R.id.recyclerviewTV);
        buttonCall = view.findViewById(R.id.button_Call);
        textViewXemThemTV = view.findViewById(R.id.textView_XemThemTV);
        textViewSignupRank = view.findViewById(R.id.textView_Signup_Rank);
        imageViewHistoryCut = view.findViewById(R.id.imageView_Avatar);
        bottomNavigationView = view.findViewById(R.id.bottomNavView);
        imageViewNotification = view.findViewById(R.id.imageView_Notification);
        viewPagerSlider = view.findViewById(R.id.viewPager_Slider);
        circleIndicator = view.findViewById(R.id.circleIndicator);

        isAdmin = DataLocalManager.getPrefIsAdmin();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}