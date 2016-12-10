package area51.clase05.screens.home.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;

import area51.clase05.R;
import area51.clase05.databinding.ActivityMainBinding;
import area51.clase05.libraries.widgets.activity.Clase05Activity;
import area51.clase05.screens.home.viewmodel.HomeViewModel;

public class MainActivity extends Clase05Activity {

    ActivityMainBinding binding;
    HomeViewModel view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBinding();

    }

    void initBinding() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

}
