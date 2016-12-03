package area51.practicam1.screen.grid.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import area51.practicam1.PracticaGlobals;
import area51.practicam1.R;
import area51.practicam1.model.Pokemon;

public class GalleryActivity extends AppCompatActivity {

    ArrayList<Pokemon> pokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        GridView grid = (GridView) findViewById(R.id.grid);

        pokemons = new ArrayList<Pokemon>();


        int[] source = {R.drawable.a1, R.drawable.a2,
                R.drawable.a3, R.drawable.a4, R.drawable.a5};

        for (int i = 0; i < 100; i++) {

            Random rand = new Random();
            int randInt = rand.nextInt(5);

            Pokemon pokemon = new Pokemon();
            pokemon.setImage(source[randInt]);

            //Agregamos el pokemon al arreglo de pokemons :'v
            pokemons.add(pokemon);
        }


        GalleryAdapter adapter = new GalleryAdapter(this, pokemons);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                PracticaGlobals.image = pokemons.get(position).getImage();
                finish();

            }
        });


    }
}
