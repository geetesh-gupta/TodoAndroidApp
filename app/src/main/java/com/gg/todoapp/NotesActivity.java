package com.gg.todoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NotesActivity extends AppCompatActivity {

    String fullName;
    String userName;
    FloatingActionButton fabAddNotes;
    TextView title;
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Intent intent = getIntent();
        fullName = intent.getStringExtra(AppConstant.FULL_NAME);
        userName = intent.getStringExtra(AppConstant.USER_NAME);

        getSupportActionBar().setTitle(fullName);

        fabAddNotes = findViewById(R.id.fabAddNotes);
        title = findViewById(R.id.textViewTitle);
        desc= findViewById(R.id.textViewDescription);

        fabAddNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupDialogBox();
            }
        });

    }

    private void setupDialogBox() {
        View view = LayoutInflater.from(NotesActivity.this).inflate(R.layout.dialog_layout_add_notes, null);
        final EditText editTextTitle= view.findViewById(R.id.editTextTitle);
        final EditText editTextDescription= view.findViewById(R.id.editTextDescription);
        Button buttonCreateNote = view.findViewById(R.id.buttonCreateNote);

        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view)
                .setCancelable(false)
                .create();
        dialog.show();

        buttonCreateNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText(editTextTitle.getText().toString());
                desc.setText(editTextDescription.getText().toString());
                dialog.hide();
            }
        });

    }
}
