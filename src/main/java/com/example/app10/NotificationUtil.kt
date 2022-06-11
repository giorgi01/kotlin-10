package com.example.app10

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

object NotificationUtil {
    const val CHANNEL_ID = "SOME_CHANNEL"

    fun showSimpleNotification(context: Context, text: String){

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_airplanemode_active_24)
            .setContentTitle("Airplane")
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notification)
    }
}