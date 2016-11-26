package area51.clase02.screen.product.view;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import area51.clase02.Clase02Globals;
import area51.clase02.R;
import area51.clase02.libraries.fresco.TrackingImage;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageFragment extends Fragment {

    SimpleDraweeView image;
    View root;
    Context context;
    Activity activity;

    String urlImage;

    public ImageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();
        activity = getActivity();

        //Recibimos el parametro enviado desde el adapter
        urlImage = getArguments().getString(Clase02Globals.bundle_image);

    }

    /*
        onCreateView
        Este método agrega el diseño(xml) al fragmento
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_image, container, false);

        image = (SimpleDraweeView) root.findViewById(R.id.image);

        return root;
    }


    /*
        onActivityCreated
        Este método se ejecuta cuando el fragmento ha sido
        agregado al Activity
     */

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TrackingImage imageLoader = new TrackingImage(context);
        imageLoader.view = image;
        imageLoader.url = urlImage;
        imageLoader.showImage();

    }
}
