package area51.clase01b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class PersonActivity extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_person);

        //Creamos al referencia al ListView
        list = (ListView)findViewById(R.id.list);



    }

    public void loadData(){



    }



}
