package com.example.mybottom;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.ViewHolder> {

    private ArrayList<PostRecyclerItem> mData = null;

    PostRecyclerAdapter(ArrayList<PostRecyclerItem> list) {
        mData = list ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView postImg;
        TextView postTitle;
        TextView postView;

        ViewHolder(View itemView){
            super(itemView);

            postImg = itemView.findViewById(R.id.postImg);
            postTitle = itemView.findViewById(R.id.postTitle);
            postView = itemView.findViewById(R.id.postView);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
        View view = inflater.inflate(R.layout.post_item, parent, false) ;
        PostRecyclerAdapter.ViewHolder vh = new PostRecyclerAdapter.ViewHolder(view) ;
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PostRecyclerAdapter.ViewHolder holder, int position) {

        PostRecyclerItem item = mData.get(position) ;

        holder.postImg.setImageResource(item.getPostImg()); ;
        holder.postTitle.setText(item.getPostTitle()) ;
        holder.postView.setText(item.getPostView()) ;
    }

    @Override
    public int getItemCount() {
        return mData.size() ;
    }
}
