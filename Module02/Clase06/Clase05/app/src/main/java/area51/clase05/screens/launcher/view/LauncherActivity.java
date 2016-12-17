package area51.clase05.screens.launcher.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import area51.clase05.R;
import area51.clase05.databinding.ActivityLauncherBinding;
import area51.clase05.screens.home.view.MainActivity;
import area51.clase05.screens.launcher.viewmodel.LauncherViewModel;

public class LauncherActivity extends AppCompatActivity {

    ActivityLauncherBinding binding;
    LauncherViewModel view;

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
        view.initView();

    }


}
