package com.huske.sharedexample;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class SucessAcitivity extends AppCompatActivity {
private SharedPreferenceConfig preferenceConfig;
MainActivity obj = new MainActivity();
    int Flag = 0;
    int FlagBBA = 0;
    int FlagBIM = 0;
    AnimationDrawable animationDrawable;
    private Button btn,btn1,btn2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess_acitivity);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext()) ;
        /*ImageView loading = (ImageView)findViewById(R.id.imageView5);*/
      /*  animationDrawable = (AnimationDrawable)loading.getDrawable();*/
       /* animationDrawable.start();*/
        btn = findViewById(R.id.button4);
        btn1 = findViewById(R.id.button6);
        btn2 = findViewById(R.id.button7);
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
        textView =findViewById(R.id.textView11);

        if(Flag == 0){
        FirebaseMessaging.getInstance().subscribeToTopic("CSIT");
        Toast.makeText(this,"You are now Subscribed to CSIT",Toast.LENGTH_SHORT).show();
        Flag++;
        btn.setText("CSIT-Subbed");
        }
        else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic("CSIT");
            Toast.makeText(this,"You are now Unsubscribed to CSIT",Toast.LENGTH_SHORT).show();
            Flag--;
            btn.setText("CSIT");
        }
    }

    public void subBBA(View view) {
        if(FlagBBA == 0){
            btn1.setText("BBA subbed");
            FirebaseMessaging.getInstance().subscribeToTopic("BBA");
            Toast.makeText(this,"You are now Subscribed to BBA",Toast.LENGTH_SHORT).show();
            FlagBBA++;
        }
        else {
            btn1.setText("BBA");
            FirebaseMessaging.getInstance().unsubscribeFromTopic("BBA");
            Toast.makeText(this,"You are now Unsubscribed to BBA",Toast.LENGTH_SHORT).show();
            FlagBBA--;
        }

    }

    public void subBIM(View view) {
        if(FlagBIM == 0){
            btn2.setText("BIM subbed");
            FirebaseMessaging.getInstance().subscribeToTopic("BIM");
            Toast.makeText(this,"You are now Subscribed to BIM",Toast.LENGTH_SHORT).show();
            FlagBIM++;
        }
        else {
            btn2.setText("BIM");
            FirebaseMessaging.getInstance().unsubscribeFromTopic("BIM");
            Toast.makeText(this,"You are now Unsubscribed to BIM",Toast.LENGTH_SHORT).show();
            FlagBIM--;
        }
    }

 /*   public void viewFiles(View view) {
        startActivity(new Intent(this, View_pdf_files.class));

    }*/

    public void NavPage(View view) {
        startActivity(new Intent(this, Nav.class));
    }
}
