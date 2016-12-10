package area51.clase01;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText name;
    Button add;
    TextView list;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("App", "onCreate");

        setupUI();



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!name.getText().toString().equals("")) {
                    //Se cumple la condición del if

                    Person person = new Person();
                    person.setName( name.getText().toString() );

                    list.setText( list.getText() + person.getName() + " \n" );

                    name.setText("");

                } else {
                    //Se cumple la condición del if :'(
                    Toast.makeText(context, R.string.person_hint, Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    void setupUI() {

        name = (EditText) findViewById(R.id.name);
        add = (Button) findViewById(R.id.add);
        list = (TextView) findViewById(R.id.list);

        context = this;

        list.setText("");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("App", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("App", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("App", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("App", "onDestroy");
    }

}
