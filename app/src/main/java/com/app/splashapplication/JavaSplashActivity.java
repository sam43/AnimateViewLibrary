package com.app.splashapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.lets_go_splash.CreateAnim;
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

        // We need to add INSTANCE when ever we need to access a object file in kotlin from java class
        // This denotes that CreateAnim is a singleton file and can able to have only one instance

        animList.add(CreateAnim.INSTANCE.createAnimation(getApplicationContext(), R.anim.no_animaiton));
        animList.add(CreateAnim.INSTANCE.createAnimation(getApplicationContext(), R.anim.rotate));
        animList.add(CreateAnim.INSTANCE.createAnimation(getApplicationContext(), R.anim.zoom_out_fast));
        animList.add(CreateAnim.INSTANCE.createAnimation(getApplicationContext(), R.anim.fade_in));

        return animList;
    }
}
