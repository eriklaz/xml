package com.lazaro.xml;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class vista_individual extends Activity {

    // XML node keys
    static final String KEY_ESCUELA = "escuela"; // parent node
    static final String KEY_MATRICULA = "matricula";
    static final String KEY_NOMBRE = "nombre";
    static final String KEY_APELLIDOS = "apellidos";
    static final String KEY_CURP = "curp";
    static final String KEY_EMAIL = "email";
    static final String KEY_CARRERA = "carrera";
    static final String KEY_TURNO = "turno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_individual);
        // getting intent data
        Intent in = getIntent();

        // Get XML values from previous intent
        String matricula = in.getStringExtra(KEY_MATRICULA);
        String nombre = in.getStringExtra(KEY_NOMBRE);
        String apellidos = in.getStringExtra(KEY_APELLIDOS);
        String curp = in.getStringExtra(KEY_CURP);
        String email = in.getStringExtra(KEY_EMAIL);
        String carrera = in.getStringExtra(KEY_CARRERA);
        String turno = in.getStringExtra(KEY_TURNO);

        // Displaying all values on the screen
        TextView lblmatri = (TextView) findViewById(R.id.txtmatr);
        TextView lblnombre = (TextView) findViewById(R.id.txtnomb);
        TextView lblapellidos = (TextView) findViewById(R.id.txtapell);
        TextView lblcurp = (TextView) findViewById(R.id.txtcurp);
        TextView lblemail = (TextView) findViewById(R.id.txtemail);
        TextView lblcarrera = (TextView) findViewById(R.id.txtcarr);
        TextView lblturno = (TextView) findViewById(R.id.txttur);

        lblmatri.setText(Html.fromHtml("<b>Matricula:</b> " + matricula));
        lblnombre.setText(Html.fromHtml("<b>Nombre:</b> " + nombre));
        lblapellidos.setText(Html.fromHtml("<b>Apellidos:</b> " + apellidos));
        lblcurp.setText(Html.fromHtml("<b>A CURP:</b> " + curp));
        lblemail.setText(Html.fromHtml("<b>Email:</b> " + email));
        lblcarrera.setText(Html.fromHtml("<b>Carrera:</b> " + carrera));
        lblturno.setText(Html.fromHtml("<b>Turno:</b> " + turno));
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vista_individual, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
