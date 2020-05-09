# AnimateViewLibrary

[![codebeat badge](https://codebeat.co/badges/5dd3c16a-69e4-4f9f-976e-d6c6542feaa6)](https://codebeat.co/projects/github-com-sam43-animateviewlibrary-master) [![](https://jitpack.io/v/sam43/AnimateViewLibrary.svg)](https://jitpack.io/#sam43/AnimateViewLibrary)

Developing easy to use any animation set for splash screen or any other views in your Android application. Easy to use, so you can animate your whole app just using this library.

# Alpha Release
Alpha release of Starter Animation for android application. Feel free to suggest. Thank you

# Features
- Create an Starter/Splash animation with any animation
- Can able to use multiple animation files on a single view.
- Easy implementation for any activity and fragment

# Demo (.GIF)
<img src="demo(.GIF)/demo_animate_view_library.gif" width="35%">

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
	        implementation "com.github.sam43:AnimateViewLibrary:$latest_version"
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

# License
```
                                 Apache License
                           Version 2.0, January 2004
                        http://www.apache.org/licenses/

   Copyright [2020] [A S M Sayem]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

```
