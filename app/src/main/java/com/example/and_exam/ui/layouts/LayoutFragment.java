package com.example.and_exam.ui.layouts;

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

import com.example.and_exam.R;
import com.example.and_exam.ui.home.HomeViewModel;

public class LayoutFragment extends Fragment {

    private LayoutViewModel layoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        layoutViewModel =
                ViewModelProviders.of(this).get(LayoutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_layouts, container, false);

        return root;
    }

}
