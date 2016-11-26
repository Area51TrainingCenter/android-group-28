package area51.clase02.screen.product.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import area51.clase02.Clase02Globals;
import area51.clase02.screen.welcome.model.Item;

/**
 * Created by segundo on 26/11/16.
 */

public class ImageAdapter extends FragmentStatePagerAdapter {

    //Arreglo con la cantidad de vistas(fragmentos)
    //a mostrar en el slider

    ArrayList<Item> array;

    public ImageAdapter(FragmentManager fm, ArrayList<Item> array) {
        super(fm);
        this.array = array;
    }

    @Override
    public Fragment getItem(int position) {

        ImageFragment fragment = new ImageFragment();

        Bundle bundle = new Bundle();
        bundle.putString(
                Clase02Globals.bundle_image,
                array.get(position).getImage());

        fragment.setArguments(bundle);


        return fragment;
    }

    @Override
    public int getCount() {
        return array.size();
    }
}
