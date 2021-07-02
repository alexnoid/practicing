package com.example.dp_client6.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.dp_client6.MainActivity2;
import com.example.dp_client6.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    private DashboardViewModel dashboardViewModel;
    private String postBodyString;
    private MediaType mediaType;
    private RequestBody requestBody;
    private Button connect;
    public String posts="";

    public void setposts(String a){
        posts = a;
    }

    private ViewGroup contein;
    private LayoutInflater inflate;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        inflate = inflater;
        contein = container;
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //final TextView textView = root.findViewById(R.id.text_dashboard);
        Button tglog = root.findViewById(R.id.tg_login);
        Button tgco = root.findViewById(R.id.button2);
        tglog.setOnClickListener(this);
        tgco.setOnClickListener(this);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tg_login:
                TextView co = (TextView) getView().findViewById(R.id.editTextTextPersonName2);
                String tgco = co.getText().toString();
                TextView txt = (TextView) getView().findViewById(R.id.editTextPhone);
                String s = txt.getText().toString();
                //postRequest("none", "https://dpsarvar.herokuapp.com/tgupdate", s, tgco);
                MainActivity2 m = (MainActivity2) getActivity();
                //getposts("none", m.url+"tgposts", s, tgco);
                getposts("none", m.url+"tgco", s, tgco);
                //Toast.makeText(getActivity(), posts, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                co = (TextView) getView().findViewById(R.id.editTextTextPersonName2);
                tgco = co.getText().toString();
                txt = (TextView) getView().findViewById(R.id.editTextPhone);
                s = txt.getText().toString();
                //postRequest("none", "https://dpsarvar.herokuapp.com/tgupdate", s, tgco);
                MainActivity2 m2 = (MainActivity2) getActivity();
                getposts("none", m2.url+"tgco", s, tgco);
                break;
        }
    }
    public RequestBody buildRequestBody(String msg) {
        postBodyString = msg;
        mediaType = MediaType.parse("text/plain");
        requestBody = RequestBody.create(postBodyString, mediaType);
        return requestBody;
    }


    public void postRequest(String message, String URL, String tglogin, String tgco) {
        RequestBody requestBody = buildRequestBody(message);
        MainActivity2 main = (MainActivity2) getActivity();
        RequestBody formBody = new FormBody.Builder()
                .add("log", main.LOGIN)
                .add("pass", main.PASSWOR)
                .add("tglog", tglogin)
                .add("tgco", tgco)
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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        Toast.makeText(getActivity(), "Something went wrong:" + " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        call.cancel();


                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //Toast.makeText(MainActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                            String otvet = response.body().string();
                            Toast.makeText(getActivity(), tglogin, Toast.LENGTH_LONG).show();
                            if (otvet.equals("zaebis")){
                                //Toast.makeText(getActivity(), otvet, Toast.LENGTH_LONG).show();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }
    public void getposts(String message, String URL, String tglogin, String tgco) {
        //String posts;
        RequestBody requestBody = buildRequestBody(message);
        RequestBody formBody = new FormBody.Builder()
                .add("log", "Alex")
                .add("pass", "alex")
                .add("tglog", tglogin)
                .add("tgco", tgco)
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
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        Toast.makeText(getActivity(), "Something went wrong:" + " " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        call.cancel();


                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //Toast.makeText(MainActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                            String otvet = response.body().string();

                            setposts(otvet);
                            MainActivity2 main2 = (MainActivity2) getActivity();
                            main2.vkpost=otvet;
                            //Toast.makeText(getActivity(), main2.vkpost, Toast.LENGTH_LONG).show();

                                //if (otvet.equals("zaebis"))
                                    //Toast.makeText(getActivity(), otvet, Toast.LENGTH_LONG).show();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });


            }
        });
    }
}