package area51.notificaciones.sad;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by segundo on 7/01/17.
 */

public class NotificationsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
    }
}
