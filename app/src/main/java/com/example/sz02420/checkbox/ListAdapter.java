package com.example.sz02420.checkbox;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    List<Goods> list;
    Context context;
    private LayoutInflater inflater;
    private int[] colors=new int[]{0x30FF0000,0x300000FF};

    public ListAdapter(List<Goods> list, Context context) {
        this.list=list;
        inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        int ret = 0;
        if(list!=null){
            ret = list.size();
        }
        return ret;
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        final Goods goods = (Goods) this.getItem(position);
        final ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView = inflater.inflate(R.layout.list_data, null);
            viewHolder.goodId = (TextView) convertView.findViewById(R.id.text_id);
            viewHolder.goodName = (TextView) convertView.findViewById(R.id.text_one);
            viewHolder.goodCodeBar = (TextView) convertView.findViewById(R.id.text_two);
            viewHolder.checkbox = (CheckBox) convertView.findViewById(R.id.checkbox);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

        int colorPos=position%colors.length;
        if(colorPos==1)
            convertView.setBackgroundColor(Color.rgb(255, 255, 255)); //颜色设置
        else {
            convertView.setBackgroundColor(Color.rgb(250,250,250));//颜色设置
        }

        viewHolder.goodId.setText(goods.getId());
        viewHolder.goodId.setTextSize(13);
        viewHolder.goodName.setText(goods.getGoodsName());
        viewHolder.goodName.setTextSize(13);
        viewHolder.goodCodeBar.setText(goods.getCodeBar());
        viewHolder.goodCodeBar.setTextSize(13);

        viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (goods.getIsChecked()) {
                    goods.setIsChecked(false);
                } else {
                    goods.setIsChecked(true);
                }
            }
        });
        viewHolder.checkbox.setChecked(goods.getIsChecked());
        return convertView;

    }
    class ViewHolder{
        public TextView goodId;
        public TextView goodName;
        public TextView goodCodeBar;
        public CheckBox checkbox;
    }
}