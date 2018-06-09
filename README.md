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
  
 In this repo, you can easily get your desired TypeFaces and enjoying existngs!
  
  ```java
  public Typeface getBoldFont(Context context);
 
 public Typeface getFontAwesome(Context context);
 
 public Typeface getFontIranSans(Context context);
 
  public Typeface getFontEnglish(Context context)
  
  ...
  
  ```
  A method to check Iranian type National Ids:
  ```java
  public boolean checkNationalCodeValidation(String code);
  ```
  
  A very useful and valuable method which convert a shamsi date to milladi date:
  ```java
 public Date convertShamsiDateTimeToMildaiDateTime(String shamsiDate);
 ```
 
 A method to hide softkeyboard:
 ```java
 public void hideSoftKeyBoard(View view);
```

A method to open Bazaar app on devices which target the market of iran:

```java
 public void openBazaar(Context context, String share) {
```

Methods to verify email:

```java
public boolean checkEmailValidation(String email);
```

To be continued with your help...
  
