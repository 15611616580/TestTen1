package sort.model;

import bean.Sort_lift;
import bean.Sort_right;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import utils.Api;
import utils.RetroFactory;

/**
 * Created by 郭宝 on 2017/11/14.
 */

public class Model implements Imodel{

    @Override
    public void getlift(final Liftset liftset) {
        Observable<Sort_lift> lift = RetroFactory.build(Api.Sort).lift();
        lift.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Sort_lift>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Sort_lift sort_lift) {
                        liftset.setlift(sort_lift);
                    }
                });
    }

    @Override
    public void getright(String page, final Rightset rightset) {
        Observable<Sort_right> lift = RetroFactory.build(Api.Sort).right(page);
        lift.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Sort_right>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Sort_right sort_right) {
                        rightset.setright(sort_right);
                    }
                });
    }
}
