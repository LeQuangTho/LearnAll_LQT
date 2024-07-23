package com.lqt.flowlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wefika.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /*
     * link Libary
     * https://github.com/blazsolar/FlowLayout
     * */
    FlowLayout flowLayout;
    List<Keyword> keywords = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowLayout = (FlowLayout) findViewById(R.id.flowlayout);

        setData();

        if (keywords != null && keywords.size() > 0) {
            flowLayout.removeAllViews();
            for (int i = 0; i < keywords.size(); i++){
                Keyword keyword = keywords.get(i);
                TextView textView = new TextView(this);
                FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT,
                        FlowLayout.LayoutParams.WRAP_CONTENT);
                params.setMargins(0, 10, 20, 10);
                textView.setLayoutParams(params);
                textView.setId(keyword.getId());
                textView.setText(keyword.getName());
                textView.setPadding(30,10,30,10);
                textView.setBackgroundResource(R.drawable.custom_layout_item);

                textView.setOnClickListener(this);
                flowLayout.addView(textView);
            }
        }
    }

    private void setData() {
        keywords.add(new Keyword(1, "Lê Quang Thọ"));
        keywords.add(new Keyword(2, "Android"));
        keywords.add(new Keyword(5, "Thọ"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case 1:
                Toast.makeText(this, ""+v.getId(), Toast.LENGTH_SHORT).show();
            case 2:
                Toast.makeText(this, ""+v.getId(), Toast.LENGTH_SHORT).show();
            case 3:
                Toast.makeText(this, ""+v.getId(), Toast.LENGTH_SHORT).show();
            case 4:
                Toast.makeText(this, ""+v.getId(), Toast.LENGTH_SHORT).show();
            case 5:
                Toast.makeText(this, ""+v.getId(), Toast.LENGTH_SHORT).show();
        }
    }
}