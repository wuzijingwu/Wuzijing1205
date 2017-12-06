package text.bwei.com.wuzijing1205;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import text.bwei.com.wuzijing1205.Api.Api;
import text.bwei.com.wuzijing1205.adapter.MyAdpater;
import text.bwei.com.wuzijing1205.ban.News;
import text.bwei.com.wuzijing1205.presenter.presenter;
import text.bwei.com.wuzijing1205.view.Iview;

public class MainActivity extends AppCompatActivity implements Iview {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private text.bwei.com.wuzijing1205.presenter.presenter presenter;
    int num = 10;
    private MyAdpater myAdpater;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swip);
        presenter = new presenter(this);
        presenter.getOk(Api.UYT, Api.key, num);


    }


    @Override
    public void showSuccess(final List<News.NewslistBean> list) {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdpater = new MyAdpater(list, this);
        recyclerView.setAdapter(myAdpater);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getOk(Api.UYT, Api.key, num++);
                myAdpater.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (lastVisibleItemPosition == list.size() - 1) {
                    presenter.getOk(Api.UYT, Api.key, num++);
                    myAdpater.notifyDataSetChanged();
                }


            }
        });


    }

    @Override
    public void showError(String s) {

    }
}
