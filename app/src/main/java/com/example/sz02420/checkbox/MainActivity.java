package com.example.sz02420.checkbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sz02420.checkbox.util.DrawableUtil;

public class MainActivity extends Activity {
    Button btn_clear;
    Button btn_output;
    EditText edit_search;
    ImageButton btn_add;
    ListView listView;
    ListAdapter adapter;
    CheckBox checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkbox = (CheckBox) findViewById(R.id.checkbox);// 全选
        listView = (ListView) findViewById(R.id.list_data);// 价格
        edit_search=(EditText) findViewById(R.id.edit_search);
        btn_clear=(Button)findViewById(R.id.btn_clear);
        btn_output=(Button)findViewById(R.id.btn_output);
        btn_add=(ImageButton)findViewById(R.id.btn_add);

        final List<Goods> list = new ArrayList<Goods>();
        for(int i=0;i<20;i++)
        {
            Goods good=new Goods();
            good.setId(i+"");
            good.setIsChecked(false);
            good.setGoodsName("伊利婴儿加盖奶粉110ml");
            good.setCodeBar("982323423232");
            list.add(good);
        }
        // 适配
        adapter = new ListAdapter(list, MainActivity.this);
        listView.setAdapter(adapter);

        // 全选
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
            if(isCheck) {
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setIsChecked(true);
                }
            }else{
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setIsChecked(false);
                }
            }
            // 刷新
            adapter.notifyDataSetChanged();
            }
        });

        // 绑定listView的监听器
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int arg2,
                                    long arg3) {
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                final View dialogView = factory.inflate(R.layout.dialog_data, null);
                TextView text_one = (TextView) v.findViewById(R.id.text_one);
                EditText edit_one = (EditText) dialogView.findViewById(R.id.edit_one);
                edit_one.setText(text_one.getText().toString());
                TextView text_two = (TextView) v.findViewById(R.id.text_two);
                EditText edit_two = (EditText) dialogView.findViewById(R.id.edit_two);
                edit_two.setText(text_two.getText().toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialog);
                builder.setTitle("数据修改").setView(dialogView);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });
                builder.show();
            }
        });

        DrawableUtil drawableUtil = new DrawableUtil(edit_search, new DrawableUtil.OnDrawableListener() {
            @Override
            public void onRight(View v, Drawable right) {

            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialog);
                builder.setTitle("数据清除");
                builder.setMessage("确定清除所选数据吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });
                builder.show();
            }
        });

        btn_output.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialog);
                builder.setTitle("数据导出");
                builder.setMessage("确定导出所选数据吗？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        for (int i=0;i<list.size();i++){
                            Log.e("ee",list.get(i).getIsChecked()+""+list.get(i).getId());
                        }
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });
                builder.show();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(MainActivity.this);
                final View textEntryView = factory.inflate(R.layout.dialog_data, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, R.style.AlertDialog);
                builder.setTitle("数据添加");
                builder.setView(textEntryView);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                    }
                });
                builder.show();
            }
        });

    }

}