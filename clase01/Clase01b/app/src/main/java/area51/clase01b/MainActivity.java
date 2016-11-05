package area51.clase01b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Enlazamos las variables con los componentes del diseño
        Button btnList = (Button) findViewById(R.id.btnList);

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, PersonActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        //loadPerson()
    }


    public void loadPerson(View view) {

        Config.people = new ArrayList<Person>();

        for (int i = 0; i < 100; i++) {

            Person person = new Person();

            person.setName("Persona " + i);
            person.setId("" + i);
            person.setAge("" + i * 10);

            Config.people.add(person);

            Log.d("App", "person: " + person.getName());

        }

    }


}
