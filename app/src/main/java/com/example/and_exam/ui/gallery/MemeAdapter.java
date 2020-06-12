package com.example.and_exam.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_exam.Model.Meme;
import com.example.and_exam.R;

import java.util.ArrayList;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.ViewHolder> {

    private ArrayList<Meme> memes;

    public MemeAdapter(ArrayList<Meme> _memes)
    {
        memes = _memes;
    }

    @Override
    public int getItemCount() {
        return memes.size();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.meme_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(memes.get(position).getTitle());
        holder.meme.setImageResource(memes.get(position).getPicId());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView meme;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            meme = itemView.findViewById(R.id.iv_meme);
        }
    }
}
