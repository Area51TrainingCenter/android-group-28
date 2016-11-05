package area51.clase01b;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
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

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //Creamos la intención hacia que actividad queremos cambiar
                Intent intent =
                        new Intent(PersonActivity.this, PersonDetailActivity.class);

                //Creamos un parametro para enviar los datos
                Bundle bundle = new Bundle();
                bundle.putSerializable(Config.bundle_person, Config.people.get(position) );

                //Asignamos el parametro a la intención
                intent.putExtras(bundle);

                //Cambiamos de actividad
                startActivity(intent);






            }
        });


        loadData();

    }

    public void loadData() {


        Log.d("app", "size: " + Config.people.size());

        adapter = new PersonAdapter(context, Config.people);
        list.setAdapter(adapter);


    }


}
