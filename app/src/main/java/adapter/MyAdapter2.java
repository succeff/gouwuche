package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.gouwuche.R;

import java.util.List;

import bean.DataYou;

/**
 * 类的描述：
 * 时间：  2017/8/11.20:53
 * 姓名：chenlong
 */

public class MyAdapter2 extends BaseAdapter{
    private List<DataYou.DataBean.CategoriesBean.ProductsBean> list;
    private final Context context;

    public MyAdapter2(List<DataYou.DataBean.CategoriesBean.ProductsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.right_listview, null);
            vh = new ViewHolder();
            vh.image = convertView.findViewById(R.id.image);
            vh.tv = convertView.findViewById(R.id.title);
            vh.price = convertView.findViewById(R.id.price);
            vh.youprice = convertView.findViewById(R.id.youprice);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImage_small()).into(vh.image);
        vh.tv.setText(list.get(position).getName());
        vh.price.setText("￥"+list.get(position).getPrice());
        vh.youprice.setText("￥"+list.get(position).getFeatured_price());
        return convertView;
    }


    class ViewHolder {
        ImageView image;
        TextView tv;
        TextView price;
        TextView youprice;

    }
}
