package area51.clase05;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import area51.clase05.libraries.fresco.ImagePipelineConfigUtils;

/**
 * Created by segundo on 10/12/16.
 */

public class Clase05Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this,
                ImagePipelineConfigUtils.getDefaultImagePipelineConfig(this));
        

    }
}
