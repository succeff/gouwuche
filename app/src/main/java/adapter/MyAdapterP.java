package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.gouwuche.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.List;

import bean.DataP;


/**
 * 类的描述：
 * 时间：  2017/8/16.14:50
 * 姓名：chenlong
 */
public class MyAdapterP extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
   private  Context context;
   private  List<DataP.DataBean.ProductsBean> list;

    public MyAdapterP(Context context, List<DataP.DataBean.ProductsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(XRecyclerView.ViewHolder holder, int position) {
        ViewHolder ho = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getImage_small()).into(ho.ima);
        ho.tit.setText(list.get(position).getName());
        ho.cont.setText(list.get(position).getShort_description());
        ho.price.setText("￥"+list.get(position).getPrice());
        ho.oldprice.setText("￥"+list.get(position).getFeatured_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ima;
        TextView tit;
        TextView cont;
        TextView price;
        TextView oldprice;

        public ViewHolder(View view) {
            super(view);
            ima = view.findViewById(R.id.image);
            tit = view.findViewById(R.id.title);
            cont = view.findViewById(R.id.cont);
            price = view.findViewById(R.id.price);
            oldprice = view.findViewById(R.id.oldprice);
        }
    }
}
