package com.example.and_exam.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_exam.Meme;
import com.example.and_exam.R;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment implements MemeAdapter.ClickListener{

    private GalleryViewModel galleryViewModel;

    RecyclerView mMemeList;
    MemeAdapter mMemeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        mMemeList = root.findViewById(R.id.rv);
        mMemeList.hasFixedSize();
        mMemeList.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Meme> memes = new ArrayList<>();
        /*memes.add(new Meme("First meme", "https://i.redd.it/hb39iedntm451.png"));
        memes.add(new Meme("First meme x2", "https://i.redd.it/o2nepndrmm451.png"));
        memes.add(new Meme("First meme x3", "https://i.redd.it/stdzv12xyl451.jpg"));
        memes.add(new Meme("First meme x4", "https://i.redd.it/qpy2jlrokm451.jpg"));*/

        memes = galleryViewModel.getMemesFromReddit();

        mMemeAdapter = new MemeAdapter(memes, this);
        mMemeList.setAdapter(mMemeAdapter);


        return root;
    }

    @Override
    public void onFavoriteClicked(Meme meme) {
        Toast.makeText(getContext(), "Added to favorites", Toast.LENGTH_SHORT).show();
        galleryViewModel.addToFavorites(meme);

        /*
        if(v.getId() == favorite.getId())
            {
                if((int)favorite.getTag() == R.drawable.heart) {
                    favorite.setImageResource(R.drawable.heart1);
                    favorite.setTag(R.drawable.heart1);
                }
                else {
                    favorite.setImageResource(R.drawable.heart);
                    favorite.setTag(R.drawable.heart);
                }
            }
         */

    }
}
