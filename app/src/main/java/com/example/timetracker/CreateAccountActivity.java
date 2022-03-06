package com.example.timetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Data.DaoClass.EmployeeDao;
import Data.DataBase.DataBaseClass;
import Data.DataModel.Employee;

public class CreateAccountActivity extends AppCompatActivity {

    //Déclaration des variables
    private DataBaseClass database;
    private EmployeeDao employeeDao;
    private Button buttonResgister;
    private EditText Name, Firstname, Function, Telnumber, Email, Address, Image_url, Username, Password, IsAdmin, NPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        database = DataBaseClass.getInstance(this.getBaseContext());
        buttonResgister= findViewById(R.id.createAccount_buttonRegister);

        Name = findViewById(R.id.createAccount_lastname);
        Firstname= findViewById(R.id.createAccount_firstname);
        Function= findViewById(R.id.createAccount_function);
        Telnumber= findViewById(R.id.createAccount_phone);
        Email= findViewById(R.id.createAccount_email);
        Address= findViewById(R.id.createAccount_address);
        Username= findViewById(R.id.createAccount_username);
        Password= findViewById(R.id.createAccount_password);
        NPA= findViewById(R.id.createAccount_npa);
    }


    public void Register(View view) {
        String stName = (String) Name.getText().toString();
        String stFirstname = (String) Firstname.getText().toString();
        String stFunction = (String) Function.getText().toString();
        String stTelNumber = (String) Telnumber.getText().toString();
        String stEmail = (String) Email.getText().toString();
        String stAddress = (String) Address.getText().toString();
        String stImage_Url = "nothing for this time";
        String stUsername = (String) Username.getText().toString();
        String stPassword = (String) Password.getText().toString();
        Boolean stIsAdmin = false;
        String stNPA = (String) NPA.getText().toString();

        Employee employee = new Employee();

        employee.setName(stName);
        employee.setFirstName(stFirstname);
        employee.setFunction(stFunction);
        employee.setTelnumber(stTelNumber);
        employee.setEmail(stEmail);
        employee.setAddress(stAddress);
        employee.setImage_Url(stImage_Url);
        employee.setUsername(stUsername);
        employee.setPassword(stPassword);
        employee.setAdmin(stIsAdmin);
        employee.setNpa(stNPA);

        database.employeeDao().addEmployee(employee);


        Toast.makeText(getApplicationContext(), "New account added to database", Toast.LENGTH_SHORT).show();
        System.out.println("EMPLOYEE ADDED TO DATABASE");
        List<Employee> employeeList = database.employeeDao().getAllEmployeeData();
        for (Employee employee1 : employeeList) {
            System.out.println("/////////////////");
            System.out.println("Name : " + employee1.getName());
            System.out.println("Fistname :" + employee1.getFirstName());
            System.out.println("Function :" + employee1.getFunction());
            System.out.println("TelNumber :" + employee1.getTelnumber());
            System.out.println("Email :" + employee1.getEmail());
            System.out.println("Address :" + employee1.getAddress());
            System.out.println("Image_Url :" + employee1.getImage_Url());
            System.out.println("Username :" + employee1.getUsername());
            System.out.println("Password :" + employee1.getPassword());
            System.out.println("Admin :" + employee1.getAdmin());
            System.out.println("NPA :" + employee1.getNpa());
        }


    }


}