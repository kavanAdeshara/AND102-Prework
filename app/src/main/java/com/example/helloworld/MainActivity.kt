package com.example.helloworld

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

// Initialize YouTubePlayerView and YouTubePlayer variables
@SuppressLint("StaticFieldLeak")
lateinit var youtubePlayerView: YouTubePlayerView
lateinit var heyButton: Button

lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener

var YOUTUBE_API_KEY = "AIzaSyC-nZQL1C8_N3IDm8xcrm99tLECeMLIj3Q"
var VIDEO_ID = "dQw4w9WgXcQ"


class MainActivity : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        youtubePlayerView = findViewById(R.id.youtube_player_view)
        heyButton = findViewById(R.id.heyButton)


        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }

        }

        heyButton.setOnClickListener({
            Toast.makeText(applicationContext, "Hello there! Care to Rick Roll with me?", Toast.LENGTH_LONG).show()
            youtubePlayerView.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
        })



    }

}






