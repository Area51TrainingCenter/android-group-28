package area51.clase05.screens.profile.viewmodel;

import android.app.Activity;
import android.content.Context;

import area51.clase05.databinding.ActivityProfileBinding;
import area51.clase05.libraries.fresco.TrackingImage;
import area51.clase05.model.People;


/**
 * Created by segundo on 17/12/16.
 */

public class ProfileViewModel {

    Activity activity;
    ActivityProfileBinding binding;
    People people;
    Context context;


    public ProfileViewModel(Activity activity,
                            Context context,
                            ActivityProfileBinding binding,
                            People people) {

        this.context = context;
        this.activity = activity;
        this.binding = binding;
        this.people = people;

    }

    public void initView() {

        TrackingImage imageLoader = new TrackingImage(context);
        imageLoader.view = binding.photo;
        imageLoader.url = people.getPicture_large();
        imageLoader.showImage();

        binding.name.setText(people.getFirst());
        binding.registered.setText(people.getRegistered());
        binding.description.setText(people.getName());
        binding.username.setText(people.getEmail());
        binding.mobile.setText(people.getCell());


    }


}
