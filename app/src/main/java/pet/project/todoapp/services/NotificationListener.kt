package pet.project.todoapp.services

import android.content.Intent
import android.os.IBinder
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log


class NotificationListener: NotificationListenerService() {

    override fun onBind(intent: Intent): IBinder? {
        return super.onBind(intent)
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        Log.e("asdasdas", "asdffsdfsdfsadfgsdfg")
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        Log.e("asdasdas", "asdffsdfsdfsadfgsdfg")
    }
}