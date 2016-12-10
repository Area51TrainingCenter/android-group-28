package area51.clase05.libraries.log;


import android.util.Log;

import area51.clase05.Clase05Globals;


/**
 * Created by segundo on 12/11/16.
 */

public class TrackingLog {

    public static void getLog(String text) {

        Log.d(Clase05Globals.APP_LOG, text);

    }

}
