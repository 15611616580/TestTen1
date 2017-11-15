package sort.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bwie.testten.R;

import adapter.Right_leftAdapter;
import adapter.Sort_leftAdapter;
import bean.Sort_lift;
import bean.Sort_right;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sort.presenter.Presenter;

/**
 * Created by 郭宝 on 2017/11/14.
 */

public class Sortfragment extends Fragment implements Iview {

    @BindView(R.id.type_rvleft)
    RecyclerView typeRvleft;
    @BindView(R.id.type_rvright)
    RecyclerView typeRvright;
    Unbinder unbinder;
    private View view;
    private Presenter presenter;
    private int p=0;
    private Sort_leftAdapter sort_leftAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sortfregment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
          LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
          linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
           typeRvleft.setLayoutManager(linearLayoutManager);
           presenter = new Presenter(this);
           presenter.Left();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setlift(final Sort_lift sort_lift) {
        Toast.makeText(getActivity(), ""+sort_lift.getCode(), Toast.LENGTH_SHORT).show();
        sort_leftAdapter = new Sort_leftAdapter(getActivity(),sort_lift.getDatas().getClass_list(),p);
        typeRvleft.setAdapter(sort_leftAdapter);
        sort_leftAdapter.setOnItemClickListener(new Sort_leftAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String gc_id = sort_lift.getDatas().getClass_list().get(position).getGc_id();
               /* sort_leftAdapter = new Sort_leftAdapter(getActivity(),sort_lift.getDatas().getClass_list(),position);
                typeRvleft.setAdapter(sort_leftAdapter);*/
                presenter.Right(gc_id);
            }
        });

    }

    @Override
    public void setright(Sort_right sort_right) {
        GridLayoutManager g=new GridLayoutManager(getActivity(),3);
        typeRvright.setLayoutManager(g);
        Right_leftAdapter r=new Right_leftAdapter(getActivity(),sort_right.getDatas().getClass_list());
        typeRvright.setAdapter(r);

    }
}
