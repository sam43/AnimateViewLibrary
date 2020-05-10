package com.app.splashapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.lets_go_splash.OnAnimationListener;
import com.app.lets_go_splash.StarterAnimation;

import java.util.ArrayList;

public class JavaSplashActivity extends AppCompatActivity {

    private ImageView appLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        useStarterLibrary();
    }

    private void useStarterLibrary() {
        appLogo = findViewById(R.id.imageView);
        new StarterAnimation(getAnimList(), new OnAnimationListener() {
            @Override
            public void onStartAnim() { // TODO::
            }

            @Override
            public void onRepeat() { // TODO::
            }

            @Override
            public void onEnd() {
                whatToDoNext();
            }
        }).startSequentialAnimation(appLogo);
    }

    private void whatToDoNext() {
        appLogo.setVisibility(View.GONE);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.whole_animation, R.anim.no_animaiton);
        finish();
    }

    private ArrayList<Animation> getAnimList() {
        ArrayList<Animation> animList = new ArrayList<>();
        Animation anim = AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.no_animaiton
        );
        Animation anim1 = AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.rotate
        );
        Animation anim2 = AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.zoom_out_fast
        );
        Animation anim3 = AnimationUtils.loadAnimation(
                getApplicationContext(),
                R.anim.fade_in
        );

        animList.add(anim);
        animList.add(anim1);
        animList.add(anim2);
        animList.add(anim3);

        return animList;
    }
}
