///*this class is entirely commented out because I was not able to get the functionality working
//due to the roadblocks described below in the comments. notifications is a feature that we would add
//if we had more time, as it's not vital to our recommendation system
//*/
//
// package com.example.timetracker;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.content.Context;
//import android.os.Build;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.NotificationCompat;
//import androidx.core.app.NotificationManagerCompat;
//
////this class creates notifications to alert the user when they are nearing or reached their limits and goals
//public class Notification extends AppCompatActivity {
//    Context myContext;
//    NotificationCompat.Builder builder = new NotificationCompat.Builder(myContext, "MyNotification");
//    //roadblock:can't resolve the following symbols:
//    //setSmallIcon, setContentTitle, setcontentText, setAutoCancel
//    builder.setSmallIcon(R.drawable.notification_icon);
//    builder.setContentTitle("Notification");
//    builder.setContentText("Content text: details here");
//    builder.setAutoCancel(true); //removes notif when user taps it
//
//    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(myContext);
//    // notificationId is a unique int for each notification that you must define
//    notificationManager.notify(1, builder.build());
//    //notify() function not resolving, same with build
//
//    //must create notification channel before posting any notifs
//    //should execute this code as soon as app starts. ok to call repeatedly
//    private void createNotificationChannel(){
//        //check version because NotificationChannel is only supported on API 26+
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            CharSequence name = getString(R.string.channel_name);
//            String description = getString(R.string.channel_description);
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel("MyNotification", "MyNotification", importance);
//            channel.setDescription(description);
//            //register channel with system
//            NotificationManager notificationManager1 = getSystemService(NotificationManager.class);
//            notificationManager1.createNotificationChannel(channel);
//        }
//    }
//}
