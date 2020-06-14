package com.example.and_exam.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.and_exam.Model.Meme;
import com.example.and_exam.R;

import java.util.ArrayList;

public class MemeAdapter extends RecyclerView.Adapter<MemeAdapter.ViewHolder>{

    private ArrayList<Meme> mMemes;
    final private OnListItemClickListener listener;

    public MemeAdapter(ArrayList<Meme> memes, OnListItemClickListener listener)
    {
        mMemes = memes;
        this.listener = listener;
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
        Glide.with(holder.meme.getContext()).load(mMemes.get(position).getUrl()).into(holder.meme);
    }

    @Override
    public int getItemCount() {
        return mMemes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView title;
        ImageView meme;
        //ImageButton upvote;
        //ImageButton downvote;
        ImageButton favorite;

        ViewHolder(View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.tv_name);
            meme = itemView.findViewById(R.id.iv_icon);
            //favorite = itemView.findViewById(R.id.favorite);

            //favorite.setTag(R.drawable.heart);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            /*if(v.getId() == favorite.getId())
            {
                if((int)favorite.getTag() == R.drawable.heart) {
                    favorite.setImageResource(R.drawable.heart1);
                    favorite.setTag(R.drawable.heart1);
                }
                else {
                    favorite.setImageResource(R.drawable.heart);
                    favorite.setTag(R.drawable.heart);
                }
            }*/

            listener.OnListItemClick(mMemes.get(getAdapterPosition()));

        }
    }

    public interface OnListItemClickListener
    {
        void OnListItemClick(Meme meme);
    }
}
