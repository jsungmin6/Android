package com.example.mybottom;

import android.content.Context;
import android.media.Image;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SellInfoRecyclerAdapter extends RecyclerView.Adapter<SellInfoRecyclerAdapter.ViewHolder> {

    private ArrayList<SellInfoRecyclerItem> mData = null ;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    SellInfoRecyclerAdapter(ArrayList<SellInfoRecyclerItem> list) {
        mData = list ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView sellInfoImg;
        TextView selling;
        TextView sellInfo;
        TextView sellInfoName;

        ViewHolder(View itemView){
            super(itemView);

            sellInfoImg = itemView.findViewById(R.id.sellInfoImg);
            selling = itemView.findViewById(R.id.selling);
            sellInfo = itemView.findViewById(R.id.sellInfo);
            sellInfoName = itemView.findViewById(R.id.sellInfoName);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View view = inflater.inflate(R.layout.sellinfo_item, parent, false) ;
        SellInfoRecyclerAdapter.ViewHolder vr = new SellInfoRecyclerAdapter.ViewHolder(view) ;

        return vr ;
    }

    @Override
    public void onBindViewHolder(@NonNull SellInfoRecyclerAdapter.ViewHolder holder, int position) {

        SellInfoRecyclerItem item = mData.get(position) ;

        holder.sellInfoImg.setImageResource(item.getSellInfoImg()); ;
        holder.selling.setText(item.getSelling()) ;
        holder.sellInfo.setText(item.getSellInfo()) ;
        holder.sellInfoName.setText(item.getSellInfoName()) ;

    }

    @Override
    public int getItemCount() {
            return mData.size() ;
    }
}
