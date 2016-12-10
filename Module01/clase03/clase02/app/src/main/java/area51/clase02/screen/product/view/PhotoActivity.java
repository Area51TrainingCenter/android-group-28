package area51.clase02.screen.product.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import area51.clase02.Clase02Globals;
import area51.clase02.R;
import area51.clase02.libraries.fresco.TrackingImage;
import area51.clase02.libraries.fresco.zoomable.ZoomableDraweeView;
import area51.clase02.libraries.log.TrackingLog;
import area51.clase02.screen.product.model.Image;
import area51.clase02.screen.welcome.model.Item;

public class PhotoActivity extends AppCompatActivity {

    ZoomableDraweeView photo;
    ImageView btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        photo = (ZoomableDraweeView) findViewById(R.id.photo);
        btnGrid = (ImageView) findViewById(R.id.btnGrid);

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


        final ArrayList<Image> imageArraySerialized = new ArrayList<Image>();


        for (int i = 0; i < 100; i++) {

            Image image = new Image();
            image.setUrl(url);

            imageArraySerialized.add(image);
        }


        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Image imageArray = new Image();
                imageArray.setImages(imageArraySerialized);

                Intent intent =
                        new Intent(PhotoActivity.this,
                                PhotoGridActivity.class);

                Bundle bundle = new Bundle();


                bundle.putSerializable(Clase02Globals.bundle_image, imageArray);
                intent.putExtras(bundle);

                startActivity(intent);

                overridePendingTransition(
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                );


            }
        });


    }


}
