package com.huske.sharedexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;

public class UpdateBoard extends AppCompatActivity {
EditText editText;
Button button;
RadioGroup rg;
RadioButton rb;
TextView textView;
DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_board);
editText= findViewById(R.id.editNotice);
rg = findViewById(R.id.rg);
/*button = findViewById(R.id.updateboardButton);*/
final CsitNoticeSetterGetter CsitNoticeSetterGetter = new CsitNoticeSetterGetter();
/*reff = FirebaseDatabase.getInstance().getReference().child("CSIT");*/
textView = findViewById(R.id.submitboardButton);
/*
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String notice = editText.getText().toString();
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        CsitNoticeSetterGetter.setTitle(notice);
        CsitNoticeSetterGetter.setDate(currentDate);

        reff.push().setValue(CsitNoticeSetterGetter);
        Toast.makeText(getApplicationContext(),"Successfully Added",Toast.LENGTH_LONG).show();
        editText.setText("");
    }
});
*/

textView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int radioId = rg.getCheckedRadioButtonId();
        rb = findViewById(radioId);
        String choice = rb.getText().toString();
        reff = FirebaseDatabase.getInstance().getReference().child(choice);

        String notice = editText.getText().toString();
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        CsitNoticeSetterGetter.setTitle(notice);
        CsitNoticeSetterGetter.setDate(currentDate);

        reff.push().setValue(CsitNoticeSetterGetter);
        Toast.makeText(getApplicationContext(),"Successfully Added",Toast.LENGTH_LONG).show();
        editText.setText("");

    }
});


    }


}
