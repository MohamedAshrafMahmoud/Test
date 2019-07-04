package com.example.test.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


import java.util.Calendar;
import java.util.Locale;

public class Common {


    public static boolean isConnectToInternet(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();

            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }

    public static String getDate(long time){
        Calendar calendar=Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date=new StringBuilder(android.text.format.DateFormat.format("dd/MM/yyyy     HH:mm",calendar).toString());
        return date.toString();
    }



//     if (result.get(0).indexOf("hello") != -1) {
//        say("Hi mohamed");
//    } else if (result.get(0).indexOf("what") != -1) {                //what
//        if (result.get(0).indexOf("name") != -1) {
//            say("My name is athena");
//        }
//        if (result.get(0).indexOf("time") != -1) {
//            Date date = new Date();
//            String time = DateUtils.formatDateTime(this, date.getTime(), DateUtils.FORMAT_SHOW_TIME);
//            say("The Time is " + time);
//        }
//    } else if (result.get(0).indexOf("open") != -1) {              //open
//        if (result.get(0).indexOf("browser") != -1) {
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
//            startActivity(intent);
//        }
//        if (result.get(0).indexOf("gallery") != -1) {
//            Intent intent = new Intent();
//            intent.setAction(android.content.Intent.ACTION_GET_CONTENT);
//            intent.setType("image/*");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//
//        }
//        if (result.get(0).indexOf("contacts") != -1) {
//            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
//            startActivityForResult(intent, 1);
//
//        }
//        if (result.get(0).indexOf("camera") != -1) {
//            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//            startActivity(intent);
//
//        }
//        if (result.get(0).indexOf("Facebook") != -1) {
//            Intent sendIntent = getPackageManager().getLaunchIntentForPackage("com.facebook.katana");
//            startActivity(sendIntent);
//
//        }
//
//        if (result.get(0).indexOf("settings") != -1) {
//            startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
//        }
//    } else if (result.get(0).indexOf("set") != -1) {                   //set
//
//        if (result.get(0).indexOf("alarm") != -1) {
//            createAlarm("new alarm from assistant", 10, 10);
//
//        } else if (result.get(0).indexOf("event") != -1) {
//            addEvent("New Event", "egypt", 44, 44);
//        }
//    } else if (result.get(0).indexOf("take") != -1) {                   //take
//
//        if (result.get(0).indexOf("photo") != -1) {
//            Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
//            startActivityForResult(intent, 1);
//        }
//    } else if (result.get(0).indexOf("call") != -1) {                   //call
//
//        call("01142007993");
//    } else if (result.get(0).indexOf("search") != -1) {                 //search
//
//        String q = textView.getText().toString();
//        q=q.replace("search","");
//        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//        intent.putExtra(SearchManager.QUERY, q);
//        startActivity(intent);
//    } else if (result.get(0).indexOf("music") != -1) {                  //play
//
//        Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
//    }
//
//
//

}
