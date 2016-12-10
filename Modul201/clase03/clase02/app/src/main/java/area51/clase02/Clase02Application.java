package area51.clase02;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import area51.clase02.libraries.fresco.ImagePipelineConfigUtils;

/**
 * Created by segundo on 5/11/16.
 */

public class Clase02Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this,
                ImagePipelineConfigUtils.getDefaultImagePipelineConfig(this)
        );


    }
}
