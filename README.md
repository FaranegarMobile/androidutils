# androidutils

This repo contains some utility functions, written in JAVA, which could easily be exteneded based on your daily needs.
Enjoy it and extend it.

Thanks in advance.

How To add:

first add the JITPACK Url to your project level build.gradle:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```	
  
  Thereafter, add this dependency to your app-level build.gradle:
  
  ```gradle
  dependencies {
	        implementation 'com.github.FaranegarMobile.androidutils:faranegarutils:v1.5'
	}
```	
  
  Finally, sync it!
  
  How to use:
  
  Create an object like following:
  
  ```java
  FaranegarUtils faranegarutils = FaranegarUtils.getInstance(context);
  ```
  
  Following methods are discoverable (:)) in this Utils:
  
  
