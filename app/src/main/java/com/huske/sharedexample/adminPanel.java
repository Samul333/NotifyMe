package com.huske.sharedexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class adminPanel extends AppCompatActivity {
    private AdminPreferenceConfig adminConfig;
    private FirebaseAuth mAuth;
    private EditText editText, edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        editText = findViewById(R.id.editText);
        edit = findViewById(R.id.editText2);
        mAuth = FirebaseAuth.getInstance();
        adminConfig = new AdminPreferenceConfig(this);

    }

    // registration code.
    public void regi(View view) {
        String email = editText.getText().toString();
        String pwd = edit.getText().toString();

        if (email.isEmpty() || pwd.isEmpty()) {
            editText.setError("Required");
            edit.setError("Required!");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editText.setError("Valid email please");
            editText.requestFocus();
        }


        mAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Check your Email", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                    Toast.makeText(getApplicationContext(), "User registration Successful", Toast.LENGTH_LONG).show();
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
// registration

    //reset code
    public void reset(View view) {
        edit.setText("");
        editText.setText("");
    }
}
//reset code

    //logout code
   /* public void logout(View view) {
        adminConfig.writeLoginStatus(false);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void fileup(View view) {
        startActivity(new Intent(this, UpPdf.class));

    }

    public void updateBoard(View view) {
        startActivity(new Intent(this, UpdateBoard.class));
    }
}*/
//logout code


