package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.imageloderlibrary.ImageloderUtils.Utils;
import com.bwie.testten.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import bean.HomeBean;

/**
 * Created by 郭宝 on 2017/10/16.
 */

public  class HomeAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    private HomeBean.DataBean bean;
    private Context context;
    private int TYPE_1=0;
    private int TYPE_2=1;
    private int TYPE_3=2;
    private int TYPE_4=3;
    private List<String> list;
    private List<Integer> list2;

    public HomeAdapter(HomeBean.DataBean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           switch (viewType){
               case 0:
                   View inflate = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
                   MyViewHolder myViewHolder=new MyViewHolder(inflate);
                   return myViewHolder;
               case 1:
                   View inflate2 = LayoutInflater.from(context).inflate(R.layout.item_home2, parent, false);
                   MyViewHolder1 myViewHolder1=new MyViewHolder1(inflate2);
                   return myViewHolder1;
               case 2:
                   View inflate3 = LayoutInflater.from(context).inflate(R.layout.item_home3, parent, false);
                   MyViewHolder2 myViewHolder2=new MyViewHolder2(inflate3);
                   return myViewHolder2;
               case 3:
                   View inflate4 = LayoutInflater.from(context).inflate(R.layout.item_home4, parent, false);
                   MyViewHolder3 myViewHolder3=new MyViewHolder3(inflate4);
                   return myViewHolder3;
           }
          return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DisplayImageOptions options = Utils.options();
        list = new ArrayList<>();
        List<HomeBean.DataBean.Ad1Bean> ad1 = bean.getAd1();
        for (int i=0;i<bean.getAd1().size();i++){
            list.add(ad1.get(i).getImage());
        }
        if(holder instanceof MyViewHolder){

            ((MyViewHolder) holder).banner.setDelayTime(2000);
            ((MyViewHolder) holder).banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
            ((MyViewHolder) holder).banner.setImages(list);

        }else if(holder instanceof MyViewHolder1){
                ((MyViewHolder1) holder).text1.setText(bean.getAd5().get(0).getTitle());
                ImageLoader.getInstance().displayImage(bean.getAd5().get(0).getImage(),((MyViewHolder1) holder).imageView,options);
                ((MyViewHolder1) holder).text2.setText(bean.getAd5().get(1).getTitle());
                ImageLoader.getInstance().displayImage(bean.getAd5().get(1).getImage(),((MyViewHolder1) holder).imageView2,options);
                ((MyViewHolder1) holder).text3.setText(bean.getAd5().get(2).getTitle());
                ImageLoader.getInstance().displayImage(bean.getAd5().get(2).getImage(),((MyViewHolder1) holder).imageView3,options);
                ((MyViewHolder1) holder).text4.setText(bean.getAd5().get(3).getTitle());
                ImageLoader.getInstance().displayImage(bean.getAd5().get(3).getImage(),((MyViewHolder1) holder).imageView4,options);
        }else if(holder instanceof MyViewHolder2){
            ((MyViewHolder2) holder).text1.setText(bean.getDefaultGoodsList().get(0).getGoods_name());
            ImageLoader.getInstance().displayImage(bean.getDefaultGoodsList().get(0).getGoods_img(),((MyViewHolder2) holder).imageView,options);
            ((MyViewHolder2) holder).text2.setText(bean.getDefaultGoodsList().get(1).getGoods_name());
            ImageLoader.getInstance().displayImage(bean.getDefaultGoodsList().get(1).getGoods_img(),((MyViewHolder2) holder).imageView2,options);
            ((MyViewHolder2) holder).text3.setText(bean.getDefaultGoodsList().get(2).getGoods_name());
            ImageLoader.getInstance().displayImage(bean.getDefaultGoodsList().get(2).getGoods_img(),((MyViewHolder2) holder).imageView3,options);
            ((MyViewHolder2) holder).text4.setText(bean.getDefaultGoodsList().get(0).getGoods_name());
            ImageLoader.getInstance().displayImage(bean.getDefaultGoodsList().get(0).getGoods_img(),((MyViewHolder2) holder).imageView4,options);

        }else if(holder instanceof MyViewHolder3){
            ((MyViewHolder3) holder).text1.setText(bean.getAd8().get(0).getTitle());
            ImageLoader.getInstance().displayImage(bean.getAd8().get(0).getImage(),((MyViewHolder3) holder).imageView,options);
            ((MyViewHolder3) holder).text2.setText(bean.getAd8().get(1).getTitle());
            ImageLoader.getInstance().displayImage(bean.getAd8().get(1).getImage(),((MyViewHolder3) holder).imageView2,options);
            ((MyViewHolder3) holder).text3.setText(bean.getAd8().get(2).getTitle());
            ImageLoader.getInstance().displayImage(bean.getAd8().get(2).getImage(),((MyViewHolder3) holder).imageView3,options);
        }

        }





    @Override
    public int getItemCount()
    {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_1;
        }else if (position==1){
            return TYPE_2;
        }else if(position==2){
            return TYPE_3;
        }else if(position==3){
            return  TYPE_4;
        }else{
            return -1;
        }

    }
}

    class MyViewHolder extends XRecyclerView.ViewHolder {


        Banner banner;

        public MyViewHolder(View view) {
            super(view);
            banner= (Banner) view.findViewById(R.id.banner);

        }
    }
        class MyViewHolder1 extends XRecyclerView.ViewHolder {


            ImageView imageView,imageView2,imageView3,imageView4;
            TextView text1,text2,text3,text4;

            public MyViewHolder1(View view) {
                super(view);
                imageView= (ImageView) view.findViewById(R.id.image1);
                text1= (TextView) view.findViewById(R.id.text1);
                imageView2= (ImageView) view.findViewById(R.id.image2);
                text2= (TextView) view.findViewById(R.id.text2);
                imageView3= (ImageView) view.findViewById(R.id.image3);
                text3= (TextView) view.findViewById(R.id.text3);
                imageView4= (ImageView) view.findViewById(R.id.image4);
                text4= (TextView) view.findViewById(R.id.text4);


            }
        }
            class MyViewHolder2 extends XRecyclerView.ViewHolder
            {

                ImageView imageView,imageView2,imageView3,imageView4;
                TextView text1,text2,text3,text4;
                public MyViewHolder2(View view)
                {
                    super(view);

                    imageView= (ImageView) view.findViewById(R.id.image1);
                    text1= (TextView) view.findViewById(R.id.text1);
                    imageView2= (ImageView) view.findViewById(R.id.image2);
                    text2= (TextView) view.findViewById(R.id.text2);
                    imageView3= (ImageView) view.findViewById(R.id.image3);
                    text3= (TextView) view.findViewById(R.id.text3);
                    imageView4= (ImageView) view.findViewById(R.id.image4);
                    text4= (TextView) view.findViewById(R.id.text4);
                }
                }
                class MyViewHolder3 extends XRecyclerView.ViewHolder {
                    ImageView imageView,imageView2,imageView3;
                    TextView text1,text2,text3;


                    public MyViewHolder3(View view) {
                        super(view);
                        imageView= (ImageView) view.findViewById(R.id.image1);
                        text1= (TextView) view.findViewById(R.id.text1);
                        imageView2= (ImageView) view.findViewById(R.id.image2);
                        text2= (TextView) view.findViewById(R.id.text2);
                        imageView3= (ImageView) view.findViewById(R.id.image3);
                        text3= (TextView) view.findViewById(R.id.text3);
                    }
                }

















