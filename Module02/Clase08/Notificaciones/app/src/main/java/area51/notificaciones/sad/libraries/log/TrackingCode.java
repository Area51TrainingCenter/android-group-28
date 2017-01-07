package area51.notificaciones.sad.libraries.log;

import android.util.Log;

import area51.notificaciones.sad.NoticacionesGlobals;

/**
 * Created by segundo on 7/01/17.
 */

public class TrackingCode {

    public static void getMessage(String message) {
        Log.d(NoticacionesGlobals.LOG, message);
    }

}
