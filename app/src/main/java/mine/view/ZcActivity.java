package mine.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.testten.R;

import bean.Login;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mine.presenter.Presenter;

public class ZcActivity extends AppCompatActivity implements Iview {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.login_userid)
    EditText loginUserid;
    @BindView(R.id.login_pass)
    EditText loginPass;
    @BindView(R.id.login_go)
    Button loginGo;
    private Presenter ps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        ButterKnife.bind(this);
        ps = new Presenter(this);

    }

    @OnClick(R.id.login_go)
    public void onClick() {
        String id = loginUserid.getText().toString().trim();
        String pass = loginPass.getText().toString().trim();
        ps.zc(id,pass);
    }

    @Override
    public void login(Login login) {

    }

    @Override
    public void zc(Login login) {
        if(login.getCode().equals("0")){
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, ""+login.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }
}
