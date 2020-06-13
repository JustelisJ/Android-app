package com.example.and_exam.ui.favorites;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.and_exam.Meme;
import com.example.and_exam.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteMemeAdapter extends RecyclerView.Adapter<FavoriteMemeAdapter.ViewHolder> {

    private ArrayList<Meme> mMemes;
    final private ClickOnFavoriteListener listener;

    FavoriteMemeAdapter(LiveData<List<Meme>> memes, ClickOnFavoriteListener listener){
        this.listener = listener;
        mMemes = new ArrayList<>();
        List<Meme> _memes = memes.getValue();
        for(int i = 0; i < _memes.size(); i++)
        {
            mMemes.add(_memes.get(i));
        }
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
        holder.title.setText(mMemes.get(position).getTitle());
        //holder.meme.setImageResource(mMemes.get(position).getIconId());
        Glide.with(holder.meme.getContext()).load(mMemes.get(position).getUrl()).into(holder.meme);

    }

    @Override
    public int getItemCount() {
        return mMemes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView meme;
        ImageButton favorite;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_name);
            meme = itemView.findViewById(R.id.iv_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onFavoriteClicked(mMemes.get(getAdapterPosition()));
        }
    }

    public interface ClickOnFavoriteListener {

        void onFavoriteClicked(Meme meme);

    }
}
