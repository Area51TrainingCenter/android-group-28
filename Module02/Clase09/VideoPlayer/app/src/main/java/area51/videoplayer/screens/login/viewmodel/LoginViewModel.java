package area51.videoplayer.screens.login.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import area51.videoplayer.databinding.ActivityLoginBinding;
import area51.videoplayer.libraries.analytics.VideoPlayerAnalytics;
import area51.videoplayer.libraries.log.TrackingLog;
import area51.videoplayer.libraries.session.SessionManager;
import area51.videoplayer.screens.welcome.view.MainActivity;

/**
 * Created by segundo on 14/01/17.
 */

public class LoginViewModel {

    Activity activity;
    Context context;
    ActivityLoginBinding binding;

    //Session
    SessionManager session;

    //Facebook SDK
    CallbackManager callback;

    public LoginViewModel(Activity activity,
                          Context context,
                          ActivityLoginBinding binding) {

        this.activity = activity;
        this.context = context;
        this.binding = binding;

    }

    public void initView() {

        binding.btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebookSDK();
            }
        });

    }

    public void facebookSDK() {

        VideoPlayerAnalytics.TrackerEvents(
                activity.getApplication(),
                "LoginWithFacebook");

        callback = CallbackManager.Factory.create();

        LoginManager.getInstance()
                .logInWithReadPermissions(activity,
                        Arrays.asList("email", "public_profile")
                );

        LoginManager.getInstance().registerCallback(callback, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                TrackingLog.getMessage("FacebookSDK onSuccess");
                TrackingLog.getMessage("FacebookSDK loginResult.getAccessToken(): "
                        + loginResult.getAccessToken());

                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(JSONObject user, GraphResponse response) {

                                if (response.getError() != null) {

                                    TrackingLog.getMessage("Facebook SDK error: " +
                                            response.getError().getErrorMessage());

                                    TrackingLog.getMessage("Facebook SDK error: " +
                                            response.getError().getErrorCode());

                                } else {
                                    try {

                                        session = new SessionManager(context);
                                        session.setTokenFacebook("" + AccessToken.getCurrentAccessToken().getToken());

                                        TrackingLog.getMessage("user: " + user);
                                        session.setIdUsuario(user.getString("id"));

                                        if (user.has("name")) {
                                            session.setNombreUsuario(user.getString("name"));
                                        }

                                        if (user.has("email")) {
                                            session.setCorreoUsuario(user.getString("email"));
                                        }

                                        if (user.has("picture")) {
                                            if (user.getJSONObject("picture").has("data")) {
                                                session.setFoto(
                                                        user.getJSONObject("picture")
                                                                .getJSONObject("data")
                                                                .getString("url")
                                                );
                                            }
                                        }

                                        session.createLoginSession(session.getIdUsuario());

                                        Intent intent = new Intent(activity, MainActivity.class);
                                        activity.startActivity(intent);


                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }
                );

                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,email,name,first_name,last_name,link,gender,picture");
                request.setParameters(parameters);
                request.executeAsync();


            }

            @Override
            public void onCancel() {
                TrackingLog.getMessage("FacebookSDK Cancel");
            }

            @Override
            public void onError(FacebookException error) {
                TrackingLog.getMessage("FacebookSDK Error");
            }
        });


    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (callback.onActivityResult(requestCode, resultCode, data)) {
            return;
        }

    }


}
