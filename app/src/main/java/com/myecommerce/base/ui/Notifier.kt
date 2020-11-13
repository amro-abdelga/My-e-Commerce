package com.myecommerce.base.ui


import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.myecommerce.R

/**
 * Created by Amro, Abd-Elgawwad on 13/11/2020.
 */
object Notifier {

    private const val channelId = "Default"

    fun init(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                    activity.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
            val existingChannel = notificationManager.getNotificationChannel(channelId)
            if (existingChannel == null) {
                // Create the NotificationChannel
                val name = activity.getString(R.string.defaultChannel)
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val mChannel = NotificationChannel(channelId, name, importance)
                mChannel.description = activity.getString(R.string.notificationDescription)
                notificationManager.createNotificationChannel(mChannel)
            }
        }
    }

    fun postNotification(id: String?, context: Context?, articleName: String, intent: PendingIntent) {
        id?.let {
            context?.let {
                val builder = NotificationCompat.Builder(context, channelId)
                builder.setContentTitle(context.getString(R.string.deepLinkNotificationTitle))
                        .setSmallIcon(R.drawable.ic_favourite_heart)
                val notification = builder.setContentText(articleName)
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setContentIntent(intent)
                        .setAutoCancel(true)
                        .build()
                val notificationManager = NotificationManagerCompat.from(context)
                // Remove prior notifications; only allow one at a time
                notificationManager.cancelAll()
                notificationManager.notify(id.toInt(), notification)
            }
        }
    }
}
