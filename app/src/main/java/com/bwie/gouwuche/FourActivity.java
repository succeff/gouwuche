package com.bwie.gouwuche;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import bean.Four;

public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        Intent intent = getIntent();
        final String shoujihao = intent.getStringExtra("shoujihao");
        final String mima = intent.getStringExtra("mima");
        final EditText yanzhengma = (EditText) findViewById(R.id.yanzhengma);
        Button butt = (Button) findViewById(R.id.xiayibu3);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://api.eleteam.com/v1/user/register-step3?mobile="+shoujihao+"&&password="+mima+"&&code="+yanzhengma.getText().toString();
                RequestParams params = new RequestParams(url);
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Four four = new Gson().fromJson(result, Four.class);
                        int code = four.getCode();
                        if(code==1) {
                            Intent inten = new Intent(FourActivity.this, OneActivity.class);
                            startActivity(inten);
                        }
                        runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(FourActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                }
                            });

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
            }
        });
    }
}
