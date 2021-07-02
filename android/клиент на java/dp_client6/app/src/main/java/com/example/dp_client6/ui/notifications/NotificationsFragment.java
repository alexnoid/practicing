package com.example.dp_client6.ui.notifications;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

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

public class NotificationsFragment extends Fragment implements View.OnClickListener {

    private String postBodyString;
    private MediaType mediaType;
    private RequestBody requestBody;
    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        //final TextView textView = root.findViewById(R.id.text_notifications);
        Button tglog = root.findViewById(R.id.button);

        tglog.setOnClickListener(this);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        return root;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                TextView co = (TextView) getView().findViewById(R.id.editTextTextPassword2);
                String tgco = co.getText().toString();
                TextView txt = (TextView) getView().findViewById(R.id.editTextTextPersonName3);
                String s = txt.getText().toString();
                //postRequest("none", "https://dpsarvar.herokuapp.com/tgupdate", s, tgco);
                MainActivity2 m2 = (MainActivity2) getActivity();
                getposts("none", m2.url+"vk", s, tgco);
                //getposts("none", m2.url+"jason", s, tgco);
                //Toast.makeText(getActivity(), m2.url+"vk", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public RequestBody buildRequestBody(String msg) {
        postBodyString = msg;
        mediaType = MediaType.parse("text/plain");
        requestBody = RequestBody.create(postBodyString, mediaType);
        return requestBody;
    }


    public void getposts(String message, String URL, String tglogin, String tgco) {
        //String posts;
        MainActivity2 main = (MainActivity2) getActivity();

        RequestBody requestBody = buildRequestBody(message);
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

                            MainActivity2 main2 = (MainActivity2) getActivity();
                            main2.tgpost=otvet;
                            //Toast.makeText(getActivity(), main2.tgpost, Toast.LENGTH_LONG).show();

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