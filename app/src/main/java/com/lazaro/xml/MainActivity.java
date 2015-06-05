package com.lazaro.xml;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class MainActivity extends ListActivity {

    // All static variables     eulises subio mi archivo desde su servdor
    static final String URL = "http://eulisesrdz.260mb.net/lazaro/bbdd.xml";
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
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

        XMLParser parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL); // getting XML
        Document doc = parser.getDomElement(xml); // getting DOM element

        NodeList nl = doc.getElementsByTagName(KEY_ESCUELA);

        // looping through all item nodes <item>
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
            map.put(KEY_MATRICULA, parser.getValue(e, KEY_MATRICULA));
            map.put(KEY_NOMBRE, parser.getValue(e, KEY_NOMBRE));
            map.put(KEY_APELLIDOS, parser.getValue(e, KEY_APELLIDOS));
            map.put(KEY_CURP, parser.getValue(e, KEY_CURP));
            map.put(KEY_EMAIL, parser.getValue(e, KEY_EMAIL));
            map.put(KEY_CARRERA, parser.getValue(e, KEY_CARRERA));
            map.put(KEY_TURNO, parser.getValue(e, KEY_TURNO));

            // adding HashList to ArrayList
            menuItems.add(map);
        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.lista_alumnos, new String[] {KEY_MATRICULA, KEY_NOMBRE, KEY_APELLIDOS, KEY_CURP, KEY_EMAIL, KEY_CARRERA, KEY_TURNO},
                new int[] { R.id.txtmatr,R.id.txtnomb,R.id.txtapell,R.id.txtcurp, R.id.txtemail, R.id.txtcarr, R.id.txttur });
        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();
        // listening to single listitem click
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String lblmatri = ((TextView) view.findViewById(R.id.txtmatr)).getText().toString();
                String lblnombre = ((TextView) view.findViewById(R.id.txtnomb)).getText().toString();
                String lblapellidos = ((TextView) view.findViewById(R.id.txtapell)).getText().toString();
                String lblcurp = ((TextView) view.findViewById(R.id.txtcurp)).getText().toString();
                String email = ((TextView) view.findViewById(R.id.txtemail)).getText().toString();
                String carrera = ((TextView) view.findViewById(R.id.txtcarr)).getText().toString();
                String turno = ((TextView) view.findViewById(R.id.txttur)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), vista_individual.class);
                in.putExtra(KEY_MATRICULA, lblmatri);
                in.putExtra(KEY_NOMBRE, lblnombre);
                in.putExtra(KEY_APELLIDOS, lblapellidos);
                in.putExtra(KEY_CURP, lblcurp);
                in.putExtra(KEY_EMAIL, email);
                in.putExtra(KEY_CARRERA, carrera);
                in.putExtra(KEY_TURNO, turno);

                startActivity(in);
            }
        });
    }
}