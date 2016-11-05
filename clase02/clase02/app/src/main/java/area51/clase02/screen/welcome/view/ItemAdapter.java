package area51.clase02.screen.welcome.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import area51.clase02.R;
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

        if ( view == null ){

            holder = new ViewHolder();
            view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.row_item, parent, false);


        }else{

        }

        return view;
    }

    static class ViewHolder {
        TextView name, stock;
        SimpleDraweeView image;
    }

}
