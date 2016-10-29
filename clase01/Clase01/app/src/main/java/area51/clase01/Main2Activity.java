package area51.clase01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    //Comentario de una linea

    /*
    * Comentario de parrafo
    *
    */

    //Soy una variable de ambito de clase
    String title = "Soy un titulo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Soy una variable de ambito de método
        String title = "";

        title = this.title;

    }

    private void soyPrivado(){
        //Soy un método privado
    }

    public void soyPublico(){
        //Soy un método público
    }

    public String soyUnCadena(){
        //Soy una cadena
        return "";
    }

    public Double soyDouble(){

        //Soy un Double

        Double variable = 0.0;

        return variable;
    }


}
