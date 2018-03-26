package com.cilicili.cilicili;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cilicili.cilicili.bean.IndexBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haifeng on 2018/3/23.
 */

public class IndexFragment extends Fragment implements BaseQuickAdapter.RequestLoadMoreListener{

    private RecyclerView recyclerView;

    public static IndexFragment newInstance() {
        
        Bundle args = new Bundle();

        IndexFragment fragment = new IndexFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index,container,false);
        initView(view);
        return view;
    }

    public void initView(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        IndexFragmentAdapter adapter = new IndexFragmentAdapter(R.layout.item_index);
        recyclerView.setAdapter(adapter);
        List<IndexBean> mData = new ArrayList<>();
        mData.add(new IndexBean());
        mData.add(new IndexBean());
        mData.add(new IndexBean());
        adapter.setNewData(mData);
        adapter.setOnLoadMoreListener(this,recyclerView);
    }

    @Override
    public void onLoadMoreRequested() {

    }

    private class IndexFragmentAdapter extends BaseQuickAdapter<IndexBean,BaseViewHolder>{

        public IndexFragmentAdapter(@LayoutRes int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder helper, IndexBean item) {

        }
    }
}
