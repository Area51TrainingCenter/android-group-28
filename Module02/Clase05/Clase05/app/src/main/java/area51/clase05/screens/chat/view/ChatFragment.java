package area51.clase05.screens.chat.view;

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
import area51.clase05.screens.calls.view.CallsAdapter;

public class ChatFragment extends Fragment {

    View view;
    public ChatFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_calls, container, false);



        return view;
    }

}
