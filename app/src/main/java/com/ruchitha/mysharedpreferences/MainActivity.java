package com.ruchitha.mysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et_name,et_password;
String name,pwd;
SharedPreferences sp;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.username);
        et_password=findViewById(R.id.password);
        sp=getSharedPreferences("ruchitha",MODE_PRIVATE);
    }

    public void showData(View view) {
        name=et_name.getText().toString();
        pwd=et_password.getText().toString();
        editor=sp.edit();
        editor.putString("n",name);
        editor.putString("p",pwd);
        editor.apply();
        Toast.makeText(this, ""+name+"\n"+pwd, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        editor=sp.edit();
        editor.putString("n",name);
        editor.putString("p",pwd);
        editor.apply();
        super.onPause();
    }

    @Override
    protected void onResume() {
        String resName=sp.getString("n","");
        String resPass=sp.getString("p","");
        et_name.setText(resName);
        et_password.setText(resPass);
        super.onResume();
    }
}