package com.example.contractplayfinal;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
//
public class Tutoriales extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutoriales);
        VideoView videoView= findViewById(R.id.videoView);
        String videoPath ="android.resource://"+getPackageName()+"/" + R.raw.video; Uri uri=Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController= new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}
