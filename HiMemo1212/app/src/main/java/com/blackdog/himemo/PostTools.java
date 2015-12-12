package com.blackdog.himemo;


import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by asus on 2015/12/5.
 */
public class PostTools {


    public String loginPost(String url, String userName, String passWord) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormEncodingBuilder()
                .add("userName", userName)
                .add("passWord", passWord)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                return "Wrong";
            }
        }

    }

