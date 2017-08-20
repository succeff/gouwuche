package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * 类的描述：
 * 时间：  2017/8/11.15:39
 * 姓名：chenlong
 */

public class FragAdapter extends FragmentPagerAdapter{
    private List<Fragment> list;
    private List<String> list_tab;

    public FragAdapter(FragmentManager fm, List<Fragment> list, List<String> list_tab) {
        super(fm);
        this.list = list;
        this.list_tab = list_tab;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return list_tab.get(position);
    }
}
