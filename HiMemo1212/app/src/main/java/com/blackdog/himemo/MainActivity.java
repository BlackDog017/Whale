package com.blackdog.himemo;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class MainActivity  extends AppCompatActivity  {
    /**
     *
     */

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button SignIn;
    String userName;
    String passWord;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountEdit = (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        userName = accountEdit.getText().toString();
        passWord = passwordEdit.getText().toString();
        findViewById(R.id.SignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(passwordEdit.getText())&&TextUtils.isEmpty(accountEdit.getText())){
                    Toast.makeText(getApplicationContext(),
                            "请输入用户名和密码", Toast.LENGTH_SHORT)
                            .show();
                }
               else if(TextUtils.isEmpty(accountEdit.getText())){
                    Toast.makeText(getApplicationContext(),
                            "请输入用户名", Toast.LENGTH_SHORT)
                            .show();
            }
                else if(TextUtils.isEmpty(passwordEdit.getText())){
                    Toast.makeText(getApplicationContext(),
                            "请输入密码", Toast.LENGTH_SHORT)
                            .show();}
                else{
                    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
                    editor.putString("userName",userName);
                    editor.putString("passWord",passWord);
                    editor.commit();
                    Toast.makeText(getApplicationContext(),
                            "注册成功！", Toast.LENGTH_SHORT)
                            .show();
                    startActivity(new Intent(MainActivity.this, SecondAty.class));


        }
            }
        });
            findViewById(R.id.SignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(passwordEdit.getText())&&TextUtils.isEmpty(accountEdit.getText())){
                    Toast.makeText(getApplicationContext(),
                            "请输入用户名和密码", Toast.LENGTH_SHORT)
                            .show();
                }
                else if(TextUtils.isEmpty(accountEdit.getText())){
                    Toast.makeText(getApplicationContext(),
                            "请输入用户名", Toast.LENGTH_SHORT)
                            .show();
                }
                else if(TextUtils.isEmpty(passwordEdit.getText())){
                    Toast.makeText(getApplicationContext(),
                            "请输入密码", Toast.LENGTH_SHORT)
                            .show();}
                else{
                   SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                    String saveduserName = pref.getString("userName", "");
                    String savedpassWord = pref.getString("passWord","");
                    if(userName.trim().equals(saveduserName) && passWord.trim().equals(savedpassWord)) {
                        startActivity(new Intent(MainActivity.this, SecondAty.class));
                    }
                /*new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            PostTools post = new PostTools();
                            String result = post.loginPost(CommonInfo.loginURL, userName, passWord);
                            System.out.println(result);
                            if ("1".equals(result.trim())) {
                                startActivity(new Intent(MainActivity.this, SecondAty.class));//跳转成功
                            } else if ("2".equals(result.trim())) {
                              Toast.makeText(MainActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this,"网络异常",Toast.LENGTH_SHORT).show();
                            }
                        }catch (IOException e){
                                System.out.println(e.toString());
                            }
                        }


                }).start();
*/

                }
            }
            });}}

