package com.example.mehdi.nibras_guide_etudiants;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by mehdi on 06/04/16.
 */
public class Diconnaire extends Activity {
    public SearchView s;
    public ListView lv;
    public Button btn;
    public ArrayList<String> collist_1,collist_2;
    public ArrayAdapter<String> adapter,adapter2;
    MaBaseSQLite dataBaseHelper = new MaBaseSQLite(Diconnaire.this);
    DicoBDD dicoBdd = new DicoBDD(this);
    Cursor c ;
    Dico l = new Dico();
    String listmot = "",motSug = "",mot2 = "";
    Soundex sndx = new Soundex();
    NormalisationFr nrml = new NormalisationFr();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diconnaire);

        collist_1 = new ArrayList<String>();
        collist_2 = new ArrayList<String>();

        s = (SearchView) findViewById(R.id.searchView);
        lv = (ListView) findViewById(R.id.listView);
        btn = (Button) findViewById(R.id.btn_rechercheAvancee);

        //*************
        // ici se fait la copie de la base de donnée si elle est deja crée elle se fera pas
        //*************
        try {
            dataBaseHelper.createDataBase();
        } catch (Exception e) {
            Log.i("Mehdi", "" + e.toString());
        }
        //*************
        // ici on ouvre la base de donnée et on commence part remplir la listView avec les mot de la base de donnée
        //*************


        dicoBdd.open();
        c = dicoBdd.getDico();

        if (c.moveToFirst()) {
            do {
                listmot= c.getString(2) ;
                motSug = c.getString(1);
                collist_1.add(listmot + " : " + motSug);

            }
            while (c.moveToNext());
        }
        dicoBdd.close();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, collist_1);


        lv.setAdapter(adapter);
        //**************
        // ici c la redéfinition des fonction de search view
        //**************

        s.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // TODO Auto-generated method stub
                char[] x = query.toUpperCase().toCharArray();
                char firstLetter = x[0];
                x = query.toLowerCase().toCharArray();
                query = firstLetter+"";
                for(int i=1 ; i<x.length;i++){
                    query = query + ""+x[i];
                }

                dicoBdd.open();
                query = dicoBdd.getFrenchWithFrenchNormalized(query);
                dicoBdd.close();
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }


        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long ids = lv.getItemIdAtPosition(position);
                String mot= lv.getItemAtPosition(position)+"";
                dicoBdd.open();

                Dico dicoResult = dicoBdd.getDicoWithArabic(mot);
                dicoBdd.close();
                //  Toast.makeText(MainActivity.this,dicoResult.getFrench(), Toast.LENGTH_SHORT).show();

                //Toast.makeText(Diconnaire.this, ids + "", Toast.LENGTH_SHORT).show();


            }
        });
    }

    //*************
    // ici c'est la redéfinition des fonction menu
    //*************
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public String ss (String newText){
        newText = nrml.norlamise(newText);
        dicoBdd.open();
        Dico dicoResult = dicoBdd.getDicoWithFrenchNormalized(newText);
        dicoBdd.close();
        newText = dicoResult.getFrench();
        return newText;
    }
    public void lancerRechercheAvancee(View v){
        Intent intent = new Intent(this, RechercheAvancee.class);
        startActivity(intent);
    }
}
