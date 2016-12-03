package area51.practicam1.screen.home.view;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import area51.practicam1.PracticaGlobals;
import area51.practicam1.R;
import area51.practicam1.model.Pokemon;
import area51.practicam1.screen.form.view.NewPokemonActivity;

public class MainActivity extends AppCompatActivity {

    PokemonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);
        ImageButton btnAdd = (ImageButton) findViewById(R.id.btnAdd);

        getItem();
        adapter = new PokemonAdapter(this, PracticaGlobals.pokemons);

        list.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent
                        = new Intent(MainActivity.this, NewPokemonActivity.class);

                startActivity(intent);

            }
        });


    }


    void getItem() {

        PracticaGlobals.pokemons = new ArrayList<Pokemon>();

        for (int i = 0; i < 10; i++) {
            Pokemon pokemon = new Pokemon();
            pokemon.setName("Pokemon " + i);
            pokemon.setType("Tipo" + i);

            //PracticaGlobals.pokemons.add(pokemon);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();

    }
}
