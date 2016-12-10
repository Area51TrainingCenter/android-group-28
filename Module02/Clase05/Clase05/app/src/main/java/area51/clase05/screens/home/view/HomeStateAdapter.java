package area51.clase05.screens.home.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import area51.clase05.screens.calls.view.CallsFragment;
import area51.clase05.screens.chat.view.ChatFragment;

/**
 * Created by segundo on 10/12/16.
 */

public class HomeStateAdapter extends FragmentStatePagerAdapter {

    public HomeStateAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0: {
                fragment = new CallsFragment();
                break;
            }
            case 2: {
                fragment = new ChatFragment();
                break;
            }
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
