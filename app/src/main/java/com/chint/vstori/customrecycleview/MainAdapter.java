package com.chint.vstori.customrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chint.vstori.loadadapter.BaseLoadAdapter;

import java.util.List;

/**
 * Project:CustomRecycleView
 * Author:dyping
 * Date:2017/7/6 19:04
 */

public class MainAdapter extends BaseLoadAdapter<PersonBean> {

    Context context;
    LoadMoreListener listener;

    public MainAdapter(Context context, List<PersonBean> list,LoadMoreListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @Override
    protected RecyclerView.ViewHolder setItemViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_item_layout,parent,false));
    }

    @Override
    protected void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MainViewHolder) holder).nameText.setText(list.get(position).getName());
        ((MainViewHolder) holder).typeText.setText(list.get(position).getEmail());
    }

    @Override
    protected void LoadingMore() {
        if(listener == null){
            return;
        }
        listener.loadMoreData();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder{
        TextView nameText;
        TextView typeText;

        public MainViewHolder(View itemView) {
            super(itemView);

            nameText = (TextView) itemView.findViewById(R.id.name);
            typeText = (TextView) itemView.findViewById(R.id.type);
        }
    }

    public interface LoadMoreListener{
        void loadMoreData();
    }
}
