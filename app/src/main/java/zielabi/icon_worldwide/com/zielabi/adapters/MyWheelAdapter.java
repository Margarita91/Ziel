package zielabi.icon_worldwide.com.zielabi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wx.wheelview.adapter.BaseWheelAdapter;

import java.util.ArrayList;

import zielabi.icon_worldwide.com.zielabi.R;
import zielabi.icon_worldwide.com.zielabi.models.State;

/**
 * Created by margarita on 24/08/2017.
 */

public class MyWheelAdapter extends BaseWheelAdapter<String> {

    private Context mContext;

    public MyWheelAdapter(Context context) {
        mContext = context;
    }

    @Override
    protected View bindView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_state, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.state_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(mList.get(position));
        return convertView;
    }

    static class ViewHolder {
        TextView textView;
    }
}