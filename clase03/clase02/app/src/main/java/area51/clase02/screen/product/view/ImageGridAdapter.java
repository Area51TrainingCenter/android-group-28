package area51.clase02.screen.product.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import area51.clase02.R;
import area51.clase02.libraries.fresco.TrackingImage;
import area51.clase02.screen.product.model.Image;

/**
 * Created by segundo on 26/11/16.
 */

public class ImageGridAdapter extends ArrayAdapter<Image> {

    Context context;

    public ImageGridAdapter(Context context, ArrayList<Image> array) {
        super(context, 0, array);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();

            view = LayoutInflater.from(context)
                    .inflate(R.layout.row_photo, parent, false);

            holder.image = (SimpleDraweeView) view.findViewById(R.id.image);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        TrackingImage imageLoader = new TrackingImage(context);
        imageLoader.view = holder.image;
        imageLoader.url = getItem(position).getUrl();
        imageLoader.showImage();


        return view;
    }

    static class ViewHolder {
        SimpleDraweeView image;
    }


}
