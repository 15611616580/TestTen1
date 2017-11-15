package homepage.presenter;


import bean.HomeBean;
import homepage.model.Homeset;
import homepage.model.Model;
import homepage.view.Iview;

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
    public void homedata(){
        model.getdata(new Homeset() {
            @Override
            public void set(HomeBean homeBean) {
                iview.setdata(homeBean);
            }
        });
    }
}
