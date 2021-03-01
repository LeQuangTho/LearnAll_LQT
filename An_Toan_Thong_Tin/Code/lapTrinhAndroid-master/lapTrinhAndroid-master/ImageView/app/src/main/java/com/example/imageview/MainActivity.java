package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textViewContent;
    EditText editTextAcc, editTextPass;
    Button buttonCancel, buttonSignIn;
    String content = "10 years ago, after “the Gate” that connected the real world with the monster world opened, some of the ordinary, everyday people received the power to hunt monsters within the Gate.\n" +
            "\n" +
            "They are known as \"Hunters\". However, not all Hunters are powerful. My name is Sung Jin-Woo, an E-rank Hunter. I'm someone who has to risk his life in the lowliest of dungeons, the \"World's Weakest\".\n" +
            "\n" +
            "Having no skills whatsoever to display, I barely earned the required money by fighting in low-leveled dungeons… at least until I found a hidden dungeon with the hardest difficulty within the D-rank dungeons! In the end, as I was accepting death, I suddenly received a strange power, a quest log that only I could see, a secret to leveling up that only I know about! If I trained in accordance with my quests and hunted monsters, my level would rise.\n" +
            "\n" +
            "Changing from the weakest Hunter to the strongest S-rank Hunter!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewContent = (TextView) findViewById(R.id.textViewContent);
        editTextAcc = (EditText) findViewById(R.id.editTextAccount);
        editTextPass = (EditText) findViewById(R.id.editTextPass);
        buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonSignIn = (Button) findViewById(R.id.buttonSignUp);

        textViewContent.setMovementMethod(new ScrollingMovementMethod());
        textViewContent.setText(content);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextAcc.getText().toString().trim().length() > 0) {
                    if (editTextPass.getText().toString().trim().length() > 0) {
                        Toast.makeText(MainActivity.this, "Sign Up Success!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Sign Up Failed!!!\nPassword can't NULL", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Sign Up Failed!!!\nEmail can't NULL",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}