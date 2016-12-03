package area51.practicam1.screen.home.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import area51.practicam1.R;
import area51.practicam1.model.Pokemon;

/**
 * Created by segundo on 3/12/16.
 */

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    Context context;

    public PokemonAdapter(Context context, ArrayList<Pokemon> list) {
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
                    .inflate(R.layout.row_pokemon, parent, false);

            vh.image = (ImageView) view.findViewById(R.id.image);
            vh.name = (TextView) view.findViewById(R.id.name);
            vh.type = (TextView) view.findViewById(R.id.type);

            view.setTag(vh);

        } else {
            vh = (ViewHolder) view.getTag();
        }

        vh.name.setText(getItem(position).getName());
        vh.type.setText(getItem(position).getType());


        return view;
    }

    static class ViewHolder {
        ImageView image;
        TextView name, type;
    }

}
