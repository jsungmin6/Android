package com.example.mybottom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyInterestRecyclerAdapter extends RecyclerView.Adapter<MyInterestRecyclerAdapter.ViewHolder> {

    private ArrayList<MyInterestRecyclerItem> mData = null ;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    MyInterestRecyclerAdapter(ArrayList<MyInterestRecyclerItem> list) {
        mData = list ;
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView region ;
        TextView homeNum ;
        TextView title ;
        TextView subTitle ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            region = itemView.findViewById(R.id.myInterestImg);
            homeNum = itemView.findViewById(R.id.myInterestHomeNum);
            title = itemView.findViewById(R.id.myInterestTitle);
            subTitle = itemView.findViewById(R.id.myInterestSubTitle);

        }
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public MyInterestRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //context 객체 만듬
        Context context = parent.getContext() ;
        //context 객체 이용해서 inflater 객체 만듬
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        //inflater객체 이용해서 레이아웃 인플레이트 시킴
        View view = inflater.inflate(R.layout.myinterest_item, parent, false) ;
        //??
        MyInterestRecyclerAdapter.ViewHolder vh = new MyInterestRecyclerAdapter.ViewHolder(view) ;

        return vh ;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull MyInterestRecyclerAdapter.ViewHolder holder, int position) {

        MyInterestRecyclerItem item = mData.get(position) ;

        holder.region.setImageResource(item.getRegionDrawable()); ;
        holder.homeNum.setText(item.getHomeNum()) ;
        holder.title.setText(item.getTitle()) ;
        holder.subTitle.setText(item.getSubTitle()) ;

    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}
