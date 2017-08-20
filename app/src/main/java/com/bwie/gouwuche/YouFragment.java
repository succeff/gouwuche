package com.bwie.gouwuche;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapterP;
import adapter.SpacesItemDecoration;
import bean.DataP;


/**
 * 类的描述：
 * 时间：  2017/8/11.15:21
 * 姓名：chenlong
 */
public class YouFragment extends Fragment{
    XRecyclerView recyclerView;
    private String url = "http://api.eleteam.com/v1/product/list-featured-price";
    List<DataP.DataBean.ProductsBean> list = new ArrayList<>();
    private MyAdapterP adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.you_fragment,container,false);
        LoadView();
        reaView(view);
        return view;
    }

    private void reaView(View view) {
        recyclerView = view.findViewById(R.id.recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapterP(getContext(),list);
        recyclerView.setAdapter(adapter);
        SpacesItemDecoration decoration=new SpacesItemDecoration(5);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.refreshComplete();
                        adapter.notifyDataSetChanged();
                    }
                },1000);

            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.loadMoreComplete();
                    }
                },1000);

            }
        });
    }

    private void  LoadView() {
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                DataP dataP = new Gson().fromJson(result, DataP.class);
                list.addAll(dataP.getData().getProducts());
                adapter.notifyDataSetChanged();
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
