package area51.notificaciones.sad.libraries.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import area51.notificaciones.sad.NoticacionesGlobals;
import area51.notificaciones.sad.libraries.log.TrackingCode;

/**
 * Created by segundo on 7/01/17.
 */

public class NotificacionesInstanceIDService
        extends FirebaseInstanceIdService {


    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        NoticacionesGlobals.firebase_fcm = FirebaseInstanceId.getInstance().getToken();

        TrackingCode.getMessage("onTokenRefresh: " +
                FirebaseInstanceId.getInstance().getToken());

    }


}
