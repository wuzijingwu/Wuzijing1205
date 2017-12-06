package text.bwei.com.wuzijing1205.presenter;

import java.util.List;

import text.bwei.com.wuzijing1205.ban.News;
import text.bwei.com.wuzijing1205.model.Imodel;
import text.bwei.com.wuzijing1205.model.Onselect;
import text.bwei.com.wuzijing1205.model.model;
import text.bwei.com.wuzijing1205.view.Iview;

/**
 * Created by dell on 2017/12/5.
 */

public class presenter {
    Imodel imodel;
    Iview iview;

    public presenter(Iview iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getOk(String url, String key, int num) {
        imodel.RequestSuccess(url, key, num, new Onselect() {
            @Override
            public void dataSuccess(List<News.NewslistBean> list) {
                iview.showSuccess(list);
            }

            @Override
            public void dataError(String s) {

            }
        });

    }

}
