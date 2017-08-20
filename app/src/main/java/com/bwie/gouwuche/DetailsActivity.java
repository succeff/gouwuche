package com.bwie.gouwuche;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.xutils.x;


public class DetailsActivity extends AppCompatActivity {
    ImageView ima;
    TextView title,priceds,fpriceds,conteds;
    Button gous,jies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        x.view().inject(this);
        loadView();
    }

    private void loadView() {
        title = (TextView) findViewById(R.id.title);
        priceds = (TextView) findViewById(R.id.prices);
        fpriceds = (TextView) findViewById(R.id.f_prices);
        conteds = (TextView) findViewById(R.id.counts);
        ima = (ImageView) findViewById(R.id.image);
        gous = (Button) findViewById(R.id.gou);
        jies = (Button) findViewById(R.id.jie);
        Intent intent = getIntent();
        String image = intent.getStringExtra("image");
        Glide.with(this).load(image).into(ima);
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String feat_price = intent.getStringExtra("feat_price");
        String count = intent.getStringExtra("count");
        title.setText(name);
        priceds.setText("￥"+price);
        fpriceds.setText("￥"+feat_price);
        conteds.setText(count);
        gous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this,"成功加入购物车",Toast.LENGTH_SHORT).show();
            }
        });
        jies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailsActivity.this,"成功结算",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
