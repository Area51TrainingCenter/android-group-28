package area51.clase02.screen.welcome.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        for (int i = 0; i < 20; i++) {

            Item item = new Item();
            item.setId("" + i);
            item.setName("name " + i);
            item.setStock("" + i * 20);

            array.add(item);

        }

        adapter = new ItemAdapter(context, array);
        list.setAdapter(adapter);

        //adapter.notifyDataSetChanged();

    }
}
