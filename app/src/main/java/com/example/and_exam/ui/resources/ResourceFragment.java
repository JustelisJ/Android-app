package com.example.and_exam.ui.resources;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.and_exam.R;
import com.example.and_exam.ui.layouts.LayoutViewModel;

public class ResourceFragment extends Fragment {

    ProgressBar progressBar;
    Button increase;
    Button decrease;

    EditText editText;
    Button button;
    TextView textView;

    Switch aSwitch;

    private ResourceViewModel resourceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resourceViewModel =
                ViewModelProviders.of(this).get(ResourceViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_resources, container, false);

        progressBar = root.findViewById(R.id.progressBar);
        increase = root.findViewById(R.id.increase);
        decrease = root.findViewById(R.id.decrease);
        editText = root.findViewById(R.id.resource_editText);
        button = root.findViewById(R.id.resource_setText);
        textView = root.findViewById(R.id.resource_textView);
        aSwitch = root.findViewById(R.id.switch1);

        progressBar.setMin(0);
        progressBar.setMax(15);
        progressBar.setProgress(0);

        root.setBackgroundColor(0xFFFA7FA6);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(1);
            }
        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(-1);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString() != "")
                    textView.setText(editText.getText().toString());
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    root.setBackgroundColor(0xFF78D2FF);
                else
                    root.setBackgroundColor(0xFFFA7FA6);
            }
        });

        return root;
    }

}
