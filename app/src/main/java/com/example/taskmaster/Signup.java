package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText name, email, password;
    Button signup, login;
    DataBaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);
        DB = new DataBaseHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String emailInput = email.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||emailInput.equals("")||pass.equals(""))
                    Toast.makeText(Signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkUser = DB.checkUsername(user);
                    if(!checkUser){
                        clientmod newClient = new clientmod(user, 0, emailInput, pass);
                        Boolean insert = DB.addClient(newClient);

                        if(insert){
                            Toast.makeText(Signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),categorieshomepage.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(Signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(Signup.this,"Already exists! please sign in",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
    }
}