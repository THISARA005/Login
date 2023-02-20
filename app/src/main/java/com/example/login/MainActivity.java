package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    Button btnRead;
    EditText txtAge;
    EditText txtName;

    String name;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btnLogin);
        btnRead=findViewById(R.id.btnRead);
        txtName=findViewById(R.id.txtName);
        txtAge=findViewById(R.id.txtAge);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtName.getText().toString();
                age= Integer.parseInt(txtAge.getText().toString());
                SharedPreferences prf=getSharedPreferences("detail",MODE_PRIVATE);
                SharedPreferences.Editor editor=prf.edit();
                editor.putString("name",name);
                editor.putInt("age",age);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_LONG).show();


            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prf=getSharedPreferences("detail",MODE_PRIVATE);
                String name=prf.getString("name","No name");
                int age=prf.getInt("age",0);

                Toast.makeText(getApplicationContext(),"Your name is :"+name+"\n Your age is :"+age,Toast.LENGTH_LONG).show();

            }
        });
    }
}