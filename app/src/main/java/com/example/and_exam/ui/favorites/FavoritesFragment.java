package com.example.and_exam.ui.favorites;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and_exam.Meme;
import com.example.and_exam.R;
import com.example.and_exam.ui.gallery.MemeAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment  implements FavoriteMemeAdapter.ClickOnFavoriteListener{

    private FavoritesViewModel favoritesViewModel;

    RecyclerView mMemeList;
    FavoriteMemeAdapter mMemeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favorites, container, false);

        mMemeList = root.findViewById(R.id.rv);
        mMemeList.hasFixedSize();
        mMemeList.setLayoutManager(new LinearLayoutManager(getContext()));

        //TODO: Get the favorite maymays from the local data storage, cuz it dont FUCKING work
        LiveData<List<Meme>> memes = favoritesViewModel.getAllFavoriteMemes();       //<--------This shit doesnt get anything for some reason
        Log.i("fuck", memes.getValue().toString());

        mMemeAdapter = new FavoriteMemeAdapter(memes, this);
        mMemeList.setAdapter(mMemeAdapter);

        return root;
    }

    @Override
    public void onFavoriteClicked(Meme meme) {
        Toast.makeText(getContext(), "Removed from favorites", Toast.LENGTH_SHORT).show();

    }
}
