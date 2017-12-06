package text.bwei.com.wuzijing1205.model;

import java.util.List;

import text.bwei.com.wuzijing1205.ban.News;

/**
 * Created by dell on 2017/12/5.
 */

public interface Onselect {
    void dataSuccess(List<News.NewslistBean> list);
    void dataError(String s);

}
