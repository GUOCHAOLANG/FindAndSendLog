
libs
activation.jar
additionnal.jar
mail.jar

Application
LogcatHelper.getInstance(this).start();

Activity
SendErrorLogMail send = new SendErrorLogMail(this);
send.SendErrorLog();

manifest
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.READ_LOGS" />
<uses-permission android:name="android.permission.INTERNET" />

android:name="com.example.testcatlog.MyApplication"

