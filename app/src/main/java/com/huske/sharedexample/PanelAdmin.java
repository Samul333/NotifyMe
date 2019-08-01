package com.huske.sharedexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PanelAdmin extends AppCompatActivity {
ImageView register,upload,logout,notify,fire;
    private AdminPreferenceConfig adminConfig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_admin);
        register = findViewById(R.id.imgregister);
        upload = findViewById(R.id.imgupload);
        logout = findViewById(R.id.imglogout);
        notify = findViewById(R.id.imgnotify);
        fire = findViewById(R.id.fire);
        adminConfig = new AdminPreferenceConfig(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PanelAdmin.this,adminPanel.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminConfig.writeLoginStatus(false);
                startActivity(new Intent(PanelAdmin.this, MainActivity.class));
                finish();

            }
        });

        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PanelAdmin.this, UpdateBoard.class));
            }
        });



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PanelAdmin.this, UpPdf.class));
            }
        });
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PanelAdmin.this, Web.class));
            }
        });

    }
}
