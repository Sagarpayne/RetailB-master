package com.sagar.retb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterOrLogin extends AppCompatActivity {
    String TAG ="ROL";
    EditText uname ;
    EditText email;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_or_login);
        uname = (EditText) findViewById(R.id.edtUsername);
        email = (EditText)findViewById(R.id.edtEmail);

        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Register mainAcrkckk: ");
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("RetB", Context.MODE_PRIVATE);
                Log.d(TAG, "Register sharedPreferences: ");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Log.d(TAG, "Register editor: ");
                editor.putString("userforRetB",uname.getText().toString());
                Log.d(TAG, "Register putString: ");
                editor.putString("emailforRetB",email.getText().toString());
                editor.commit();
                Log.d(TAG, "Register putString: ");
                Intent intent = new Intent(getApplicationContext(), WelcomeToShop.class);

                startActivity(intent);

            }
        });

    }

    public void Register(){
        Log.d(TAG, "Register mainAcrkckk: ");
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("RetB", Context.MODE_PRIVATE);
        Log.d(TAG, "Register sharedPreferences: ");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Log.d(TAG, "Register editor: ");
        editor.putString("userforRetB",uname.getText().toString());
        Log.d(TAG, "Register putString: ");
        editor.putString("emailforRetB",email.getText().toString());
editor.commit();
        Log.d(TAG, "Register putString: ");
        Intent intent = new Intent(getApplicationContext(), WelcomeToShop.class);

        startActivity(intent);

        //Toast.makeText(getApplicationContext(),"SuccessFul !! ", Toast.LENGTH_SHORT).show();
    }

}
