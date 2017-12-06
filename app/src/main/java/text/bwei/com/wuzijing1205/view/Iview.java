package text.bwei.com.wuzijing1205.view;

import java.util.List;

import text.bwei.com.wuzijing1205.ban.News;

/**
 * Created by dell on 2017/12/5.
 */

public interface Iview {
    void showSuccess(List<News.NewslistBean> list);
    void showError(String s);
}
