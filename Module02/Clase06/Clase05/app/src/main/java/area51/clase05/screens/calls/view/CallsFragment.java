package area51.clase05.screens.calls.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import area51.clase05.Clase05Application;
import area51.clase05.Clase05Globals;
import area51.clase05.R;
import area51.clase05.libraries.log.TrackingLog;
import area51.clase05.model.People;

/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends Fragment {

    View view;
    GridView grid;

    SwipeRefreshLayout refresh;
    LinearLayout loaders;

    ArrayList<People> array;
    CallsAdapter adapter;

    int PAGE = 1;

    public CallsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_calls, container, false);
        grid = (GridView) view.findViewById(R.id.grid);
        loaders = (LinearLayout) view.findViewById(R.id.loaders);
        refresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        array = new ArrayList<People>();
        adapter = new CallsAdapter(getActivity(), array);
        grid.setAdapter(adapter);

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                PAGE = 1;
                getCalls();
            }
        });

        /*
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
        */

        getCalls();
    }

    public void getCalls() {

        if (PAGE == 1) {
            loaders.setVisibility(View.VISIBLE);
            array.clear();
            adapter.notifyDataSetChanged();
        }

        String url = Clase05Globals.rest_calls +
                Clase05Globals.par_results + Clase05Globals.API_ROWS +
                Clase05Globals.par_page + PAGE;

        TrackingLog.getLog("url: " + url);

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

