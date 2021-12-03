# ProgressWebView
A android webview with progressbar
实现带进度条webview的两种方法

分两种实现方式：webkit和腾讯x5

# Gradle
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
   
   
   	dependencies {
        //选择1：系统原生内核
   	    implementation 'com.github.lany192.webview:webkit:1.0.1'

        //选择2：腾讯X5内核
        implementation 'com.github.lany192.webview:x5web:1.0.1'
        implementation 'com.tencent.tbs:tbssdk:54002-beta'
   	}
   	
# Preview
![image](https://github.com/lany192/webview/raw/master/preview/pic.png)