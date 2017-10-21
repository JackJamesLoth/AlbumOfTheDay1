package com.canaday.loth.albumoftheday1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private final String NO_ENTRY = "***noentries***";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){

        //Get shared preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //INITIALIZE WIDGETS

        //User name
        TextView userNameText = (TextView) findViewById(R.id.mainUserName);
        setUserNameText(userNameText);

        //User profile picture
        ImageView userPic = (ImageView) findViewById(R.id.mainUserPic);
        setUserPic(userPic);

        //Last listened text
        TextView listenedText = (TextView) findViewById(R.id.mainListenedText);
        if (!(prefs.getString("lastAlbum", NO_ENTRY).equals(NO_ENTRY))){
            listenedText.setText(getResources().getString(R.string.main_listened_text_format, prefs.getString("lastAlbum", "album"), prefs.getString("lastArtist", "artist")));
        }

        //Entry button
        Button entryButton = (Button) findViewById(R.id.mainEntryButton);
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to entry activity
                Intent intent = new Intent(MainActivity.this, EntryActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //Sets user name field to their name
    private void setUserNameText(TextView userNameText){
        userNameText.setText(AppHelper.getAcct().getDisplayName());
    }

    //Sets picture to user's profile picture
    private void setUserPic(ImageView userPic) {
        //TODO Do this later

        Uri picUri = AppHelper.getAcct().getPhotoUrl();
        Log.d("URI", picUri.toString());
    }
}
