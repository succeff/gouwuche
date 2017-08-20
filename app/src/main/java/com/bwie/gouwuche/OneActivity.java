package com.bwie.gouwuche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.IOException;

public class OneActivity extends AppCompatActivity {
    private EditText names;
    private EditText pas;
    private Button but;
    private Button zhuce;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        zhuce = (Button)findViewById(R.id.zhu);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OneActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });

        loginView();
    }
    private void loginView() {
        names = (EditText) findViewById(R.id.name);
        pas = (EditText) findViewById(R.id.pass);
        but = (Button) findViewById(R.id.login);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://api.eleteam.com/v1/user/login?mobile="+names.getText().toString()+"&&password="+pas.getText().toString();
                final RequestParams params = new RequestParams(url);
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(final String result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(OneActivity.this,result,Toast.LENGTH_SHORT).show();
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
