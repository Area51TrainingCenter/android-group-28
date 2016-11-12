package area51.clase02.screen.welcome.view;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import area51.clase02.R;
import area51.clase02.libraries.fresco.TrackingImage;
import area51.clase02.screen.welcome.model.Item;


/**
 * Created by segundo on 5/11/16.
 */

public class ItemAdapter extends ArrayAdapter<Item> {

    Context context;

    public ItemAdapter(Context context, ArrayList<Item> list) {
        super(context, 0, list);
        this.context = context;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;

        if (view == null) {

            holder = new ViewHolder();
            view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.row_item, parent, false);

            holder.name = (TextView) view.findViewById(R.id.name);
            holder.stock = (TextView) view.findViewById(R.id.stock);
            holder.image = (SimpleDraweeView) view.findViewById(R.id.image);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        Item item = getItem(position);

        holder.name.setText(item.getName());
        holder.stock.setText(item.getStock());

        //Agregamos una imagen usando Fresco-lib
        TrackingImage image = new TrackingImage(context);
        //Especificamos que imagen vamos a mostrar
        //image.url = "res:///" + R.mipmap.ic_launcher;
        image.url = item.getImage();
        //En que View lo vamos a mostrar
        image.view = holder.image;

        image.showImage();


        return view;
    }


    static class ViewHolder {
        TextView name, stock;
        SimpleDraweeView image;
    }

}
