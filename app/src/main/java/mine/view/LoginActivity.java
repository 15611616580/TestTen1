package mine.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.testten.R;

import org.greenrobot.eventbus.EventBus;

import bean.Login;
import bean.User;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mine.presenter.Presenter;
import utils.SharedPreferencesUtils;

public class LoginActivity extends AppCompatActivity implements Iview {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.login_userid)
    EditText loginUserid;
    @BindView(R.id.login_pass)
    EditText loginPass;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.findpass)
    TextView findpass;
    @BindView(R.id.login_go)
    Button loginGo;
    @BindView(R.id.qq)
    ImageView qq;
    @BindView(R.id.sj)
    ImageView sj;
    @BindView(R.id.wb)
    ImageView wb;
    private Presenter presenter;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
    }


    @Override
    public void login(Login login) {
        if (login.getCode().equals("0")) {
            SharedPreferencesUtils.setParam(this, "dlzt", login.getCode());
            SharedPreferencesUtils.setParam(this, "nick", id);
            EventBus.getDefault().post(new User(id));
            finish();
        } else {
            Toast.makeText(this, "" + login.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void zc(Login login) {

    }

    @OnClick({R.id.zhuce, R.id.login_go})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zhuce:
                Intent it=new Intent(LoginActivity.this,ZcActivity.class);
                startActivity(it);
                break;
            case R.id.login_go:
                id = loginUserid.getText().toString().trim();
                String pass = loginPass.getText().toString().trim();
                Toast.makeText(this, ""+ id +pass, Toast.LENGTH_SHORT).show();
                presenter.Login(id,pass);
                break;
        }
    }
}
