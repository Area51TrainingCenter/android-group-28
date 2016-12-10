package area51.clase05.screens.calls.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import area51.clase05.R;
import area51.clase05.model.People;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends Fragment {

    View view;
    GridView grid;
    CallsAdapter adapter;

    public CallsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_calls, container, false);
        grid = (GridView) view.findViewById(R.id.grid);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<People> array = new ArrayList<People>();
        for (int i = 0; i < 100; i++) {
            People people = new People();
            people.setName("Taylor Swift");
            people.setRegistered("10-08-03");
            people.setPicture_large("http://pixel.nymag.com/imgs/daily/vulture/2016/02/03/3-taylor-swift-game.w529.h529.jpg");
            array.add(people);
        }

        adapter = new CallsAdapter(getActivity(), array);
        grid.setAdapter(adapter);

    }
}

