package area51.videoplayer.libraries.session;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by segundo on 21/11/16.
 */

public class SessionManager {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "android";
    private static final String IS_LOGIN = "isLoggedIn";
    private static final String KEY_IDUSUARIO = "idUsuario";
    private static final String KEY_IDSESSION = "idSession";
    private static final String KEY_FACEBOOKID_USUARIO = "idFacebookUsuario";
    private static final String KEY_IDGCM = "idGcm";
    private static final String KEY_IDDISPOSITIVO = "idDispositivo";
    private static final String KEY_TOKEN_FACEBOOK = "tokenFacebook";
    private static final String KEY_NOMBRE = "nombreUsuario";
    private static final String KEY_APELLIDO = "apellidoUsuario";
    private static final String KEY_CORREO = "correoUsuario";
    private static final String KEY_CONTRASENA = "contrasenaUsuario";
    private static final String KEY_CONTRASENA_REPETIDA = "contrasenaUsuarioREPETIDA";
    private static final String KEY_GENERO = "generoUsuario";
    private static final String KEY_AUTHTOKEN = "authToken";
    private static final String KEY_PAIS = "paisUsuario";
    private static final String KEY_FOTO = "foto";
    private static final String KEY_GROUP_NAME = "group_name";
    private static final String KEY_NATIONAL_ID = "nationalid";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /* ----------------------------------------------------
    *  @ CREAR LA SESSION
    * -------------------------------------------------- */
    public void createLoginSession(String correo) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(KEY_CORREO, correo);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ LOGOUT
    * -------------------------------------------------- */
    public void logoutUser() {
        editor.putString(KEY_IDSESSION, "");
        editor.putString(KEY_CORREO, "");
        editor.putString(KEY_CONTRASENA, "");
        editor.putString(KEY_FACEBOOKID_USUARIO, "");
        editor.putString(KEY_IDUSUARIO, "");
        editor.putString(KEY_NOMBRE, "");
        editor.putString(KEY_IDGCM, "");
        editor.putString(KEY_GENERO, "");
        editor.putString(KEY_AUTHTOKEN, "");
        editor.putString(KEY_PAIS, "");
        editor.putString(KEY_TOKEN_FACEBOOK, "");
        editor.putString(KEY_IDDISPOSITIVO, "");
        editor.putString(KEY_GROUP_NAME, "");
        editor.putString(KEY_FOTO, "");
        editor.putString(KEY_NATIONAL_ID, "");
        editor.putBoolean(IS_LOGIN, false);
        editor.clear();
        editor.commit();


    }

    /* ----------------------------------------------------
    *  @ IS LOGGEDIN
    * -------------------------------------------------- */
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    /* ----------------------------------------------------
    *  @ ID SESSION
    * -------------------------------------------------- */
    public String getIdSession() {
        return pref.getString(KEY_IDSESSION, "");
    }

    /* ----------------------------------------------------
    *  @ ID FACEBOOK
    * -------------------------------------------------- */
    public String getIdFaceBookUsuario() {
        return pref.getString(KEY_FACEBOOKID_USUARIO, "");
    }

    public void setIdFaceBookUsuario(String valor) {
        editor.putString(KEY_FACEBOOKID_USUARIO, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ ID USUARIO
    * -------------------------------------------------- */
    public String getIdUsuario() {
        return pref.getString(KEY_IDUSUARIO, "");
    }

    public void setIdUsuario(String valor) {
        editor.putString(KEY_IDUSUARIO, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ CORREO USUARIO
    * -------------------------------------------------- */
    public String getCorreoUsuario() {
        return pref.getString(KEY_CORREO, "");
    }

    public void setCorreoUsuario(String valor) {
        editor.putString(KEY_CORREO, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ CONTRASEÑA USUARIO
    * -------------------------------------------------- */
    public String getContrasenaUsuario() {
        return pref.getString(KEY_CONTRASENA, "");
    }

    public void setContrasenaUsuario(String valor) {
        editor.putString(KEY_CONTRASENA, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ CONTRASEÑA REPETIDA USUARIO
    * -------------------------------------------------- */
    public String getContrasenaUsuarioRepetida() {
        return pref.getString(KEY_CONTRASENA_REPETIDA, "");
    }

    public void setContrasenaUsuarioRepetida(String valor) {
        editor.putString(KEY_CONTRASENA_REPETIDA, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ APELLIDO USUARIO
    * -------------------------------------------------- */
    public String getApellidoUsuario() {
        return pref.getString(KEY_APELLIDO, "");
    }

    public void setApellidoUsuario(String valor) {
        editor.putString(KEY_APELLIDO, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ NOMBRE USUARIO
    * -------------------------------------------------- */
    public String getNombreUsuario() {
        return pref.getString(KEY_NOMBRE, "");
    }

    public void setNombreUsuario(String valor) {
        editor.putString(KEY_NOMBRE, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ GENENRO USUARIO
    * -------------------------------------------------- */
    public String getGeneroUsuario() {
        return pref.getString(KEY_GENERO, "");
    }

    public void setGeneroUsuario(String valor) {
        editor.putString(KEY_GENERO, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ PAIS USUARIO
    * -------------------------------------------------- */
    public String getPaisUsuario() {
        return pref.getString(KEY_PAIS, "");
    }

    public void setPaisUsuario(String valor) {
        editor.putString(KEY_PAIS, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ ID GCM
    * -------------------------------------------------- */
    public String getIdGcm() {
        return pref.getString(KEY_IDGCM, "");
    }

    public void setIdGcm(String valor) {
        editor.putString(KEY_IDGCM, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ TOKEN FACEBOOK
    * -------------------------------------------------- */
    public String getTokenFacebook() {
        return pref.getString(KEY_TOKEN_FACEBOOK, "");
    }

    public void setTokenFacebook(String valor) {
        editor.putString(KEY_TOKEN_FACEBOOK, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ AUTH TOKEN DEL API
    * -------------------------------------------------- */
    public String getAuthTooken() {
        return pref.getString(KEY_AUTHTOKEN, "");
    }

    public void setAuthTooken(String valor) {
        editor.putString(KEY_AUTHTOKEN, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
    *  @ ID DISPOSITIVO
    * -------------------------------------------------- */
    public String getIdDispositivo() {
        return pref.getString(KEY_IDDISPOSITIVO, "");
    }

    public void setIdDispositivo(String valor) {
        editor.putString(KEY_IDDISPOSITIVO, valor);
        editor.commit();
    }

    /* ----------------------------------------------------
   *  @ FOTO
   * -------------------------------------------------- */
    public String getFoto() {
        return pref.getString(KEY_FOTO, "");
    }

    public void setFoto(String valor) {
        editor.putString(KEY_FOTO, valor);
        editor.commit();
    }


    /* ----------------------------------------------------
    *  @ NATIONAL ID
    * -------------------------------------------------- */
    public String getNationalId() {
        return pref.getString(KEY_NATIONAL_ID, "");
    }

    public void setNationalId(String valor) {
        editor.putString(KEY_NATIONAL_ID, valor);
        editor.commit();
    }


    /* ----------------------------------------------------
    *  @ NATIONAL ID
    * -------------------------------------------------- */
    public String getGroupName() {
        return pref.getString(KEY_GROUP_NAME, "");
    }

    public void setGroupName(String valor) {
        editor.putString(KEY_GROUP_NAME, valor);
        editor.commit();
    }


}