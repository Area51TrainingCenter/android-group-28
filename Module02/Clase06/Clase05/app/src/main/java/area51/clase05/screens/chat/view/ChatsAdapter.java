package area51.clase05.screens.chat.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import area51.clase05.R;
import area51.clase05.libraries.fresco.TrackingImage;
import area51.clase05.model.People;

/**
 * Created by segundo on 17/12/16.
 */

public class ChatsAdapter extends ArrayAdapter<People> {

    Context context;

    public ChatsAdapter(Context context, ArrayList<People> list) {
        super(context, 0, list);

        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            vh = new ViewHolder();

            view = LayoutInflater.from(context)
                    .inflate(R.layout.row_chats, parent, false);

            vh.photo = (SimpleDraweeView) view.findViewById(R.id.photo);
            vh.name = (TextView) view.findViewById(R.id.name);
            vh.description = (TextView) view.findViewById(R.id.description);
            vh.time = (TextView) view.findViewById(R.id.time);

            view.setTag(vh);

        } else {
            vh = (ViewHolder) view.getTag();
        }

        People people = getItem(position);

        vh.name.setText(people.getName());
        vh.description.setText(people.getEmail());
        vh.time.setText(people.getRegistered().substring(0, 10));

        TrackingImage imageLoader = new TrackingImage(context);
        imageLoader.view = vh.photo;
        imageLoader.url = people.getPicture_large();
        imageLoader.showImage();


        return view;
    }

    static class ViewHolder {
        SimpleDraweeView photo;
        TextView name, description, time;
    }

}
