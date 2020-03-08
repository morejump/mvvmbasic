package com.example.mvvmbasic

import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.app.*
import android.content.Context
import android.graphics.Color
import androidx.core.app.NotificationCompat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat.PRIORITY_MIN
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.widget.RemoteViews

class AudioService : Service() {
    val audioService = AudioReceiver()
    var intentFilter: IntentFilter = IntentFilter()
    var count = 1

    companion object {
        const val NOTIFICATION_ID = 101
        const val UPDATE_ACTION = "UPDATE_ACTION"
        const val INTENT_FILTER_ACTION = "INTENT_FILTER_ACTION"
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        intentFilter.addAction(INTENT_FILTER_ACTION)
        registerReceiver(audioService, intentFilter)
        startForeground()
        Log.d("hellothere", "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("hellothere", "onStartCommand")
        when (intent?.action) {
            UPDATE_ACTION -> updateNotification()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForeground() {
        startForeground(NOTIFICATION_ID, createNotification("init text"))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String {
        val chan = NotificationChannel(
            channelId,
            channelName, NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        return channelId
    }

    fun createNotification(content: String): Notification {
        val channelId =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel("my_service", "My Background Service")
            } else {
                ""
            }
        val intent = Intent(INTENT_FILTER_ACTION)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        val layout = RemoteViews(packageName, R.layout.notification_view)
        layout.setOnClickPendingIntent(R.id.click_me, pendingIntent)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
        val notification = notificationBuilder.setOngoing(true)
            .setCustomContentView(layout)
            .setStyle(NotificationCompat.DecoratedCustomViewStyle())
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setPriority(PRIORITY_MIN)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        return notification;
    }

    private fun updateNotification() {
        Log.d("hellothere", "update notification")
        val notification = createNotification("${count++}")
        val mNotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.notify(NOTIFICATION_ID, notification)
    }

    inner class AudioReceiver : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            Log.d("hellothere", "AudioReceiver")
            stopSelf()
        }
    }
}