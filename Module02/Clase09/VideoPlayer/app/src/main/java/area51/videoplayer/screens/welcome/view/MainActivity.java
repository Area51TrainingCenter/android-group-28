package area51.videoplayer.screens.welcome.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import area51.videoplayer.R;
import area51.videoplayer.databinding.ActivityMainBinding;
import area51.videoplayer.screens.welcome.viewmodel.WelcomeViewModel;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    WelcomeViewModel view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
    }

    void initBinding() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        view = new WelcomeViewModel(this, this, binding);
        binding.setViewWelcome(view);

        view.initView();


    }

}
