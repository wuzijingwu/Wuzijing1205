package text.bwei.com.wuzijing1205.Api;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import text.bwei.com.wuzijing1205.ban.News;

/**
 * Created by dell on 2017/12/5.
 */

public interface ApiService {
    @POST
    Observable<News> getDatas(@Url String url, @QueryMap Map<String, String> map);


}
