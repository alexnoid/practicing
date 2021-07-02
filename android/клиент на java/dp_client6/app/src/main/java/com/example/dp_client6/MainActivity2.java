package com.example.dp_client6;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import android.view.Menu;
import java.net.URISyntaxException;
import com.github.nkzawa.socketio.client.*; // java socket io client
import com.github.nkzawa.socketio.client.Socket;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.engineio.client.*; // java engine io client
import com.github.nkzawa.engineio.client.transports.*;

public class MainActivity2 extends AppCompatActivity {

    public String url = "https://dpsarvar.herokuapp.com/";
    //public String url = "http://2fc7c619aa91.ngrok.io/";
//    private Socket mSocket;
//    {
//        try {
//            mSocket = IO.socket(url);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//    }
    private String postBodyString;
    private MediaType mediaType;
    private RequestBody requestBody;
    private Button connect;
    public String tgpost = "0";
    public String vkpost = "0";
    public String LOGIN;
    public String PASSWOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        Bundle arguments = getIntent().getExtras();
        PASSWOR = arguments.get("PASSWOR").toString();
        LOGIN = arguments.get("LOGIN").toString();
//        mSocket.on("status-update", onNewMessage);
//        mSocket.connect();
//        if(mSocket.connected()){
//            Toast.makeText(getApplicationContext(), "есть", Toast.LENGTH_LONG).show();
//        }


    }
//    private Emitter.Listener onNewMessage = new Emitter.Listener() {
//        @Override
//        public void call(final Object... args) {
//            MainActivity2.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    String data = (String) args[0];
//                    Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
//                    mSocket.emit("fileok", "OKIDOKI");
//                }
//            });
//        }
//    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.action_settings:
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.nav_host_fragment, settingslog.class, null)
//                        .commit();
//                return true;
//        }
        return false;
    }


}