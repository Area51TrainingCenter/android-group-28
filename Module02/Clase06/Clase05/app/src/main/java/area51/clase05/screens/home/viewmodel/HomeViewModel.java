package area51.clase05.screens.home.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

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

        //Establecemos la primera pestaña con colores distintos
        binding.pager.setCurrentItem(0);

        binding.tabCalls.setTextColor(
                context.getResources().getColor(R.color.home_tab_hover)
        );
        binding.tabViewCalls.setBackgroundColor(
                context.getResources().getColor(R.color.home_tab_hover)
        );

        //Agregamos el listener de los cambios del ViewPager
        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                initTabs();

                switch (position) {
                    case 0:
                        binding.tabCalls.setTextColor(
                                context.getResources().getColor(R.color.home_tab_hover)
                        );
                        binding.tabViewCalls.setBackgroundColor(
                                context.getResources().getColor(R.color.home_tab_hover)
                        );
                        break;
                    case 1:
                        binding.tabChats.setTextColor(
                                context.getResources().getColor(R.color.home_tab_hover)
                        );
                        binding.tabViewChats.setBackgroundColor(
                                context.getResources().getColor(R.color.home_tab_hover)
                        );
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


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
