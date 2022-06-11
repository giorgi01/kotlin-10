package com.example.app10

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val enabled : Boolean =
            Settings.Global.getInt(context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

        if (context != null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val channel =
                    NotificationChannel(NotificationUtil.CHANNEL_ID, "MINE", importance).apply {
                        description = "descriptionText"
                    }
                val notificationManager: NotificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }
            if (enabled)
                NotificationUtil.showSimpleNotification(context, "ON")
            else
                NotificationUtil.showSimpleNotification(context, "OFF")
        }

    }

}