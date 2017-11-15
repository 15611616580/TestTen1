package mine.presenter;


import bean.Login;
import mine.model.Loginset;
import mine.model.Model;
import mine.view.Iview;

/**
 * Created by 郭宝 on 2017/11/14.
 */

public class Presenter {
    private Iview iview;
    private Model model;

    public Presenter(Iview iview) {
        this.iview = iview;
        this.model = new Model();
    }

    public void Login(String id,String pass){
        model.getdata(id, pass, new Loginset() {
            @Override
            public void set(Login login) {
                iview.login(login);
            }
        });
    }
    public void zc(String id,String pass){
        model.zc(id, pass, new Loginset() {
            @Override
            public void set(Login login) {
                iview.zc(login);
            }
        });
    }
}
