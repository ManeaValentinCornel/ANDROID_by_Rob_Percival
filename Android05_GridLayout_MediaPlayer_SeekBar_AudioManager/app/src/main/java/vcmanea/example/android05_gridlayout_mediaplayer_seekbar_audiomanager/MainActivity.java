package vcmanea.example.android05_gridlayout_mediaplayer_seekbar_audiomanager;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    SeekBar scrubber;
    AudioManager audioManager;
    SeekBar volumeBar;

    OnClickListener onClickListener = new OnClickListener() {

        public void onClick(View view) {
            mediaPlayer.stop();
            switch (view.getId()) {
                case R.id.firstButton:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.bells);
                    break;
                case R.id.secondButton:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.birds);
                    break;
                case R.id.thirdButton:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.clock);
                    break;
                case R.id.fourthButton:
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.clock);
                    break;
            }

            mediaPlayer.start();

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.clock);
        button1 = findViewById(R.id.firstButton);
        button2 = findViewById(R.id.secondButton);
        button3 = findViewById(R.id.thirdButton);
        button4 = findViewById(R.id.fourthButton);

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        //////////////////////////////////////////////////////////////////
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        volumeBar = findViewById(R.id.seekBar2);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeBar.setMax(maxVolume);
        volumeBar.setProgress(currentVolume);

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //////////////////////////////////////////////////////////////////
        scrubber = findViewById(R.id.seekBar);
        scrubber.setMax(mediaPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubber.setProgress(mediaPlayer.getCurrentPosition());

            }
        }, 0, 1000);


        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
