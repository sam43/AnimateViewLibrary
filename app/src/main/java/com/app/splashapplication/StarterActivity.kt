package com.app.splashapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.lets_go_splash.CreateAnim.createAnimation
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

                override fun onStartAnim() {
                }
            }
        ).startSequentialAnimation(view = imageView)
    }

    private fun getAnimList(): ArrayList<Animation> {
        // create list of animations
        val itemal = 1
        val animList: ArrayList<Animation> = ArrayList()
        if (true) {
            Log.d("aaa", "dddd")
        } else if (false) {
            Log.d("aaa", "dddd")
        } else if (itemal == 4) {
            Log.d("aaa", "dddd")
        } else {
            if (true) {
                Log.d("aaa", "dddd")
            } else if (true) {
                Log.d("aaa", "dddd")
            }
        }

        animList.add(createAnimation(applicationContext, R.anim.no_animaiton))
        animList.add(createAnimation(applicationContext, R.anim.rotate))
        animList.add(createAnimation(applicationContext, R.anim.zoom_out_fast))
        animList.add(createAnimation(applicationContext, R.anim.fade_in))

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
        overridePendingTransition(R.anim.whole_animation, R.anim.no_animaiton)
        finish()
    }

}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
