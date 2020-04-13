package com.app.splashapplication

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.lets_go_splash.OnAnimationListener
import com.app.lets_go_splash.SplashAnimation
import com.app.lets_go_splash.StarterAnimation
import kotlinx.android.synthetic.main.activity_starter.*


class StarterActivity : AppCompatActivity() {

    private var animList: ArrayList<Animation> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupStatusStyle()
        setContentView(R.layout.activity_starter)
        //start2ndAnimation()
        //startAnimationSet()
        //usingLib()
        usingSplashClass()
    }

    private fun usingSplashClass() {
        createAnimList()
        SplashAnimation(
            resList = animList,
            onAnimationListener = object : OnAnimationListener {
                override fun onRepeat() {}

                override fun onEnd() {
                    whatToDoNext()
                }

                override fun onStartAnim() {}
            }
        ).startSequentialAnimation(view = imageView)
    }

    private fun usingLib() {
        createAnimList()
        StarterAnimation(animList = animList,
            view = imageView,
            onAnimationListener = object : OnAnimationListener {
                override fun onRepeat() {}

                override fun onEnd() {
                    showToast("on End")
                    whatToDoNext()
                }

                override fun onStartAnim() { showToast("on onStartAnim") }
            })
            .startAnimationSet()
    }

    private fun createAnimList() {
        // create list of animations
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
            R.anim.zoom_in
        )
        val anim4 = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.fade_in
        )
        animList.add(anim)
        animList.add(anim1)
        animList.add(anim2)
        animList.add(anim3)
        animList.add(anim4)
    }

    private fun startAnimationSet() {
        // create list of animations
        val anim = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.no_animaiton
        )
        val anim1 = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.zoom_out_fast
        )
        val anim2 = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.fade_in
        )
        val animationSet = AnimationSet(false)
        animationSet.addAnimation(anim)
        animationSet.addAnimation(anim1)
        animationSet.addAnimation(anim2)
        animationSet.startOffset = 500
        animationSet.duration = 800
        imageView.animation = animationSet

        animationSet.setAnimationListener(object : AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                whatToDoNext()
            }

            override fun onAnimationStart(animation: Animation?) {
            }
        })
    }

    private fun start0thAnimation() {
        val anim = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.no_animaiton
        )
        anim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                start1stAnimation()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        imageView.startAnimation(anim)
    }

    private fun start1stAnimation() {
        val anim = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.zoom_out_fast
        )
        anim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                start2ndAnimation()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        imageView.startAnimation(anim)
    }

    private fun start2ndAnimation() {
        val anim = AnimationUtils.loadAnimation(
            applicationContext,
            R.anim.togather_animaiton
        )

        anim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {whatToDoNext()}

            override fun onAnimationRepeat(animation: Animation) {}
        })
        imageView.startAnimation(anim)
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
        finishAfterTransition()
    }

}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
