package com.app.lets_go_splash

import android.util.Log
import android.view.View
import android.view.animation.Animation

class StarterAnimation(
    private val resList: ArrayList<Animation>,
    private val onAnimationListener: OnAnimationListener
) {

    private var animateCount = 0
    fun startSequentialAnimation (
        view: View
    ) {
        if (resList.isNotEmpty()) {
            animateView(resList[0], view)
        } else {
            Log.d("SplashAnimation",
                "Oops!, looks like you forgot to put animation list as parameter!")
        }
    }

    private fun animateView(anim: Animation?, view: View) {
        anim?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) { onAnimationListener.onStartAnim() }
            override fun onAnimationEnd(animation: Animation) {
                if (animateCount < resList.size) {
                    animateView(resList[animateCount], view)
                    animateCount++
                } else {
                    onAnimationListener.onEnd()
                    animateCount = 0
                }
            }
            override fun onAnimationRepeat(animation: Animation) { onAnimationListener.onRepeat() }
        })
        view.startAnimation(anim)
    }
}