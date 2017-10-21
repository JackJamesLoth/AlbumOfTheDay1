package com.canaday.loth.albumoftheday1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        init();
    }

    private void init(){

        //Initialize EditTexts
        final EditText albumEdit = (EditText) findViewById(R.id.entryAlbumEnter);
        final EditText artistEdit = (EditText) findViewById(R.id.entryArtistEnter);
        EditText songEdit = (EditText) findViewById(R.id.entrySongEnter);
        EditText onewordEdit = (EditText) findViewById(R.id.entryOnewordEnter);
        EditText activityEdit = (EditText) findViewById(R.id.entryActivityEnter);
        EditText thoughtsEdit = (EditText) findViewById(R.id.entryThoughtsEnter);
        EditText takeawayEdit = (EditText) findViewById(R.id.entryTakeawayEnter);
        EditText sourceEdit = (EditText) findViewById(R.id.entrySourceEnter);

        //Initialize submit button
        Button submitButton = (Button) findViewById(R.id.entrySubmitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO SUBMIT TO GOOGLE SHEET

                //Save album/artist in shared preferences
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                prefs.edit().putString("lastAlbum", albumEdit.getText().toString()).apply();
                prefs.edit().putString("lastArtist", artistEdit.getText().toString()).apply();

                //Go back to main activity
                Intent intent = new Intent(EntryActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(EntryActivity.this, "Album successfully submitted!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    //Back button logic
    @Override
    public void onBackPressed(){
        //Ask the user if they are sure they want to go back
        AlertDialog.Builder builder = new AlertDialog.Builder(EntryActivity.this);
        builder.setTitle(getResources().getString(R.string.entry_back_title))
                .setMessage(getResources().getString(R.string.entry_back_text))
                .setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Go back to main activity
                        Intent intent = new Intent(EntryActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Cancel dialog
                    }
                });

        //Create the dialog
        AlertDialog backDialog = builder.create();
        backDialog.show();
    }
}
