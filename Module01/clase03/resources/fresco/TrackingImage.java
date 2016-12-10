package area51.clase02.libraries.fresco;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import area51.clase02.R;
import area51.clase02.libraries.log.TrackingLog;

/**
 * Created by segundo on 12/11/16.
 */

public class TrackingImage {

    Context context;
    public SimpleDraweeView view;
    public String url;

    public TrackingImage(Context context) {
        this.context = context;
    }

    public void showImage() {

        TrackingLog.getLog("url:" + url);

        //Agregamos una imagen de la aplicación
        //Uri uri = Uri.parse("res:///" + R.mipmap.ic_launcher);

        //Imagen de Internet
        Uri uri = Uri.parse(this.url);

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .setOldController(view.getController())
                .build();

        view.setController(controller);

    }


}
