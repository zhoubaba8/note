package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {



    Button  btnSave;

    EditText txtContent, txtTitle;
    int list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = findViewById(R.id.txtTitle);
        txtContent = findViewById(R.id.txtContent);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list++;
                NoteModel note = new NoteModel();


                note.title = txtTitle.getText().toString();
                note.content = note.title;


                SharedPreferences pref = getPreferences(0);
                SharedPreferences.Editor editor = pref.edit();

                String json = note.toJson();

                Log.i("json", json);



                note.fromJson(json);

                editor.putString(note.title, json);
                editor.commit();

                txtTitle.setText(note.title);
                txtContent.setText(txtContent.getText().toString() + "\n" + "NO." + list + ". " + note.content);

            }
        });


    }
}