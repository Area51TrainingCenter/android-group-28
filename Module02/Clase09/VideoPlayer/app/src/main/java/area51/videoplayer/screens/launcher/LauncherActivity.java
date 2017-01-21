package area51.videoplayer.screens.launcher;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import area51.videoplayer.R;

import area51.videoplayer.libraries.analytics.VideoPlayerAnalytics;
import area51.videoplayer.libraries.log.TrackingLog;
import area51.videoplayer.libraries.session.SessionManager;
import area51.videoplayer.screens.login.view.LoginActivity;
import area51.videoplayer.screens.login.viewmodel.LoginViewModel;
import area51.videoplayer.screens.welcome.view.MainActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        VideoPlayerAnalytics
                .TrackerScreen(getApplication(), "Launcher");


        SessionManager session = new SessionManager(this);

        Intent intent = null;

        if (session.isLoggedIn()) {
            intent = new Intent(LauncherActivity.this, MainActivity.class);

            TrackingLog.getMessage("session: " + session.getAuthTooken());
            TrackingLog.getMessage("session: " + session.getCorreoUsuario());
            TrackingLog.getMessage("session: " + session.getCorreoUsuario());
            TrackingLog.getMessage("session: " + session.getIdUsuario());


        } else {
            intent = new Intent(LauncherActivity.this, LoginActivity.class);
        }

        startActivity(intent);

    }
}
