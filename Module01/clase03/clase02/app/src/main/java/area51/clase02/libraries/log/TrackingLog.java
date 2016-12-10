package area51.clase02.libraries.log;


import android.util.Log;

import area51.clase02.Clase02Globals;

/**
 * Created by segundo on 12/11/16.
 */

public class TrackingLog {

    public static void getLog(String text) {

        Log.d(Clase02Globals.APP_LOG, text);

    }

}
