package area51.clase02.screen.product.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import area51.clase02.Clase02Globals;
import area51.clase02.R;
import area51.clase02.libraries.log.TrackingLog;
import area51.clase02.screen.product.model.Image;

public class PhotoGridActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_grid);

        GridView grid = (GridView) findViewById(R.id.grid);

        TrackingLog.getLog("Extras:" + getIntent()
                .getExtras());

        Image images = (Image) getIntent()
                .getExtras()
                .getSerializable(Clase02Globals.bundle_image);


        ArrayList<Image> array = images.getImages();

        ImageGridAdapter adapter = new ImageGridAdapter(this, array);
        grid.setAdapter(adapter);

    }
}
