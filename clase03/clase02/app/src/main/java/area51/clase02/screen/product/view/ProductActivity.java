package area51.clase02.screen.product.view;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import area51.clase02.Clase02Globals;
import area51.clase02.R;
import area51.clase02.libraries.fresco.TrackingImage;
import area51.clase02.screen.welcome.model.Item;

public class ProductActivity extends AppCompatActivity {

    LinearLayout progress;
    SimpleDraweeView photo;
    TextView name, price, stock, description;

    Context context;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        loadUI();

        item = (Item) getIntent()
                .getExtras()
                .getSerializable(Clase02Globals.bundle_item);

        showView();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.setVisibility(View.GONE);
            }

        }, 1000);

    }

    void loadUI() {

        context = this;

        progress = (LinearLayout) findViewById(R.id.progress);
        photo = (SimpleDraweeView) findViewById(R.id.photo);
        name = (TextView) findViewById(R.id.name);
        price = (TextView) findViewById(R.id.price);
        stock = (TextView) findViewById(R.id.stock);
        description = (TextView) findViewById(R.id.description);

        progress.setVisibility(View.VISIBLE);

    }

    void showView() {

        TrackingImage image = new TrackingImage(context);
        image.url = item.getImage();
        image.view = photo;
        image.showImage();

        name.setText(item.getName());
        price.setText(item.getStock());
        stock.setText(item.getStock());
        description.setText(item.getDescription());


    }

}
