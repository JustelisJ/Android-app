package com.example.and_exam.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_exam.Model.Meme;
import com.example.and_exam.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    RecyclerView memeList;
    MemeAdapter memeAdabter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        memeList = root.findViewById(R.id.rv);
        memeList.hasFixedSize();
        memeList.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Meme> memes = new ArrayList<>();
        memes.add(new Meme("Very first meme", R.drawable.m1));
        memes.add(new Meme("Very first meme x2", R.drawable.m2));
        memes.add(new Meme("Very first meme x3", R.drawable.m3));
        memes.add(new Meme("Very first meme x4", R.drawable.m4));

        memeAdabter = new MemeAdapter(memes);
        memeList.setAdapter(memeAdabter);

        return root;
    }
}
