package area51.clase01b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by segundo on 5/11/16.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    Context context;
    ArrayList<Person> list;

    public PersonAdapter(Context context, ArrayList<Person> list) {

        super(context, 0, list);

        this.context = context;
        this.list = list;

    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Log.d("App","Mostramos el elemento: " + position);

        HolderView holder;

        if (view == null) {
            holder = new HolderView();

            view = LayoutInflater
                    .from(context)
                    .inflate(R.layout.row_person, parent, false);

            //Referenciamos el componente del xml (row_person)
            //hacia la clase estatica HolderView

            holder.name = (TextView) view.findViewById(R.id.name);
            holder.age = (TextView) view.findViewById(R.id.age);

            view.setTag(holder);

        } else {
            holder = (HolderView) view.getTag();
        }

        Person person = getItem(position);

        holder.name.setText(person.getName());
        holder.age.setText(person.getAge());

        return view;
    }

    static class HolderView {
        public TextView name, age;
    }


}
