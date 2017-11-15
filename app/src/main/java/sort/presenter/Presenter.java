package sort.presenter;

import bean.Sort_lift;
import bean.Sort_right;
import sort.model.Liftset;
import sort.model.Model;
import sort.model.Rightset;
import sort.view.Iview;

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
    public void Left(){
        model.getlift(new Liftset() {
            @Override
            public void setlift(Sort_lift sort_lift) {
                iview.setlift(sort_lift);
            }
        });
    }
    public void Right(String page){
        model.getright(page, new Rightset() {
            @Override
            public void setright(Sort_right sort_right) {
                iview.setright(sort_right);
            }
        });
    }
}
