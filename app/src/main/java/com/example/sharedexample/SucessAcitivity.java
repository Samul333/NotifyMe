package com.example.sharedexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class SucessAcitivity extends AppCompatActivity {
private SharedPreferenceConfig preferenceConfig;
MainActivity obj = new MainActivity();
    int Flag = 0;
    int FlagBBA = 0;
    int FlagBIM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess_acitivity);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext()) ;
        FirebaseMessaging.getInstance().subscribeToTopic("student");

    }

    public void UserLogout(View view) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic("student");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("CSIT");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("BIM");
        FirebaseMessaging.getInstance().unsubscribeFromTopic("BBA");
        Toast.makeText(this,"You have been Unsubscribed From all the channels",Toast.LENGTH_LONG).show();


 preferenceConfig.writeLoginStatus(false);
 startActivity(new Intent(this, MainActivity.class));
 finish();
    }

    public void subCSIT(View view) {

        if(Flag == 0){
        FirebaseMessaging.getInstance().subscribeToTopic("CSIT");
        Toast.makeText(this,"You are now Subscribed to CSIT",Toast.LENGTH_SHORT).show();
        Flag++;
        }
        else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("CSIT");
            Toast.makeText(this,"You are now Unsubscribed to CSIT",Toast.LENGTH_SHORT).show();
            Flag--;
        }
    }

    public void subBBA(View view) {
        if(FlagBBA == 0){
            FirebaseMessaging.getInstance().subscribeToTopic("BBA");
            Toast.makeText(this,"You are now Subscribed to BBA",Toast.LENGTH_SHORT).show();
            FlagBBA++;
        }
        else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("BBA");
            Toast.makeText(this,"You are now Unsubscribed to BBA",Toast.LENGTH_SHORT).show();
            FlagBBA--;
        }

    }

    public void subBIM(View view) {
        if(FlagBIM == 0){
            FirebaseMessaging.getInstance().subscribeToTopic("BIM");
            Toast.makeText(this,"You are now Subscribed to BIM",Toast.LENGTH_SHORT).show();
            FlagBIM++;
        }
        else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("BIM");
            Toast.makeText(this,"You are now Unsubscribed to BIM",Toast.LENGTH_SHORT).show();
            FlagBIM--;
        }
    }
}
