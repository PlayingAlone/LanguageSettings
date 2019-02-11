package com.example.seth.languagesettings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView languageChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languageChoice = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.example.seth.languagesettings", Context.MODE_PRIVATE);

        String language = sharedPreferences.getString("language", "error");

        if (language == "error") {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Language settings")
                    .setMessage("Which language would you like?")
                    .setPositiveButton("English", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            setLanguage("English");
                        }
                    })
                    .setNegativeButton("French", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            setLanguage("French");
                        }
                    })
                    .show();
        } else {
            languageChoice.setText(language);
        }
    }

    private void setLanguage(String language) {
        languageChoice.setText(language);
        sharedPreferences.edit().putString("language", language).apply();

    }
}
