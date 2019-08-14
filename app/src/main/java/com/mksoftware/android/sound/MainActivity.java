package com.mksoftware.android.sound;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   SoundPool soundPool;

   private int lastPlayed;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      Button sound1 = findViewById(R.id.sonido1);
      initSoundPool();
      sound1.setOnClickListener(new View.OnClickListener() {

         @Override
         public void onClick(View v) {

            playSound();
         }
      });
   }

   private void playSound() {
      //
      //      if (lastPlayed != 0) {
      //         soundPool.stop(lastPlayed);
      //         soundPool.release();
      //         soundPool = null;
      //         lastPlayed = 0;
      //      }

      soundPool.play(lastPlayed, 1, 1, 1, 0, 1f);

   }

   @Override
   protected void onPostResume() {
      super.onPostResume();

   }

   private void initSoundPool() {

      if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
         soundPool = new SoundPool.Builder().setMaxStreams(1).build();
      } else {
         soundPool = new SoundPool(1, AudioManager.STREAM_ALARM, 0);
      }

      lastPlayed = soundPool.load(getApplicationContext(), R.raw.doorbell, 0);

   }

}
