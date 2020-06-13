package com.example.and_exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class SecondActivity extends AppCompatActivity {

    String text;
    TextView textView;

    Button reply;
    EditText replyTextField;
    String replyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        //Toolbar toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        text = bundle.getString("message");

        textView = findViewById(R.id.textView2);
        textView.setText(text);

        reply = findViewById(R.id.sendReply);
        replyTextField = findViewById(R.id.replyText);

        reply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replyText = replyTextField.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("reply", replyText);
                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }

}
