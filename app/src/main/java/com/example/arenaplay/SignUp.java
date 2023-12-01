package com.example.arenaplay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    TextInputEditText registerName, registerEmail, registerPassword, registerContact;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        firebaseAuth = FirebaseAuth.getInstance();

        registerEmail = (TextInputEditText) findViewById(R.id.registerEmail);
        registerName = (TextInputEditText) findViewById(R.id.registerName);
        registerContact = (TextInputEditText) findViewById(R.id.registerContact);
        registerPassword = (TextInputEditText) findViewById(R.id.registerPassword);
        Button registerButton = (Button) findViewById(R.id.registerButton);
        TextView login = (TextView) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activities.openLoginActivity(SignUp.this);
                finish();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, name, contact;
                name = String.valueOf(registerName.getText());
                email = String.valueOf(registerEmail.getText());
                contact = String.valueOf(registerContact.getText());
                password = String.valueOf(registerPassword.getText());

                if(TextUtils.isEmpty(name)) {
                    Toast.makeText(SignUp.this, "Preencha o nome", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email)) {
                    Toast.makeText(SignUp.this, "Preencha o email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(contact)) {
                    Toast.makeText(SignUp.this, "Preencha o número de contato", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUp.this, "Preencha a senha", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Cadastro Realizado", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUp.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(SignUp.this, "Cadastro Falhou", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
