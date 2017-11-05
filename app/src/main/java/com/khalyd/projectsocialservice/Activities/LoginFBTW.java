package com.khalyd.projectsocialservice.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.khalyd.projectsocialservice.Class.CircleForm;
import com.khalyd.projectsocialservice.Model.Directory;
import com.khalyd.projectsocialservice.R;

import es.dmoral.toasty.Toasty;

public class LoginFBTW extends AppCompatActivity {

    private static final  String fb = "https://stockmarketdaily.co/wp-content/uploads/2016/12/logo-facebook.png";
    private static final  String tw = "http://icons.iconarchive.com/icons/sicons/basic-round-social/512/twitter-icon.png";
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login_fbtw);

         callbackManager = CallbackManager.Factory.create();

        setAlertDialog();
        setImages();
        loginbtnFb();
        checkAccunt();

    }

    private void checkAccunt(){


        if (AccessToken.getCurrentAccessToken() != null) {

            Intent i = new Intent(LoginFBTW.this, MainActivityBootom.class);
            // i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();

        }
    }

    private void setImages(){

        ImageView imgTW = (ImageView) findViewById(R.id.twiter_login_image);
        ImageView imgFB = (ImageView) findViewById(R.id.facebook_login_image);
        Button btn = (Button) findViewById(R.id.enter);


        Glide.with(this).load(fb)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleForm(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgFB);


        Glide.with(this).load(tw)
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleForm(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imgTW);







    }

    private void  loginbtnFb(){

        LoginButton loginFB = (LoginButton) findViewById(R.id.loginbtn_fb);

        loginFB.setReadPermissions("email"); //Need arrayList for more

        loginFB.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

                Toast.makeText(LoginFBTW.this,"Has iniciado sesión correctamente " ,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(LoginFBTW.this,MainActivityBootom.class);
               //Delete actiity anterior i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK & Intent.FLAG_ACTIVITY_CLEAR_TOP & Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
                Toasty.success(LoginFBTW.this,"Cambiando a México", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancel() {

                Toast.makeText(LoginFBTW.this,"Has cancelado el inicio de sesión",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException error) {

                Toast.makeText(LoginFBTW.this,"Codigo de error " + error ,Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //For know the actions form  registerCallback

        callbackManager.onActivityResult(requestCode,resultCode,data);





    }


    private void setAlertDialog(){

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("FirstLaunch");//Model very important
        b.setMessage("Para una mejor experiencia de la app debes ingresar con Facebook y Twitter");
        b.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();

            }
        });

        Dialog d = b.create();
        d.show();



    }


}
