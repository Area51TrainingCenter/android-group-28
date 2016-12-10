package area51.clase05.screens.home.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import area51.clase05.databinding.ActivityMainBinding;

/**
 * Created by segundo on 10/12/16.
 */

public class HomeViewModel {

    Activity activity;
    Context context;
    ActivityMainBinding binding;

    public HomeViewModel(Activity activity,
                         Context context,
                         ActivityMainBinding binding) {

        this.activity = activity;
        this.context = context;
        this.binding = binding;

    }

    public void initView() {

    }

    void initTabs(){



    }


}
