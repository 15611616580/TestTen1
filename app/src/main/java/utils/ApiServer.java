package utils;



import java.util.Map;

import bean.Login;
import bean.Sort_lift;
import bean.Sort_right;
import bean.HomeBean;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {
//
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();
    @POST
    Observable<Login> getDengLu(@Url String name, @QueryMap Map<String, String> paw);
    @GET("mobile/index.php?act=goods_class")
    Observable<Sort_lift> lift();
    @GET("mobile/index.php?act=goods_class&gc_id")
    Observable<Sort_right> right(@Query("gc_id") String s);





}
