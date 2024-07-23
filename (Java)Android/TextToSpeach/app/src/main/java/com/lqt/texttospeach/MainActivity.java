package com.lqt.texttospeach;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech mTTS;
    private List<String> stringList;
    private SeekBar seekBarPitch, seekBarSpeed;
    private Button buttonSay, buttonSayAgain;
    private TextView textViewResult;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        AddListString();

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e(MainActivity.class.getName(), "Language Not Supported");
                    } else {
                        buttonSay.setEnabled(true);
                    }
                } else {
                    Log.e(MainActivity.class.getName(), "Initialization failed");
                }
            }
        });

        buttonSay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Speak();
            }
        });
        buttonSayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpeakAgain();
            }
        });
    }

    private void AddListString() {
        stringList = new ArrayList<>();
        stringList.add("How do you use IT?");
        stringList.add("What devices do you use?");
        stringList.add("What software do you use?");
        stringList.add("What job would you like to do in the future?");
        stringList.add("What does a database administrator do?");
        stringList.add("What does a helpdesk supervisor do?");
        stringList.add("What does a project manager do?");
        stringList.add("What does a software developer do?");
        stringList.add("What does a support technician do?");
        stringList.add("What does a system analyst?");
        stringList.add("Can you tell me a name of a technology company?");
        stringList.add("What activities do they carry out?");
        stringList.add("What is the IT organization would you like to work for? Why?");
        stringList.add("Can you tell me the difference between peripherals and internal hardware?");
        stringList.add("What can you do to a window?");
        stringList.add("What do you use computers for?");
        stringList.add("Which website do you visit most often?");
        stringList.add("Which browsers do you use? Which is your favourite? Why?");
        stringList.add("What kind(s) of device(s) do you use to access the internet?");
        stringList.add("Are these devices secure? What security features do they have (e.g. a PIN)?");
        stringList.add("What features do you use on a mobile device? What do you use them for?");
        stringList.add("How often do you use email?");
        stringList.add("When do you choose email instead of instant messaging, face-to-face or telephone communication?");
        stringList.add("What do people use spread-sheets for?");
        stringList.add("Do you use spread-sheets? What for?");
        stringList.add("What do you find easy about using them (spread-sheets)?");
        stringList.add("What do you find difficult about using them?");
        stringList.add("What database programs do you know?");
        stringList.add("What do people use databases for? Give examples.");
        stringList.add("Can you describe NAS device?");
        stringList.add("Can you describe a touchpad?");
        stringList.add("Can you describe a stylus?");
        stringList.add("Can you describe a graphics tablet and stylus?");
        stringList.add("Can you describe a touch screen?");
        stringList.add("Can you describe a projector?");
        stringList.add("Can you describe a headset?");
        stringList.add("Can you describe a multifunctional printer?");
        stringList.add("How do you communicate electronically with friends and family?");
        stringList.add("Which types of communication do you think are better for communicating information?");
        stringList.add("Which types of communication do you think are better for being friendly?");
        stringList.add("Which method of communicating do you prefer: face-to-face, by video or by telephone?");
        stringList.add("What do you think are the advantages of video conferencing over face-to-face meetings?");
        stringList.add("Do you buy things on the internet? Why (not)?");
        stringList.add("What are the advantages and disadvantages of internet shopping?");
        stringList.add("When a company buys new technology, how important do you think it is to train users?");
        stringList.add("What do you think are the advantages of e-learning over face-to-face learning?");
        stringList.add("What was the last problem you had with an electronic device? What other problems could happen?");
        stringList.add("When you have problems with a device, what do you do? How can you find help?");
        stringList.add("Have you ever called an IT help desk centre? What happened? How was the experience?");
        stringList.add("Can you talk about steps to solve an IT problem?");
        stringList.add("In what area of IT would you most like to work in the future? Why?");
        stringList.add("What technical skills do you have? Where have you used them?");
        stringList.add("What personal skills do you have? In what situations have you used them? ");
//        stringList.add("");
    }

    private void Speak() {
        Random random = new Random();

        text = stringList.get(random.nextInt(stringList.size()));
        float pitch = (float) seekBarPitch.getProgress() / 50;
        if (pitch < 0.1) {
            pitch = 0.1f;
        }
        float speed = (float) seekBarSpeed.getProgress() / 50;
        if (speed < 0.1) {
            speed = 0.1f;
        }

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewResult.setText(text);
            }
        }, 5000);
    }

    private void SpeakAgain(){
        float pitch = (float) seekBarPitch.getProgress() / 50;
        if (pitch < 0.1) {
            pitch = 0.1f;
        }
        float speed = (float) seekBarSpeed.getProgress() / 50;
        if (speed < 0.1) {
            speed = 0.1f;
        }

        mTTS.setPitch(pitch);
        mTTS.setSpeechRate(speed);
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void InitView() {
        seekBarPitch = findViewById(R.id.seaekBar_pitch);
        seekBarSpeed = findViewById(R.id.seaekBar_speed);
        buttonSay = findViewById(R.id.button_Say);
        buttonSayAgain = findViewById(R.id.button_SayAgain);
        textViewResult = findViewById(R.id.textView_Result);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }
    }
}