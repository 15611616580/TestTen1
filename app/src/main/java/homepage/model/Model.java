package homepage.model;

import bean.HomeBean;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.Api;
import utils.RetroFactory;

/**
 * Created by 郭宝 on 2017/11/14.
 */

public class Model implements Imodel {
    @Override
    public void getdata(final Homeset homeset) {
        final Observable<HomeBean> home = RetroFactory.build(Api.PRO_URL).getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        homeset.set(homeBean);
                    }
                });
    }
}
