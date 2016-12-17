package area51.clase05.libraries.fresco;

import android.content.Context;
import android.net.Uri;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import area51.clase05.libraries.fresco.CircleProgressBarDrawable;
import area51.clase05.libraries.fresco.zoomable.ZoomableDraweeView;
import area51.clase05.libraries.log.TrackingLog;


/**
 * Created by segundo on 12/11/16.
 */

public class TrackingImage {

    Context context;
    public SimpleDraweeView view;
    public ZoomableDraweeView zoomView;
    public String url;

    public TrackingImage(Context context) {
        this.context = context;
    }

    public void showZoomImage() {

        TrackingLog.getLog("url:" + url);

        DraweeController ctrl = Fresco
                .newDraweeControllerBuilder()
                .setUri(Uri.parse(url))
                .setTapToRetryEnabled(true).build();

        GenericDraweeHierarchy hierarchy =
                new GenericDraweeHierarchyBuilder(context.getResources())
                        .setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER)
                        .setProgressBarImage(new CircleProgressBarDrawable())
                        .build();

        zoomView.setController(ctrl);
        zoomView.setHierarchy(hierarchy);

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
