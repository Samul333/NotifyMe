package com.example.sharedexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
private SharedPreferenceConfig preferenceConfig;
private AdminPreferenceConfig adminConfig;
private EditText Username, Password;
private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        adminConfig = new AdminPreferenceConfig(getApplicationContext());

        Username = findViewById(R.id.editText);
        Password = findViewById(R.id.editText2);

        if(preferenceConfig.readLoginstatus()){
          startActivity(new Intent(this,SucessAcitivity.class));
          finish();


       }

        else if (adminConfig.readLoginstatus()){

            startActivity(new Intent(this,adminPanel.class));
            finish();
        }
    }

    private void userLogin(String a , String b){
        mAuth.signInWithEmailAndPassword(a,b).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                   Intent intent = new Intent(getApplicationContext(),SucessAcitivity.class);
                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(intent);
                    preferenceConfig.writeLoginStatus(true);
                    finish();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Please try again", Toast.LENGTH_LONG);
                    Username.setText("");
                    Password.setText("");
                }
            }
        });


    }

    public void loginUser(View view) {

        String username = Username.getText().toString();
        String userpassword = Password.getText().toString();

        if(username.isEmpty()||userpassword.isEmpty()){
            Username.setError("Required");
            Password.setError("Required!");
            return;
        }

                userLogin(username,userpassword);
        if(username.equals(getResources().getString(R.string.user_name)) && userpassword.equals(getResources().getString(R.string.user_password))){
            startActivity(new Intent(this,SucessAcitivity.class));
            preferenceConfig.writeLoginStatus(true);
    finish();

        }

        else if (username.equals(getResources().getString(R.string.admin_name)) && userpassword.equals(getResources().getString(R.string.admin_password))){
        startActivity(new Intent(this, adminPanel.class));
           adminConfig.writeLoginStatus(true);
        finish();


    }




    }
}
