package com.app.lets_go_splash

import android.content.Context
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet

class StarterAnimation (animList: ArrayList<Animation>,
                        private val startOffset: Long? = 500L,
                        private val duration: Long? = 1500L,
                        private val view: View,
                        private val onAnimationListener: OnAnimationListener) :
    Animation.AnimationListener {

    private var animListInner: ArrayList<Animation> = animList

    fun startAnimationSet() {
        // create list of animations
        val animationSet = AnimationSet(false)
        animListInner.forEach { anim ->
            //animationSet.addAnimation(anim)
        }
        animationSet.startOffset = startOffset!!
        animationSet.duration = duration!!

        view.animation = animationSet
        animationSet.setAnimationListener(this)
    }

    override fun onAnimationRepeat(animation: Animation?) {
        onAnimationListener?.onRepeat()
    }

    override fun onAnimationEnd(animation: Animation?) {
        onAnimationListener.onEnd()
        Log.d("StarterCallback", "onEnd is calling")
    }

    override fun onAnimationStart(animation: Animation?) {
        onAnimationListener.onStartAnim()
        Log.d("StarterCallback", "onStartAnim is calling")
    }
}
