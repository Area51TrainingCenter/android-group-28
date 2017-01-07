package area51.clase05.screens.profile.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import area51.clase05.Clase05Application;
import area51.clase05.Clase05Globals;
import area51.clase05.R;
import area51.clase05.databinding.ActivityProfileBinding;
import area51.clase05.libraries.fresco.TrackingImage;
import area51.clase05.libraries.log.TrackingLog;
import area51.clase05.model.People;


/**
 * Created by segundo on 17/12/16.
 */

public class ProfileViewModel {

    Activity activity;
    ActivityProfileBinding binding;
    People people;
    Context context;


    public ProfileViewModel(Activity activity,
                            Context context,
                            ActivityProfileBinding binding,
                            People people) {

        this.context = context;
        this.activity = activity;
        this.binding = binding;
        this.people = people;

    }

    public void initView() {

        TrackingImage imageLoader = new TrackingImage(context);
        imageLoader.view = binding.photo;
        imageLoader.url = people.getPicture_large();
        imageLoader.showImage();

        binding.name.setText(people.getFirst());
        binding.registered.setText(people.getRegistered());
        binding.description.setText(people.getName());
        binding.username.setText(people.getEmail());
        binding.mobile.setText(people.getCell());

        getMedia();

    }

    void getMedia() {

        String url = Clase05Globals.rest_calls +
                Clase05Globals.par_results + Clase05Globals.API_ROWS;

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

                                    JSONObject picture = item.getJSONObject(Clase05Globals.req_picture);
                                    String picture_large = picture.getString(Clase05Globals.req_large);

                                    View view = LayoutInflater.from(context)
                                            .inflate(R.layout.row_media, binding.media, false);

                                    SimpleDraweeView image = (SimpleDraweeView)view.findViewById(R.id.photo);

                                    TrackingImage imageLoader = new TrackingImage(context);
                                    imageLoader.view = image;
                                    imageLoader.url = picture_large;
                                    imageLoader.showImage();

                                    binding.media.addView(view);

                                }

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
