package com.unica.labexer_4itbdec5;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnDisplay, btnClear;
    EditText etParagraph;
    TextView tvDisplay;
    SharedPreferences preferences;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etParagraph = (EditText) findViewById(R.id.etParagraph);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnClear  = (Button) findViewById(R.id.btnClear);
        btnDisplay = (Button) findViewById(R.id.btnDisplay);
        tvDisplay = (Button) findViewById(R.id.tvDisplay);
    }

    public void saveInput (View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("data", etParagraph.getText().toString());
        editor.commit();
        Toast.makeText(this, "Preferences Saved!", Toast.LENGTH_SHORT).show();
    }

    public void clearInput (View view) {
        tvDisplay.setText("");
    }

    public void displayInput (View view){
        String message = preferences.getString("message", "");
        tvDisplay.setText(message);
    }

}
