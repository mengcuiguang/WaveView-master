package com.meng.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.meng.demo.view.wave.WaveView;

public class WaveActivity extends AppCompatActivity {

    private ImageView imageView;
    private WaveView waveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        imageView = (ImageView) findViewById(R.id.image);
        waveView = (WaveView) findViewById(R.id.wave_view);

        final FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2,-2);
        lp.gravity = Gravity.BOTTOM|Gravity.CENTER;
        waveView.setOnWaveAnimationListener(new WaveView.OnWaveAnimationListener() {
            @Override
            public void OnWaveAnimation(float y) {
                lp.setMargins(0,0,0,(int)y+16);
                imageView.setLayoutParams(lp);
            }
        });

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waveView.setWaveVieweAnim(true);
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                waveView.setWaveVieweAnim(false);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        waveView.setWaveVieweAnim(true);
    }

    @Override
    protected void onPause() {
        super.onPause();

        waveView.setWaveVieweAnim(false);
    }
}
