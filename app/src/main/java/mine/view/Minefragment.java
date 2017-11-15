package mine.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.testten.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import bean.User;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import utils.SharedPreferencesUtils;

/**
 * Created by 郭宝 on 2017/11/14.
 */

public class Minefragment extends Fragment {

    @BindView(R.id.userimage)
    ImageView userimage;
    @BindView(R.id.userid)
    TextView userid;
    @BindView(R.id.shangpin)
    RadioButton shangpin;
    @BindView(R.id.dianpu)
    RadioButton dianpu;
    @BindView(R.id.zuji)
    RadioButton zuji;
    @BindView(R.id.notpay)
    RadioButton notpay;
    @BindView(R.id.wait)
    RadioButton wait;
    @BindView(R.id.dsh)
    RadioButton dsh;
    @BindView(R.id.notwait)
    RadioButton notwait;
    @BindView(R.id.tuikuai)
    RadioButton tuikuai;
    @BindView(R.id.wdcc)
    LinearLayout wdcc;
    @BindView(R.id.yck)
    RadioButton yck;
    @BindView(R.id.czk)
    RadioButton czk;
    @BindView(R.id.djj)
    RadioButton djj;
    @BindView(R.id.hb)
    RadioButton hb;
    @BindView(R.id.jf)
    RadioButton jf;
    @BindView(R.id.adress)
    LinearLayout adress;
    @BindView(R.id.xtsz)
    LinearLayout xtsz;
    @BindView(R.id.all)
    LinearLayout all;
    @BindView(R.id.L)
    LinearLayout L;
    Unbinder unbinder;
    @BindView(R.id.tcdl)
    TextView tcdl;
    private View view;
    private boolean lin;
    private String dlzt;
    private AlertDialog.Builder alertDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.minefregment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        dlzt = (String) SharedPreferencesUtils.getParam(getActivity(), "dlzt", "");
        String nick = (String) SharedPreferencesUtils.getParam(getActivity(), "nick", "");
        if (dlzt.equals("0")) {
            userid.setText(nick);
            userimage.setBackgroundResource(R.mipmap.userimage);
            tcdl.setVisibility(View.VISIBLE);
        }
        L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lin) {

                } else {
                    Intent it = new Intent(getActivity(), LoginActivity.class);
                    startActivity(it);
                    Toast.makeText(getActivity(), "" + lin, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void message(User user) {
        lin = true;
        userimage.setBackgroundResource(R.mipmap.userimage);
        userid.setText(user.getName());
        tcdl.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.tcdl)
    public void onClick() {
        alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("是否退出");
        alertDialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                SharedPreferencesUtils.clear(getActivity());
                userimage.setBackgroundColor(Color.WHITE);
                userid.setText("用户的id");
                lin=false;
                tcdl.setVisibility(View.GONE);

            }
        });
        alertDialog.setPositiveButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.create();
        alertDialog.show();
    }
}
