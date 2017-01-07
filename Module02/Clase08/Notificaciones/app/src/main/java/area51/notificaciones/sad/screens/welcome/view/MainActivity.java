package area51.notificaciones.sad.screens.welcome.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import area51.notificaciones.sad.NoticacionesGlobals;
import area51.notificaciones.sad.R;
import area51.notificaciones.sad.libraries.log.TrackingCode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TrackingCode.getMessage("firebase_fcm: " + NoticacionesGlobals.firebase_fcm);

    }
}
