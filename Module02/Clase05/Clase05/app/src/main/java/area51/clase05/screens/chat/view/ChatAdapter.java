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
 * Created by segundo on 10/12/16.
 */

public class ChatAdapter extends ArrayAdapter<People> {

    Context context;

    public ChatAdapter(Context context, ArrayList<People> array) {
        super(context, 0, array);

        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;

        if (view == null) {
            vh = new ViewHolder();

            view = LayoutInflater.from(context)
                    .inflate(R.layout.row_chat, parent, false);

            vh.picture = (SimpleDraweeView) view.findViewById(R.id.picture);
            vh.name = (TextView) view.findViewById(R.id.name);
            vh.time = (TextView) view.findViewById(R.id.time);

            view.setTag(vh);

        } else {
            vh = (ViewHolder) view.getTag();
        }

        People people = getItem(position);

        vh.name.setText(people.getName());
        vh.time.setText(people.getRegistered());
        
        TrackingImage loaderImage = new TrackingImage(context);
        loaderImage.view = vh.picture;
        loaderImage.url = people.getPicture_large();
        loaderImage.showImage();


        return view;
    }

    static class ViewHolder {
        public TextView name, time;
        SimpleDraweeView picture;
    }


}
