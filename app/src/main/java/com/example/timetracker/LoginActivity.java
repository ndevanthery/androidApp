package com.example.timetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Data.DaoClass.EmployeeDao;
import Data.DataBase.DataBaseClass;
import Data.DataModel.Employee;

public class LoginActivity extends AppCompatActivity {

    private DataBaseClass database;
    private EmployeeDao employeeDao;
    private Button buttonLogin;
    private EditText Username, Password;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = DataBaseClass.getInstance(this.getBaseContext());


    }
    public void GoToRegister(View view){
        startActivity(new Intent(this, CreateAccountActivity.class));
    }




    public void Login(View view) {
        Username =  findViewById(R.id.editTextTextEmailAddress);
        Password = findViewById(R.id.editTextTextPassword);
        buttonLogin= findViewById(R.id.btnLogin);

        String stUsername = Username.getText().toString();
        String stPassword = Password.getText().toString();

        if (stUsername.equals("HES") && stPassword.equals("1234"))
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        else{
            if (stUsername.equals("") || stPassword.equals(""))
            {
                showError(Username, "Cannot be empty");
                showError(Password, "Cannot be empty");
                Toast.makeText(getBaseContext(), "Enter Both Email And Password",Toast.LENGTH_SHORT).show();
            }
            else {
                showError(Username, "Wrong informations");
                showError(Password, "Wrong informations");
                Toast.makeText(getBaseContext(), "Wrong Email or Password entered", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showError(EditText input, String s){
        input.setError(s);
    }





}