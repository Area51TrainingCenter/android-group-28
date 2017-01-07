package area51.notificaciones.sad.screens.home.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import area51.notificaciones.sad.models.People;

/**
 * Created by segundo on 7/01/17.
 */

public class HomeAdapter extends ArrayAdapter<People> {

    Context context;

    public HomeAdapter(Context context, ArrayList<People> list) {
        super(context, 0, list);

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder vh;
        if (view == null) {
            vh = new ViewHolder();

            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }

        return view;
    }

    static class ViewHolder {
        SimpleDraweeView photo;
        TextView title, description;

    }

}
