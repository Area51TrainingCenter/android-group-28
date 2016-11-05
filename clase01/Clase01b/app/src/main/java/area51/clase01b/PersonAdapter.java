package area51.clase01b;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by segundo on 5/11/16.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    Context context;
    ArrayList<Person>list;

    public PersonAdapter(Context context, ArrayList<Person>list) {
        super(context, 0);

        this.context = context;
        this.list = list;

    }



}
