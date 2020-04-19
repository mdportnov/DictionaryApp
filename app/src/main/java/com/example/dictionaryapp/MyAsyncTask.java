package com.example.dictionaryapp;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyAsyncTask extends AsyncTask<String, Void, String> {

    private OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... strings) {
        Request request = new Request.Builder()
                .url(strings[0] + strings[1])
                .addHeader("x-rapidapi-key", "mykey")
                .addHeader("x-rapidapi-host", "lingua-robot.p.rapidapi.com")
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}