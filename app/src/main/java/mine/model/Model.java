package mine.model;

import java.util.HashMap;
import java.util.Map;

import bean.Login;
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
    public void getdata(String id, String pass, final Loginset loginset) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",id);
        map.put("password",pass);
        Observable<Login> dengLu = RetroFactory.build(Api.Login).getDengLu("user/login", map);
        dengLu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Login>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Login login) {
                          loginset.set(login);
                    }
                });
    }

    @Override
    public void zc(String id, String pass, final Loginset loginset) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",id);
        map.put("password",pass);
        Observable<Login> dengLu = RetroFactory.build(Api.Login).getDengLu("user/reg", map);
        dengLu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Login>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Login login) {
                        loginset.set(login);
                    }
                });
    }
}
