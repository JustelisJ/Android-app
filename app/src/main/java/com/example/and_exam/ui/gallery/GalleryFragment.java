package com.example.and_exam.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_exam.Meme;
import com.example.and_exam.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    RecyclerView mPokemonList;
    MemeAdapter mMemeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        mPokemonList = root.findViewById(R.id.rv);
        mPokemonList.hasFixedSize();
        mPokemonList.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Meme> memes = new ArrayList<>();
        memes.add(new Meme("First meme", "https://i.redd.it/hb39iedntm451.png"));
        memes.add(new Meme("First meme x2", "https://i.redd.it/o2nepndrmm451.png"));
        memes.add(new Meme("First meme x3", "https://i.redd.it/stdzv12xyl451.jpg"));
        memes.add(new Meme("First meme x4", "https://i.redd.it/qpy2jlrokm451.jpg"));

        mMemeAdapter = new MemeAdapter(memes, getContext());
        mPokemonList.setAdapter(mMemeAdapter);


        return root;
    }
}
