package com.cctvjiatao.commonadapter.act;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.cctvjiatao.commonadapter.R;
import com.cctvjiatao.commonadapter.adapter.ComAdapter;
import com.cctvjiatao.commonadapter.adapter.ViewHolder;
import com.cctvjiatao.commonadapter.bean.ArticleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 运用万能适配器实现复杂视图的实例
 */
public class MainActivity extends Activity {

    private List<ArticleBean> beanlist;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);

        beanlist = new ArrayList<ArticleBean>();
        for(int i=1;i<10;i++){
            ArticleBean bean = new ArticleBean("文章"+i,"内容"+i+":周三早上丢失了红色钱包，在食堂二楼","2016060"+i,"1718013691"+i);
            beanlist.add(bean);
        }

        //直接使用匿名内部类即可取得适配器
        ComAdapter mAdapter = new ComAdapter<ArticleBean>(context, beanlist, R.layout.item_example_listview) {
            @Override
            public void convert(ViewHolder holder, ArticleBean item) {//通过ViewHolder找到view，通过Item设置值
                holder.setTextView(R.id.tv_title, item.getTitle());
                holder.setTextView(R.id.tv_describe, item.getContent());
                holder.setTextView(R.id.tv_time, item.getTime());
                holder.setTextView(R.id.tv_phone, item.getPhone());
            }
        };
        listView.setAdapter(mAdapter);
    }
}
