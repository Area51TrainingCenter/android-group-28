package area51.clase05.screens.chat.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import area51.clase05.Clase05Application;
import area51.clase05.Clase05Globals;
import area51.clase05.R;
import area51.clase05.libraries.log.TrackingLog;
import area51.clase05.model.People;

public class ChatFragment extends Fragment {

    Context context;

    ArrayList<People> array;
    ChatsAdapter adapter;

    View view;
    SwipeRefreshLayout refresh;
    ListView listview;
    LinearLayout loaders;


    int PAGE = 1;
    boolean flag_loading = true;


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

        array = new ArrayList<People>();
        adapter = new ChatsAdapter(context, array);
        listview.setAdapter(adapter);


        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                PAGE = 1;
                getChats();
            }
        });

        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                final int lastItem = firstVisibleItem + visibleItemCount;
                if (totalItemCount > 0)
                    if (lastItem == totalItemCount) {
                        if (flag_loading == false) {
                            flag_loading = true;
                            getChats();
                        }
                    }
            }
        });


        getChats();

    }

    public void getChats() {

        if (PAGE == 1) {
            loaders.setVisibility(View.VISIBLE);
            array.clear();
            adapter.notifyDataSetChanged();
        }

        String url = Clase05Globals.rest_calls +
                Clase05Globals.par_results + Clase05Globals.API_ROWS +
                Clase05Globals.par_page + PAGE;

        TrackingLog.getLog("url chats: " + url);

        JsonObjectRequest jo = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        TrackingLog.getLog("response: " + response);

                        try {

                            if (response.has(Clase05Globals.req_results)) {

                                JSONArray data = response.getJSONArray(Clase05Globals.req_results);

                                int total = data.length();
                                JSONObject item = null;

                                for (int i = 0; i < total; i++) {

                                    item = data.getJSONObject(i);
                                    People people = new People();

                                    JSONObject name = item.getJSONObject(Clase05Globals.req_name);

                                    String name_large = name.getString(Clase05Globals.req_first)
                                            + " " + name.getString(Clase05Globals.req_last);

                                    JSONObject picture = item.getJSONObject(Clase05Globals.req_picture);
                                    String picture_large = picture.getString(Clase05Globals.req_large);

                                    people.setEmail(item.getString(Clase05Globals.req_email));
                                    people.setName(name_large);
                                    people.setPicture_large(picture_large);
                                    people.setRegistered(item.getString(Clase05Globals.req_registered));
                                    array.add(people);
                                }

                                adapter.notifyDataSetChanged();

                                if (PAGE == 1) {
                                    loaders.setVisibility(View.GONE);
                                }

                                if (refresh.isRefreshing()) {
                                    refresh.setRefreshing(false);
                                }

                                flag_loading = false;
                                PAGE++;


                            } else {
                                //No hay datos
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        TrackingLog.getLog("error: " + error.getMessage());
                    }
                }
        );


        Clase05Application.getInstance().addToRequestQueue(jo, Clase05Globals.TAG_JSON_OBJ);

    }

}
