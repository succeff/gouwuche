package com.bwie.gouwuche;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.R.attr.button;

/**
 * 类的描述：
 * 时间：  2017/8/11.15:30
 * 姓名：chenlong
 */

public class MineFragment extends Fragment {
    ImageView iam;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_mine_fragment, container, false);
        iam = view.findViewById(R.id.login);
        iam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), OneActivity.class);
                startActivity(intent);
            }
        });
        return view;

    }
}
