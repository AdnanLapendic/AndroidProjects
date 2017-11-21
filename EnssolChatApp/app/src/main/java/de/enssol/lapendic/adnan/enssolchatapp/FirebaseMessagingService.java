package de.enssol.lapendic.adnan.enssolchatapp;

import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by lapa on 21.11.2017..
 */

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService{



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String notificationTitle = remoteMessage.getNotification().getTitle();
        String notificationMessage = remoteMessage.getNotification().getBody();

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(notificationTitle)
                        .setContentText(notificationMessage);

                  int mNotificationId = (int) System.currentTimeMillis();
                    // Gets an instance of the NotificationManager service
                     NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    // Builds the notification and issues it.
                     mNotifyMgr.notify(mNotificationId, mBuilder.build());


    }
}
