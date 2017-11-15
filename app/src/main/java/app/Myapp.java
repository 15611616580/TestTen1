package app;

import android.app.Application;

import com.bwie.imageloderlibrary.ImageloderUtils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by 郭宝 on 2017/11/14.
 */

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = Utils.configuration(this);
        ImageLoader.getInstance().init(configuration);
    }
}
