package com.example.and_exam.ui.authentication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.and_exam.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthenticationFragment extends Fragment {

    private AuthenticationViewModel authenticationViewModel;
    private FirebaseAuth auth;

    private Button register;
    private EditText registerEmail;
    private EditText registerPassword;
    private EditText registerRepeatPassword;

    private Button login;
    private EditText loginEmail;
    private EditText loginPassword;

    private Button logout;
    private TextView userID;
    private TextView userEmail;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        authenticationViewModel =
                ViewModelProviders.of(this).get(AuthenticationViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_authentication, container, false);

        register = root.findViewById(R.id.register);
        registerEmail = root.findViewById(R.id.registerEmail);
        registerPassword = root.findViewById(R.id.registerPassword);
        registerRepeatPassword = root.findViewById(R.id.registerRepeatPassword);

        login = root.findViewById(R.id.login);
        loginEmail = root.findViewById(R.id.loginEmail);
        loginPassword = root.findViewById(R.id.loginPassword);

        logout = root.findViewById(R.id.logout);
        userID = root.findViewById(R.id.userID);
        userEmail = root.findViewById(R.id.userEmail);

        auth = FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!registerEmail.getText().toString().isEmpty() && !registerPassword.getText().toString().isEmpty() && !registerRepeatPassword.getText().toString().isEmpty())
                {
                    if(registerPassword.getText().toString().equals(registerRepeatPassword.getText().toString()))
                    {
                        auth.createUserWithEmailAndPassword(registerEmail.getText().toString(), registerPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(root.getContext(), "User registered", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else
                    {
                        Toast.makeText(root.getContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!loginEmail.getText().toString().isEmpty() && !loginPassword.getText().toString().isEmpty())
                {
                    if(auth == null)
                        auth = FirebaseAuth.getInstance();

                    auth.signInWithEmailAndPassword(loginEmail.getText().toString(), loginPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            FirebaseUser user = auth.getCurrentUser();
                            assert user != null;
                            userEmail.setText(user.getEmail());
                            userID.setText(user.getUid());
                        }
                    });
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                userEmail.setText("LOGIN");
                userID.setText("LOGIN");
                Toast.makeText(root.getContext(), "Logged out", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}