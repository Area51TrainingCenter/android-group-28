package area51.practicam1.screen.grid.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import area51.practicam1.R;
import area51.practicam1.model.Pokemon;

/**
 * Created by segundo on 3/12/16.
 */

public class GalleryAdapter extends ArrayAdapter<Pokemon> {

    Context context;

    public GalleryAdapter(Context context, ArrayList<Pokemon> list) {
        super(context, 0, list);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Viewholder vh;
        if (view == null) {

            vh = new Viewholder();

            view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.row_gallery, parent, false);

            vh.image = (ImageView) view.findViewById(R.id.image);

            view.setTag(vh);

        } else {
            vh = (Viewholder) view.getTag();
        }

        Log.d("getItem", "getItem: " + getItem(position).getImage());

        vh.image.setImageResource(getItem(position).getImage());

        return view;
    }

    static class Viewholder {
        ImageView image;
    }

}
