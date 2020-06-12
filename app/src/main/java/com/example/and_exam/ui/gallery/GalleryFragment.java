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
        memes.add(new Meme("First meme", R.drawable.m1));
        memes.add(new Meme("First meme x2", R.drawable.m2));
        memes.add(new Meme("First meme x3", R.drawable.m3));
        memes.add(new Meme("First meme x4", R.drawable.m4));

        mMemeAdapter = new MemeAdapter(memes);
        mPokemonList.setAdapter(mMemeAdapter);


        return root;
    }
}
