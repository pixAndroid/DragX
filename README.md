
# DragX 
[![](https://jitpack.io/v/pixAndroid/DragX.svg)](https://jitpack.io/#pixAndroid/DragX)


This will help you to drag  Android views



### Project Requirements
distributionUrl=https\://services.gradle.org/distributions/gradle-7.4-bin.zip



## Implementation

#### Step 1. Add the JitPack repository to your build.gradle file

```bash
    allprojects {
        repositories {
            maven { url 'https://jitpack.io' }
        }
    }
```
#### Step 2. Add the dependency

```bash
	implementation 'com.github.pixAndroid:dragx:1.2'
```
## Examples
### Just one single line call
```bash
   DragX.enableLeftTopDrag(context, your_relative_layout, R.drawable.ic_touch_left, drawable_size);
```

## Badges

[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)


