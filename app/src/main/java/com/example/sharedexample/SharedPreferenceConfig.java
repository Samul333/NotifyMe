package com.example.sharedexample;

        import android.content.Context;
        import android.content.SharedPreferences;

public class SharedPreferenceConfig {

    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferenceConfig(Context context){

        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference),Context.MODE_PRIVATE);

    }

        public void writeLoginStatus(Boolean status){
            SharedPreferences.Editor editor =  sharedPreferences.edit();
            editor.putBoolean(context.getResources().getString(R.string.login_status_preference),status);
            editor.commit();


        }

    public boolean readLoginstatus (){

        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_status_preference),false);
        return status;
    }


}
