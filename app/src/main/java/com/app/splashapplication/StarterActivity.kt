package com.app.splashapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.lets_go_splash.OnAnimationListener
import com.app.lets_go_splash.StarterAnimation
import kotlinx.android.synthetic.main.activity_starter.*


class StarterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupStatusStyle()
        setContentView(R.layout.activity_starter)
        usingSplashClass()
    }

    private fun usingSplashClass() {
        StarterAnimation(
            resList = getAnimList(),
            onAnimationListener = object : OnAnimationListener {
                override fun onRepeat() {}

                override fun onEnd() {
                    whatToDoNext()
                }

                override fun onStartAnim() {}
            }
        ).startSequentialAnimation(view = imageView)
    }

    private fun getAnimList(): ArrayList<Animation> {
        // create list of animations
        val animList: ArrayList<Animation> = ArrayList()
        val anim = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.no_animaiton
        )
        val anim1 = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.rotate
        )
        val anim2 = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.zoom_out_fast
        )
        val anim3 = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.sequential_animaiton
        )
        val anim4 = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.fade_in
        )
        //animList.add(anim)
        //animList.add(anim1)
        //animList.add(anim2)
        animList.add(anim3)
        animList.add(anim4)

        return animList
    }

    private fun setupStatusStyle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val flags: Int = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.decorView.systemUiVisibility = flags
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.TRANSPARENT
    }

    private fun whatToDoNext() {
        imageView.visibility = View.GONE
        val intent = Intent(this@StarterActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(R.anim.whole_animation, R.anim.no_animaiton)
    }

}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
