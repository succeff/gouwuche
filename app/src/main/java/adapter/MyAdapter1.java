package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.gouwuche.R;

import java.util.List;

import bean.DataYou;

/**
 * 类的描述：
 * 时间：  2017/8/11.20:47
 * 姓名：chenlong
 */

public class MyAdapter1 extends BaseAdapter {
    private List<DataYou.DataBean.CategoriesBean> list;
    private final Context context;
    private int selectItem=0;

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
        notifyDataSetChanged();
    }

    public MyAdapter1(List<DataYou.DataBean.CategoriesBean> list, Context context) {
        this.list = list;
        this.context = context;
        notifyDataSetChanged();
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
            convertView = View.inflate(context, R.layout.left_listview, null);
            vh = new ViewHolder();
            vh.tv = convertView.findViewById(R.id.title);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tv.setText(list.get(position).getName());
        if (selectItem == position) {
            vh.tv.setTextColor(Color.BLUE);
        }else {
            vh.tv.setTextColor(Color.BLACK);
    }
        return convertView;
    }


    class ViewHolder {
        TextView tv;
    }
}
