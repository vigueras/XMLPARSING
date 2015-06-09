package com.example.guadalupe.xmlparsing;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;



public class MainActivity extends ListActivity {

    // All static variables
    static final String URL = "http://169.254.139.239/app/bbdd.xml";
    // XML node keys
    static final String KEY_ID_PLANTA = "id_planta"; // parent node
    static final String KEY_NOMBRE_PLANTA = "nombre_planta";
    static final String KEY_TIPO_PLANTA = "tipo_planta";
    static final String KEY_COLOR_PLANTA = "color_planta";
    static final String KEY_PRECIO = "precio";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

        XMLParse parser = new XMLParse();
        String xml = parser.getXmlFromUrl(URL); // getting XML
        Document doc = parser.getDomElement(xml); // getting DOM element

        NodeList nl = doc.getElementsByTagName(KEY_ID_PLANTA);

        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
            map.put(KEY_ID_PLANTA, parser.getValue(e, KEY_ID_PLANTA));
            map.put(KEY_NOMBRE_PLANTA, parser.getValue(e, KEY_NOMBRE_PLANTA));
            map.put(KEY_TIPO_PLANTA, "Rs." + parser.getValue(e, KEY_TIPO_PLANTA));
            map.put(KEY_COLOR_PLANTA, parser.getValue(e, KEY_COLOR_PLANTA));
            map.put(KEY_PRECIO, parser.getValue(e, KEY_PRECIO));


            // adding HashList to ArrayList
            menuItems.add(map);

        }

        // Adding menuItems to ListView
        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.lista_plantas,
                new String[] { KEY_ID_PLANTA, KEY_NOMBRE_PLANTA }, new int[] {
                R.id.id_plat, R.id.nombre_plannn});

        setListAdapter(adapter);

        // selecting single ListView item
        ListView lv = getListView();

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem
                String tx_calvepres = ((TextView) view.findViewById(R.id.id_plat)).getText().toString();
                String tx_fec = ((TextView) view.findViewById(R.id.nombre_plannn)).getText().toString();


                // Starting new intent
                Intent in = new Intent(getApplicationContext(), Vista_Indiv.class);
                in.putExtra(KEY_ID_PLANTA, tx_calvepres);
                in.putExtra(KEY_NOMBRE_PLANTA, tx_fec);

                startActivity(in);

            }
        });
    }
}