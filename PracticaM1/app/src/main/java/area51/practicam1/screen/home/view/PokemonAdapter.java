package area51.practicam1.screen.home.view;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import area51.practicam1.model.Pokemon;

/**
 * Created by segundo on 3/12/16.
 */

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    Context context;

    public PokemonAdapter(Context context, ArrayList<Pokemon> list) {
        super(context, 0, list);
    }




}
