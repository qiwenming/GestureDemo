package com.qwm.gesturedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * <b>Project:</b> eventdemo<br>
 * <b>Create Date:</b> 2017/4/1<br>
 * <b>Author:</b> qiwenming<br>
 * <b>Description:</b> <br>
 */
public class MyGridAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private List<String> mList;
    private Context mContext;

    public MyGridAdapter(Context mContext, List<String> list){
        this.mContext = mContext;
        this.mList = list;
        this.inflater = LayoutInflater.from(mContext);
    }

    public void resetData(List<String> list){
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }


    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.gridview_item,null);
        ViewHolder hodler = null;
        if(convertView==null){
            convertView = view;
            hodler = new ViewHolder();
            hodler.tv = (TextView)view.findViewById(R.id.tv_text);
            convertView.setTag(hodler);
        }else{
            hodler = (ViewHolder) convertView.getTag();
        }
        hodler.tv.setText(mList.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView tv;
    }
}
