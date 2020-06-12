package com.example.and_exam.ui.intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.and_exam.MainActivity;
import com.example.and_exam.R;
import com.example.and_exam.SecondActivity;
import com.example.and_exam.ui.home.HomeViewModel;

public class IntentFragment extends Fragment {

    private HomeViewModel homeViewModel;

    Button sendImplicit;
    TextView text;
    Button sendExplicit;

    TextView reply;
    TextView reply2;

    int LAUNCH_SECOND_ACTIVITY = 2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_intents, container, false);

        sendImplicit = root.findViewById(R.id.sendEmail);
        text = root.findViewById(R.id.sendText);
        sendExplicit = root.findViewById(R.id.send);

        reply = root.findViewById(R.id.reply);
        reply2 = root.findViewById(R.id.reply2);

        reply.setVisibility(View.GONE);
        reply2.setVisibility(View.GONE);

        sendImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"mom@home.dk"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Hi mom!");
                intent.putExtra(Intent.EXTRA_TEXT, "I learned a lot in class today");
                startActivity(intent);

            }
        });

        sendExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SecondActivity.class);
                String message = text.getText().toString();
                intent.putExtra("message", message);
                startActivityForResult(intent, LAUNCH_SECOND_ACTIVITY);
            }
        });

        return root;
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("reply");
                reply.setVisibility(View.VISIBLE);
                reply2.setVisibility(View.VISIBLE);

                reply2.setText(result);
            }
        }
    }*/
}