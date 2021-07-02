package com.example.dp_client6.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableList;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.dp_client6.EndlessRecyclerOnScrollListener;
import com.example.dp_client6.MainActivity2;
import com.example.dp_client6.Post;
import com.example.dp_client6.PostAdapter;
import com.example.dp_client6.R;
import com.example.dp_client6.ui.notifications.NotificationsViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import static androidx.recyclerview.widget.RecyclerView.*;


public class HomeFragment extends Fragment {
    private String postBodyString;
    private MediaType mediaType;
    private RequestBody requestBody;
    private NotificationsViewModel notificationsViewModel;
    private final OkHttpClient httpClient = new OkHttpClient();
    private HomeViewModel homeViewModel;
    public String next="0";
    public ImageView image1;
    ArrayList<Post> posts = new ArrayList<Post>();
    Bitmap bitm;
    boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    public void setVisibleItemCount(int visibleItemCount) {
        this.visibleItemCount = visibleItemCount;
    }
    public void setPastVisiblesItems(int pastVisiblesItems){
        this.pastVisiblesItems = pastVisiblesItems;
    }
    public void setTotalItemCount(int totalItemCount){
        this.totalItemCount = totalItemCount;
    }
    public void setLoading(boolean loading){
        this.loading = loading;
    }
    public int getVisibleItemCount() {
        return this.visibleItemCount;
    }
    public int getPastVisiblesItems(){
        return this.pastVisiblesItems;
    }
    public int getTotalItemCount(){
        return this.totalItemCount;
    }
    public boolean getLoading(){
        return this.loading;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstancepost) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView cycle = (RecyclerView) root.findViewById(R.id.cycle);
        LinearLayoutManager mLayoutManager = (LinearLayoutManager) cycle.getLayoutManager();
        //cycle.setLayoutManager(mLayoutManager);
        boolean loading = true;
        int pastVisiblesItems, visibleItemCount, totalItemCount;
        cycle.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "идет обновление"+next, Toast.LENGTH_SHORT).show();
                RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.cycle);
                risevk();
                risetg();
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //posts.clear();
                MainActivity2 m = (MainActivity2) getActivity();
                RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.cycle);
                // создаем адаптер
                PostAdapter adapter = new PostAdapter(getActivity(), posts);
                // устанавливаем для списка адаптер
                recyclerView.setAdapter(adapter);
                risevk();
                risetg();
                //recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        return root;

    }
    public void risevk(){
        //Toast.makeText(getActivity(), next, Toast.LENGTH_SHORT).show();
        //textView.setText(s);
        MainActivity2 m = (MainActivity2) getActivity();
        getposts("none", m.url+"jason", "", "");
        //getposts("none", m.url+"jason", "", "");
        //Toast.makeText(getActivity(), "сменился", Toast.LENGTH_SHORT).show();
        if (!m.tgpost.equals("0")) {
            try {

                JSONObject Jobject = new JSONObject(m.tgpost);
                JSONArray array = Jobject.getJSONArray("next");
                JSONObject obj = array.getJSONObject(0);
                next = obj.getString("nex");
                for (int k=1; k<3; k++) {
                    JSONArray Jarray = Jobject.getJSONArray("message"+String.valueOf(k));
                    for (int i = 0; i < Jarray.length(); i++) {
                        try {
                            JSONObject object1 = Jarray.getJSONObject(i);
                            String id = object1.getString("id");
                            String photoid = object1.getString("photo.id");
                            String text = object1.getString("text");
                            //Toast.makeText(getActivity(), id.toString(), Toast.LENGTH_SHORT).show();
                            posts.add(new Post(id, text, photoid));

                        } catch (JSONException e) {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }

            } catch (JSONException e) {
                Toast.makeText(getActivity(), e.getMessage() + m.tgpost, Toast.LENGTH_SHORT).show();

            }

        }
    }
    public void risetg(){
        //Toast.makeText(getActivity(), next, Toast.LENGTH_SHORT).show();
        //textView.setText(s);
        MainActivity2 m = (MainActivity2) getActivity();
        getvk("none", m.url+"tgposts", "", "");
        //Toast.makeText(getActivity(), "сменился", Toast.LENGTH_SHORT).show();
        if (!m.vkpost.equals("0")) {
            //Toast.makeText(getActivity(), "сменился", Toast.LENGTH_SHORT).show();
            try {
                JSONObject Jobject = new JSONObject(m.vkpost);
                for (int k=1; k<2; k++) {
                    JSONArray Jarray = Jobject.getJSONArray("message"+String.valueOf(k));
                    for (int i = 0; i < Jarray.length(); i++) {
                        try {
                            JSONObject object1 = Jarray.getJSONObject(i);
                            String id = object1.getString("id");
                            String photoid = object1.getString("photo.id");
                            String text = object1.getString("text");
                            //Toast.makeText(getActivity(), id.toString(), Toast.LENGTH_SHORT).show();

                            posts.add(new Post(id, text, photoid));

                        } catch (JSONException e) {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            ;
                        }
                    }
                }

            } catch (JSONException e) {
                Toast.makeText(getActivity(), e.getMessage() + m.vkpost, Toast.LENGTH_SHORT).show();

            }
        }
    }
    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    } // Author: s
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
                .add("next", next)
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
    public void getvk(String message, String URL, String tglogin, String tgco) {
        //String posts;
        MainActivity2 main = (MainActivity2) getActivity();

        RequestBody requestBody = buildRequestBody(message);
        RequestBody formBody = new FormBody.Builder()
                .add("log", main.LOGIN)
                .add("pass", main.PASSWOR)
                .add("tglog", tglogin)
                .add("tgco", tgco)
                .add("next", next)
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
                            main2.vkpost=otvet;
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