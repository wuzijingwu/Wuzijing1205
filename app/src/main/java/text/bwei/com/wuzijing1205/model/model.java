package text.bwei.com.wuzijing1205.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import text.bwei.com.wuzijing1205.Api.ApiService;
import text.bwei.com.wuzijing1205.ban.News;

/**
 * Created by dell on 2017/12/5.
 */

public class model implements Imodel{


    @Override
    public void RequestSuccess(String url, String key, int num, final Onselect onselect) {

       Map<String, String> map = new HashMap<>();
        map.put("key",key);
        map.put("num",num+"");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<News> datas = apiService.getDatas("nba/", map);

        datas.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<News>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(News news) {
                        List<News.NewslistBean> newslist = news.getNewslist();
                        onselect.dataSuccess(newslist);

                    }
                });

    }


}
