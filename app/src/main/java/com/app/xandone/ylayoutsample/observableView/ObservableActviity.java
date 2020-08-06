package com.app.xandone.ylayoutsample.observableView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.app.xandone.ylayoutsample.BaseActivity;
import com.app.xandone.ylayoutsample.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author: xandone
 * created on: 2018/1/29 10:03
 */

public class ObservableActviity extends BaseActivity implements ObservableScrollView.OnScrollListener {
    private RecyclerView recycler_1;
    private RecyclerView recycler_2;
    private RecyclerView recycler_3;
    private RecyclerView recycler_4;
    private TextView tv_title_1;
    private TextView tv_title_2;
    private TextView tv_title_3;
    private TextView tv_title_4;
    private TextView tv_title_hide_1;
    private TextView tv_title_hide_2;
    private TextView tv_title_hide_3;
    private TextView tv_title_hide_4;

    private ObservableScrollView scrollview;

    private List<String> list1;
    private List<String> list2;
    private List<String> list3;
    private List<String> list4;

    private Adapter adapter1;
    private Adapter adapter2;
    private Adapter adapter3;
    private Adapter adapter4;

    @Override
    protected int setLayout() {
        return R.layout.observable_scrollview_layout;
    }

    @Override
    protected void init() {
        recycler_1 = (RecyclerView) findViewById(R.id.recycler_1);
        recycler_2 = (RecyclerView) findViewById(R.id.recycler_2);
        recycler_3 = (RecyclerView) findViewById(R.id.recycler_3);
        recycler_4 = (RecyclerView) findViewById(R.id.recycler_4);

        tv_title_1 = (TextView) findViewById(R.id.tv_title_1);
        tv_title_2 = (TextView) findViewById(R.id.tv_title_2);
        tv_title_3 = (TextView) findViewById(R.id.tv_title_3);
        tv_title_4 = (TextView) findViewById(R.id.tv_title_4);

        tv_title_hide_1 = (TextView) findViewById(R.id.tv_title_hide_1);
        tv_title_hide_2 = (TextView) findViewById(R.id.tv_title_hide_2);
        tv_title_hide_3 = (TextView) findViewById(R.id.tv_title_hide_3);
        tv_title_hide_4 = (TextView) findViewById(R.id.tv_title_hide_4);

        scrollview = (ObservableScrollView) findViewById(R.id.scrollview);

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();

        list1.add("今天下雪___1");
        list1.add("今天下雪___2");
        list1.add("今天下雪___3");
        list1.add("今天下雪___4");

        list2.add("今天下雪___1");
        list2.add("今天下雪___2");
        list2.add("今天下雪___3");
        list2.add("今天下雪___3");
        list2.add("今天下雪___3");
        list2.add("今天下雪___3");
        list2.add("今天下雪___3");

        list3.add("今天下雪___1");
        list3.add("今天下雪___2");
        list3.add("今天下雪___3");
        list3.add("今天下雪___3");
        list3.add("今天下雪___3");
        list3.add("今天下雪___3");
        list3.add("今天下雪___4");

        list4.add("今天下雪___1");
        list4.add("今天下雪___1");
        list4.add("今天下雪___1");
        list4.add("今天下雪___1");
        list4.add("今天下雪___2");
        list4.add("今天下雪___3");
        list4.add("今天下雪___4");
        list4.add("今天下雪___5");
        list4.add("今天下雪___6");

        adapter1 = new Adapter(list1);
        adapter2 = new Adapter(list2);
        adapter3 = new Adapter(list3);
        adapter4 = new Adapter(list4);

        recycler_1.setAdapter(adapter1);
        recycler_2.setAdapter(adapter2);
        recycler_3.setAdapter(adapter3);
        recycler_4.setAdapter(adapter4);

        recycler_1.setLayoutManager(new LinearLayoutManager(this));
        recycler_2.setLayoutManager(new LinearLayoutManager(this));
        recycler_3.setLayoutManager(new LinearLayoutManager(this));
        recycler_4.setLayoutManager(new LinearLayoutManager(this));

        scrollview.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                onScroll(scrollview.getScrollY());
            }
        });

        scrollview.setOnScrollListener(this);

    }

    @Override
    public void onScroll(int scrollY) {
        tv_title_hide_1.setTranslationY(Math.max(tv_title_1.getTop(), scrollY));
        tv_title_hide_2.setTranslationY(Math.max(tv_title_2.getTop(), scrollY));
        tv_title_hide_3.setTranslationY(Math.max(tv_title_3.getTop(), scrollY));
        tv_title_hide_4.setTranslationY(Math.max(tv_title_4.getTop(), scrollY));
    }

    class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private List<String> datas;

        public Adapter(List<String> datas) {
            this.datas = datas;
        }


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ObservableActviity.this).inflate(R.layout.item_observale_layout, parent, false);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyHolder) {
                MyHolder myHolder = (MyHolder) holder;
                myHolder.bindView(position);
            }
        }

        @Override
        public int getItemCount() {
            return datas == null ? 0 : datas.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView tv_name_1;

            public MyHolder(View itemView) {
                super(itemView);
                tv_name_1 = itemView.findViewById(R.id.tv_name_1);
            }

            public void bindView(int position) {
                tv_name_1.setText(datas.get(position));
            }
        }
    }
}
