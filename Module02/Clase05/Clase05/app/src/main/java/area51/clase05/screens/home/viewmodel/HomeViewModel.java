package area51.clase05.screens.home.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import area51.clase05.R;
import area51.clase05.databinding.ActivityMainBinding;
import area51.clase05.screens.home.view.HomeStateAdapter;

/**
 * Created by segundo on 10/12/16.
 */

public class HomeViewModel {

    Activity activity;
    Context context;
    ActivityMainBinding binding;
    FragmentManager manager;

    public HomeViewModel(Activity activity,
                         Context context,
                         ActivityMainBinding binding,
                         FragmentManager manager) {

        this.activity = activity;
        this.context = context;
        this.binding = binding;
        this.manager = manager;

    }


    public void initView() {

        initTabs();

        HomeStateAdapter adapter = new HomeStateAdapter(manager);
        binding.pager.setAdapter(adapter);


    }

    void initTabs() {

        binding.tabCalls.setTextColor(
                context.getResources().getColor(R.color.home_tab_normal)
        );

        binding.tabChats.setTextColor(
                context.getResources().getColor(R.color.home_tab_normal)
        );

        binding.tabViewCalls.setBackgroundColor(
                context.getResources().getColor(R.color.colorPrimary)
        );

        binding.tabViewChats.setBackgroundColor(
                context.getResources().getColor(R.color.colorPrimary)
        );

    }


}
