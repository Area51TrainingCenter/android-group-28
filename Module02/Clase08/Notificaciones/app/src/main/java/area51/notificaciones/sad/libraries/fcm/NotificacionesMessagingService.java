package area51.notificaciones.sad.libraries.fcm;

import android.app.PendingIntent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import area51.notificaciones.sad.libraries.log.TrackingCode;

/**
 * Created by segundo on 7/01/17.
 */

public class NotificacionesMessagingService
        extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        TrackingCode.getMessage("onMessageReceived: " + remoteMessage);
        TrackingCode.getMessage("onMessageReceived: " + remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {

            TrackingCode.getMessage("Notification body: " +
                    remoteMessage.getNotification().getBody());


            displayNotification(remoteMessage.getNotification(),
                    remoteMessage.getData());

        }

    }

    void displayNotification(RemoteMessage.Notification notification,
                             Map<String, String> data) {

        TrackingCode.getMessage("data: " + data);

        



        //PendingIntent pendingIntent


    }

}
