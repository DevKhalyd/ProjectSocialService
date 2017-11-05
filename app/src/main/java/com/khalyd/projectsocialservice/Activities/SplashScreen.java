package com.khalyd.projectsocialservice.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.khalyd.projectsocialservice.R;

import es.dmoral.toasty.Toasty;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fullScreen();
        setContentView(R.layout.activity_splash_screen);
        myMethods();

    }




    private void myMethods(){

        animLayouts();
        timerunning();



    }

    private void  fullScreen(){

        if (Build.VERSION.SDK_INT >= 21){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    private void animLayouts(){

        RelativeLayout R1,R2,R3;
        Animation fromuptodown,fromdowntoup;

        R1 = (RelativeLayout) findViewById(R.id.r1_red);
        R2 = (RelativeLayout) findViewById(R.id.r2_white);
        R3 = (RelativeLayout) findViewById(R.id.r3_green);

        fromuptodown = AnimationUtils.loadAnimation(this,R.anim.fromuptodown);
        fromdowntoup = AnimationUtils.loadAnimation(this,R.anim.fromdowntoup);

        R1.setAnimation(fromdowntoup);
        R2.setAnimation(fromuptodown);
        R3.setAnimation(fromdowntoup);

    }

    private void timerunning(){


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                final Intent i = new Intent(SplashScreen.this,LoginFBTW.class);
                startActivity(i);
              //  Toasty.success(SplashScreen.this,"Cambiando a México",Toast.LENGTH_LONG).show();

                finish();

             //   final Intent i = new Intent(SplashScreen.this,MainActivityBootom.class);

            }
        },6000);


    }


}
