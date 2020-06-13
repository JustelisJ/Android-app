package com.example.and_exam.ui.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.and_exam.Meme;
import com.example.and_exam.R;

import java.util.ArrayList;

class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.ViewHolder>{

    private ArrayList<Meme> mMemes;
    private Context context;

    MemeAdapter(ArrayList<Meme> memes, Context context){
        mMemes = memes;
        this.context = context;
    }

    @NonNull
    @Override
    public MemeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.meme_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemeAdapter.ViewHolder holder, int position) {
        holder.title.setText(mMemes.get(position).getTitle());
        //holder.meme.setImageResource(mMemes.get(position).getIconId());
        Glide.with(context).load(mMemes.get(position).getUrl()).into(holder.meme);
    }

    @Override
    public int getItemCount() {
        return mMemes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView meme;

        ViewHolder(View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.tv_name);
            meme = itemView.findViewById(R.id.iv_icon);
        }
    }
}
