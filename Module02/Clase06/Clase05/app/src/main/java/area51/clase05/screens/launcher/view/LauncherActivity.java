package area51.clase05.screens.launcher.view;


import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;


import area51.clase05.Clase05Globals;
import area51.clase05.R;
import area51.clase05.databinding.ActivityLauncherBinding;

import area51.clase05.libraries.log.TrackingLog;
import area51.clase05.screens.launcher.viewmodel.LauncherViewModel;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class LauncherActivity extends AppCompatActivity
        implements EasyPermissions.PermissionCallbacks {

    ActivityLauncherBinding binding;
    LauncherViewModel view;


    private static final int RC_CAMERA_PERM = 123;
    private static final int RC_SETTINGS_SCREEN = 125;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBinding();


    }

    void initBinding() {
        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_launcher);

        view = new LauncherViewModel(this, this, binding);
        binding.setLauncherView(view);

        permissionTask();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SETTINGS_SCREEN) {
            // Do something after user returned from app settings screen, like showing a Toast.
            Toast.makeText(this, R.string.returned_from_app_settings_to_activity, Toast.LENGTH_SHORT)
                    .show();
        }
    }

    //=================================================================
    //EasyPermissions
    //=================================================================
    @AfterPermissionGranted(RC_CAMERA_PERM)
    public void permissionTask() {

        TrackingLog.getLog("permissionTask");

        String[] perms = {
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};


        if (EasyPermissions.hasPermissions(this, perms)) {
            // Have permission, do the thing!
            TrackingLog.getLog("TODO: permissionTask things");
            view.initView();


        } else {
            // Pedir una autorización
            TrackingLog.getLog("Pedir una autorización");

            EasyPermissions.requestPermissions(this, getString(R.string.rationale_camera),
                    RC_CAMERA_PERM, perms);


        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this, getString(R.string.rationale_ask_again))
                    .setTitle(getString(R.string.title_settings_dialog))
                    .setPositiveButton(getString(R.string.setting))
                    .setNegativeButton(getString(R.string.cancel), null /* click listener */)
                    .setRequestCode(RC_SETTINGS_SCREEN)
                    .build()
                    .show();
        }
    }
}
