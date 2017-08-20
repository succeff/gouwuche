package com.bwie.gouwuche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;

import bean.Three;

public class TwoActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        final EditText shoujihao   = (EditText) findViewById(R.id.shoujihao);
        Button xiayibu   = (Button) findViewById(R.id.xiayibu);
        xiayibu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shoujihao.getText().toString()!=null){
                    String url = "http://api.eleteam.com/v1/user/register-step1?mobile="+shoujihao.getText().toString();
                    RequestParams params = new RequestParams(url);
                    x.http().get(params, new Callback.CommonCallback<String>() {
                        @Override
                        public void onSuccess(String result) {
                            Three three = new Gson().fromJson(result,Three.class);
                            int code = three.getCode();
                            if(code==1){
                                Intent intent = new Intent(TwoActivity.this, ThreeActivity.class);
                                intent.putExtra("shoujihao",shoujihao.getText().toString());
                                startActivity(intent);
                            }
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
            }
        });

    }
}
