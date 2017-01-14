package area51.videoplayer.screens.login.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import area51.videoplayer.R;
import area51.videoplayer.databinding.ActivityLoginBinding;
import area51.videoplayer.libraries.analytics.VideoPlayerAnalytics;
import area51.videoplayer.screens.login.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    LoginViewModel view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBinding();

    }

    public void initBinding() {

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_login);

        view = new LoginViewModel(this, this, binding);
        binding.setLoginView(view);
        view.initView();

        //Registramos el analytics
        VideoPlayerAnalytics
                .TrackerScreen(getApplication(), "Login");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        view.onActivityResult(requestCode, resultCode, data);
    }
}
