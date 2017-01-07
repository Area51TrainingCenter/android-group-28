package area51.clase05.screens.profile.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;

import area51.clase05.Clase05Globals;
import area51.clase05.R;
import area51.clase05.databinding.ActivityProfileBinding;
import area51.clase05.libraries.widgets.activity.Clase05Activity;
import area51.clase05.model.People;
import area51.clase05.screens.profile.viewmodel.ProfileViewModel;

public class ProfileActivity extends Clase05Activity {

    ActivityProfileBinding binding;
    ProfileViewModel view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBinding();
    }

    void initBinding() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile);

        People people = (People) getIntent()
                .getExtras()
                .getSerializable(Clase05Globals.bundle_people);

        view = new ProfileViewModel(this, this, binding, people);

        binding.setProfileView(view);
        view.initView();

    }

}
