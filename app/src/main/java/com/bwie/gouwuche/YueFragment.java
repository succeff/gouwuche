package com.bwie.gouwuche;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import adapter.MyAdapter1;
import adapter.MyAdapter2;
import bean.DataYou;

import static android.R.attr.bitmap;


@ContentView(R.layout.activity_yue_fragment)
public class YueFragment extends Fragment {
    private List<DataYou.DataBean.CategoriesBean> list_tui = new ArrayList<>();
    private List<DataYou.DataBean.CategoriesBean.ProductsBean> list = new ArrayList<>();

    private ListView lv1,lv2;
    private MyAdapter1 adapter1;
    private MyAdapter2 adapter2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = x.view().inject(this, inflater, container);
        loadView();
        initView(view);
        return view;
    }
    private void initView(View view) {
        lv1 = view.findViewById(R.id.list_item_1);
        lv2 = view.findViewById(R.id.list_item_2);
        adapter1 = new MyAdapter1(list_tui,getContext());


        lv1.setAdapter(adapter1);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                adapter1.setSelectItem(position);
                adapter2 = new MyAdapter2(list_tui.get(position).getProducts(), getContext());
                lv2.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();
            }
        });

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("image",list_tui.get(position).getProducts().get(0).getImage_small());
                intent.putExtra("name",list_tui.get(position).getProducts().get(0).getName());
                intent.putExtra("price",list_tui.get(position).getProducts().get(0).getPrice());
                intent.putExtra("feat_price",list_tui.get(position).getProducts().get(0).getFeatured_price());
                intent.putExtra("count",list_tui.get(position).getProducts().get(0).getShort_description());
                startActivity(intent);
            }
        });
    }

    private void loadView() {
        String url = "http://api.eleteam.com/v1/category/list-with-product";
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                DataYou data = new Gson().fromJson(result, DataYou.class);
                list_tui.addAll(data.getData().getCategories());
                adapter1.notifyDataSetChanged();
                adapter2.notifyDataSetChanged();
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
