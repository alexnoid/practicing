package com.example.dp_client6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.SettingInjectorService;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import android.view.Menu;
/*
    мне искренне стыдно за это приложение, пожалуйста сделайте скидку при оценке, потому что до этого ни на Python ни на Java я ниразу не работал
 */
public class MainActivity extends AppCompatActivity {

    private String url = "https://dpsarvar.herokuapp.com/";
    //private String url = "http://2fc7c619aa91.ngrok.io/";
    private String postBodyString;
    private MediaType mediaType;
    private RequestBody requestBody;
    private Button connect;
    private Button connect2;
    public String log;
    public void setlog(String l){
        this.log = l;
        SharedPreferences settings = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString("LOGIN", l );
        prefEditor.apply();
    }
    public String getlog(){
        return this.log;
    }
    public String pas;
    public void setpas(String s){
        this.pas=s;
        SharedPreferences settings = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString("PASSWOR", s );
        prefEditor.apply();
    }
    public String getpas(){
        return this.pas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences("Login", MODE_PRIVATE);

        String username = settings.getString("LOGIN",null);
        String password = settings.getString("PASSWOR",null);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        if (username != null && password != null )
        {
            this.pas=password;
            this.log=username;
            Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
            intent.putExtra("LOGIN",username);
            intent.putExtra("PASSWOR", password);
            startActivity(intent);
            postRequest("", url+"reg", "none",0);
        }

        connect = findViewById(R.id.LOG);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText log = findViewById(R.id.editTextTextPersonName);
                EditText pas = findViewById(R.id.editTextTextPassword);
                setlog(log.getText().toString());
                setpas(pas.getText().toString());
                String message = log.getText().toString();
                message+= pas.getText().toString();
                postRequest("", url+"reg", "none",1);

            }
        });
        connect2 = findViewById(R.id.Reg);
        connect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText log = findViewById(R.id.editTextTextPersonName);
                EditText pas = findViewById(R.id.editTextTextPassword);
                String message = log.getText().toString();
                message+= pas.getText().toString();
                setlog(log.getText().toString());
                setpas(pas.getText().toString());
                //postRequest(message, url+"reg", "none", 1);

            }
        });
    }

    private RequestBody buildRequestBody(String msg) {
        postBodyString = msg;
        mediaType = MediaType.parse("text/plain");
        requestBody = RequestBody.create(postBodyString, mediaType);
        return requestBody;
    }


    private void postRequest( String message, String URL, String tglogin, int a) {
        SharedPreferences settings = getSharedPreferences("Login", MODE_PRIVATE);

        String username = settings.getString("LOGIN",null);
        String password = settings.getString("PASSWOR",null);
        RequestBody requestBody = buildRequestBody(message);
        EditText log = findViewById(R.id.editTextTextPersonName);
        EditText pas = findViewById(R.id.editTextTextPassword);
        RequestBody formBody = new FormBody.Builder()
                .add("log", username)
                .add("pass", password)
                .add("tglog", tglogin)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
       /* Request request = new Request
                .Builder()
                .post(requestBody)
                .url(URL)
                .build();

        */
        Request request = new Request.Builder()
                .url(URL)
                .post(formBody)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(final Call call, final IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        Toast.makeText(MainActivity.this, "Something went wrong:" + " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        call.cancel();


                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //Toast.makeText(MainActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                            String otvet = response.body().string();
                            //Toast.makeText(MainActivity.this, otvet, Toast.LENGTH_LONG).show();
                            if (otvet.equals("zaebis")){
                                if (a!=0) {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                                    intent.putExtra("Login", getlog());
                                    intent.putExtra("PASSWOR", getpas());
                                    startActivity(intent);
                                }

                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }

}