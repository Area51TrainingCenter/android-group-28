package area51.clase02.screen.product.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import area51.clase02.Clase02Globals;
import area51.clase02.R;
import area51.clase02.libraries.fresco.TrackingImage;
import area51.clase02.libraries.fresco.zoomable.ZoomableDraweeView;
import area51.clase02.libraries.log.TrackingLog;
import area51.clase02.screen.welcome.model.Item;

public class PhotoActivity extends AppCompatActivity {

    ZoomableDraweeView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        photo = (ZoomableDraweeView) findViewById(R.id.photo);

        String url = "";

        TrackingLog.getLog("extras: " + getIntent()
                .getExtras());

        if (getIntent().hasExtra(Clase02Globals.bundle_image)) {

            url = getIntent()
                    .getExtras()
                    .getString(Clase02Globals.bundle_image);
        }


        TrackingLog.getLog("url: " + url);


        TrackingImage imageLoader = new TrackingImage(this);
        imageLoader.url = url;
        imageLoader.zoomView = photo;
        imageLoader.showZoomImage();


    }


}
