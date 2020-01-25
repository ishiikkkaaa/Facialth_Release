package com.theaces.facialth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Vibrator vibrate;

    private EditText username;
    private EditText password;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login2);

        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button2);

        vibrate = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrate.vibrate( 47);
                validate(username.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate(String username, String password)
    {
        if (username.equals("anshu") && password.equals("arpit"))
        {
            Toast.makeText(this, "Welcome Anshu", Toast.LENGTH_SHORT).show();
            Intent ij = new Intent(LoginActivity.this, LandingActivity.class);
            startActivity(ij);
            finish();

        }
        else
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();




    }

     boolean back = false;
    @Override
    public void onBackPressed() {



        if (back){
            super.onBackPressed();
            return;
        }
        back=true;
            Toast.makeText(LoginActivity.this,"Press Back Again to Exit",Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {
                                          back=false;

                                      }
                                  },2000
        );
    }
}
