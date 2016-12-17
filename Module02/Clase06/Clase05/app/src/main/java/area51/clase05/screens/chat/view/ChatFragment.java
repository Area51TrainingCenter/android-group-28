package area51.clase05.screens.chat.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import area51.clase05.R;
import area51.clase05.model.People;

public class ChatFragment extends Fragment {

    Context context;

    ArrayList<People> list;
    ChatsAdapter adapter;

    View view;
    SwipeRefreshLayout refresh;
    ListView listview;
    LinearLayout loaders;

    public ChatFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_chat, container, false);

        listview = (ListView) view.findViewById(R.id.list);
        loaders = (LinearLayout) view.findViewById(R.id.loaders);
        refresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = new ArrayList<People>();
        adapter = new ChatsAdapter(context, list);

        getChats();

    }

    public void getChats() {

        //loaders.setVisibility(View.VISIBLE);




    }

}
