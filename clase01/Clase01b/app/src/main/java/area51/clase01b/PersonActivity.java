package area51.clase01b;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class PersonActivity extends AppCompatActivity {

    ListView list;
    PersonAdapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_person);

        //Creamos al referencia al ListView
        list = (ListView) findViewById(R.id.list);

        context = this;


        loadData();

    }

    public void loadData() {


        Log.d("app", "size: " + Config.people.size());

        adapter = new PersonAdapter(context, Config.people);
        list.setAdapter(adapter);


    }


}
