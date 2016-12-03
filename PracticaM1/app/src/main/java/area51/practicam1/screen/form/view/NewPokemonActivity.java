package area51.practicam1.screen.form.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import area51.practicam1.PracticaGlobals;
import area51.practicam1.R;
import area51.practicam1.model.Pokemon;
import area51.practicam1.screen.grid.view.GalleryActivity;

public class NewPokemonActivity extends AppCompatActivity {

    EditText name, type;
    ImageView image;
    TextView loadFile, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pokemon);

        name = (EditText) findViewById(R.id.name);
        type = (EditText) findViewById(R.id.type);
        image = (ImageView) findViewById(R.id.image);
        loadFile = (TextView) findViewById(R.id.loadFile);
        save = (TextView) findViewById(R.id.save);


        loadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(NewPokemonActivity.this,
                                GalleryActivity.class);

                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pokemon pokemon = new Pokemon();
                pokemon.setName(name.getText().toString());
                pokemon.setType(type.getText().toString());
                if (PracticaGlobals.image != 0) {
                    pokemon.setImage(PracticaGlobals.image);
                } else {
                    pokemon.setImage(R.drawable.a5);
                }

                PracticaGlobals.pokemons.add(pokemon);
                PracticaGlobals.image = 0;

                finish();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (PracticaGlobals.image != 0) {
            image.setImageResource(PracticaGlobals.image);
        }
    }
}
