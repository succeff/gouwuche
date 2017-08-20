package com.bwie.gouwuche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import bean.Three;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        final Intent intent = getIntent();
        final  String shoujihao = intent.getStringExtra("shoujihao");
        final EditText password = (EditText) findViewById(R.id.mima);
        Button button = (Button) findViewById(R.id.xiayibu2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://api.eleteam.com/v1/user/register-step2?mobile="+shoujihao+"&&password="+password.getText().toString();
                RequestParams params = new RequestParams(url);
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Three three = new Gson().fromJson(result,Three.class);
                        int code = three.getCode();

                        if(code==1){
                            Intent it = new Intent(ThreeActivity.this,FourActivity.class);
                            it.putExtra("shoujihao",shoujihao);
                            it.putExtra("mima",password.getText().toString());
                            startActivity(it);
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
        });
    }
}
