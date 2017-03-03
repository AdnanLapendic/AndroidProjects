package ba.adnanlapendic.simplenoteapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashSet;

public class EditNotes extends AppCompatActivity {

    int noteId;
    Button saveButton;
    Button cancelButton;
    EditText editText;

    public void saveChangesToTheNote(View view){

        MainActivity.notes.set(noteId, String.valueOf(editText.getText()));

        SharedPreferences sharedPreferences = this.getSharedPreferences("ba.adnanlapendic.simplenoteapp", Context.MODE_PRIVATE);

        if(MainActivity.set == null){
            MainActivity.set = new HashSet<>();
        }else{
            MainActivity.set.clear();
        }

        MainActivity.set.addAll(MainActivity.notes);

        sharedPreferences.edit().putStringSet("notes", MainActivity.set).apply();
        MainActivity.arrayAdapter.notifyDataSetChanged();
        this.finish();
    }

    public void cancelNoteEditing(View view){
        this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);

        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        editText = (EditText) findViewById(R.id.editNoteView);
        Intent i = getIntent();
        noteId = i.getIntExtra("noteId", -1);

        if(noteId != -1){
            editText.setText(MainActivity.notes.get(noteId));
        }

//        editText.addTextChangedListener(this);
    }

}
