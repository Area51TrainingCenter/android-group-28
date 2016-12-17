package area51.clase05;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;


import area51.clase05.libraries.fresco.ImagePipelineConfigUtils;

/**
 * Created by segundo on 10/12/16.
 */

public class Clase05Application extends Application {


    public static final String TAG = Clase05Application.class.getSimpleName();
    private static Clase05Application mInstance;
    private RequestQueue mRequestQueue;


    @Override
    public void onCreate() {
        super.onCreate();
        
        mInstance = this;

        Fresco.initialize(this,
                ImagePipelineConfigUtils.getDefaultImagePipelineConfig(this));

    }


    //============================================================================================================================================================
    // VOLLEY
    //============================================================================================================================================================


    public static synchronized Clase05Application getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}
