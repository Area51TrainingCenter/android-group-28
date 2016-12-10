package area51.clase01b;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PersonDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Método que carga el xml con el contenido visual
        setContentView(R.layout.activity_person_detail);

        Person person = (Person) getIntent().getExtras().getSerializable(Config.bundle_person);

        //Referenciamos a los componentes visuales
        TextView name = (TextView) findViewById(R.id.name);
        TextView age = (TextView) findViewById(R.id.age);

        //Mostramos los datos
        name.setText(person.getName());
        age.setText(person.getAge());


    }


}
