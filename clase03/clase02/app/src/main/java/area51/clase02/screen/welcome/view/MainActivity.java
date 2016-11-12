package area51.clase02.screen.welcome.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import area51.clase02.R;
import area51.clase02.screen.welcome.model.Item;

public class MainActivity extends AppCompatActivity {

    ItemAdapter adapter;
    ListView list;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        context = this;

        ArrayList<Item> array = new ArrayList<Item>();

        Item item = new Item();
        item.setId("");
        item.setName("Smart");
        item.setImage("https://www.megatone.net/Images/Articulos/zoom/TEL4865SSGg.jpg");
        item.setDescription("Trascendiendo la tecnología LED, cada píxel de este televisor de Samsung permitirá que te sumerjas en una iluminación de colores inigualables. Tu experiencia nunca será igual. Permite que tus ojos se relajen y vive una experiencia visual en forma natural y confortable");
        item.setStock("20");

        for (int i = 0; i < 100; i++) {
            //Agregamos items al arreglo
            array.add(item);
        }


        adapter = new ItemAdapter(context, array);
        list.setAdapter(adapter);

        //adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
            }
        });


    }
}
