# SplashApplication 
[![](https://jitpack.io/v/sam43/SplashApplication.svg)](https://jitpack.io/#sam43/AnimateViewLibrary)

Developing easy to use any animation set or animation list upon a single view or mulltiple views at a time as splash screen in Android application

# Alpha Release
Alpha release of Starter Animation for android application. Feel free to suggest. Thank you

# Features
- Create an Starter/Splash animation with any animation
- Can able to use multiple animation files on a single view.
- Easy implementation for any activity and fragment

# Implementation
- **Step-1: Add the JitPack repository to your build file**
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
- **Step-2: Add the dependency**
```
dependencies {
	        implementation "com.github.sam43:SplashApplication:$latest_version"
	}
```
where last release version is the `letest_version`.

- **Step-3: Create list of animations to be applied to**
We will be creating a list of animation like below and pass it to the library with the view, on which the animation will be applied. List of animation method, will be something like this :-
```
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
            .
            .
            .
            
        animList.add(anim)
        animList.add(anim1)
            .
            .
            .

        return animList
    }
```

- **Step-4: Use the animation list for the library**
Finally, We will be passing the list and implement the listener provided which will notify the application when animations have ended. The implementation will be like below:- 
```
StarterAnimation(
            resList = getAnimList(),
            onAnimationListener = object : OnAnimationListener {
                override fun onRepeat() {}

                override fun onEnd() {
                    // TODO: Do what you want to do after end of animations
                }

                override fun onStartAnim() {}
            }
        ).startSequentialAnimation(view = imageView)
```
Well, That's all. Please let me know if you guys have any suggestions. Any suggestion will be appreciated. Thanks 

