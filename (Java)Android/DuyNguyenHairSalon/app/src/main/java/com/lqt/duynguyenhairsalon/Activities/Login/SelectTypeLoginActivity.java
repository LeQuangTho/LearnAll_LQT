package com.lqt.duynguyenhairsalon.Activities.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.lqt.duynguyenhairsalon.R;

import org.json.JSONObject;

import java.util.Arrays;


public class SelectTypeLoginActivity extends AppCompatActivity {

    //Param
    private CallbackManager callbackManager;

    //View
    private LoginButton loginButtonFB;
    private Button buttonLoginWithPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type_login);

        initView();

        setButtonFB();

        setButtonPN();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                if (object != null)
                    Log.d("datauser", "" + object.toString());
                //                    Glide.with(SelectTypeLoginActivity.this)
//                            .load("https://graph.facebook.com/" + object.getString("id") + "/picture?type=large")
//                            .into(imageViewAvatar);
            }
        });

        Bundle bundle = new Bundle();

        bundle.putString("fields", "gender, name, id, first_name, last_name");

        graphRequest.setParameters(bundle);
        graphRequest.executeAsync();
    }

    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if (currentAccessToken == null) {
                LoginManager.getInstance().logOut();
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accessTokenTracker.startTracking();
    }

    private void setButtonFB() {
        callbackManager = CallbackManager.Factory.create();

        loginButtonFB.setPermissions(Arrays.asList("user_gender,user_friends"));

        loginButtonFB.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d("login_fb", "Success");
            }

            @Override
            public void onCancel() {
                Log.d("login_fb", "locgin Cancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("login_fb", "login error");
            }
        });
    }

    private void setButtonPN() {
        buttonLoginWithPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectTypeLoginActivity.this, EnterPhoneNumberLoginActivity.class));
            }
        });
    }

    private void initView() {
        loginButtonFB = findViewById(R.id.login_button);
        buttonLoginWithPhoneNumber = findViewById(R.id.button_LoginWithPhoneNumber);
    }
}