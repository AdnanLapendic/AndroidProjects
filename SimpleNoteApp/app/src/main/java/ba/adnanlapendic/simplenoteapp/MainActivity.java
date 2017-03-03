package ba.adnanlapendic.simplenoteapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    static Set<String> set;

    public void createNewNote(View view){

        Intent i = new Intent(getApplicationContext(), EditNotes.class);
        notes.add("");
        i.putExtra("noteId", notes.size()-1);
        arrayAdapter.notifyDataSetChanged();
        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        SharedPreferences sharedPreferences = this.getSharedPreferences("ba.adnanlapendic.simplenoteapp", Context.MODE_PRIVATE);
        set = sharedPreferences.getStringSet("notes", null);

        notes.clear();

        if(set != null){

            notes.addAll(set);

        }else {
            notes.add("Example note");
            set = new HashSet<>();
            set.addAll(notes);
            sharedPreferences.edit().putStringSet("notes", set).apply();
        }


        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), EditNotes.class);
                i.putExtra("noteId", position);
                startActivity(i);

            }

        });

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//
//                new AlertDialog.Builder(MainActivity.this)
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .setTitle("Are you sure?")
//                        .setMessage("Do you want to delete this note?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                                notes.remove(position);
//                                SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences("ba.adnanlapendic.simplenoteapp", Context.MODE_PRIVATE);
//
//                                if(set == null){
//                                    set = new HashSet<>();
//                                }else{
//                                    set.clear();
//                                }
//
//                                set.addAll(notes);
//                                sharedPreferences.edit().putStringSet("notes", set).apply();
//                                arrayAdapter.notifyDataSetChanged();
//                            }
//                        })
//                        .setNegativeButton("No", null)
//                        .show();
//
//                return true;
//            }
//        });

    }


}
