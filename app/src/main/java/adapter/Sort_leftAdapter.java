package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.testten.R;

import java.util.List;

import bean.Sort_lift;

/**
 * Created by ASUS on 2017/11/13.
 */

public class Sort_leftAdapter extends RecyclerView.Adapter<Sort_leftAdapter.ViewHolder> {
    private Context context;

    private List<Sort_lift.DatasBean.ClassListBean> list;
   private int p;
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(View view, int position);
    }
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }


    public Sort_leftAdapter(Context context, List<Sort_lift.DatasBean.ClassListBean> list, int p) {
        this.context = context;
        this.list = list;
        this.p = p;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_left, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getGc_name());
//        holder.tv.setText(""+position);
        //判断是否设置了监听器
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,position); // 2
                    if(p==position){
                    holder.itemView.setBackgroundColor(Color.RED);

                    }else{
                        holder.itemView.setBackgroundColor(Color.WHITE);
                    }
                }
            });
        }

    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
