package com.example.mehdi.nibras_guide_etudiants;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * Created by mehdi on 09/05/16.
 */
public class RechercheAvancee extends Activity {
        public SearchView s;
        public ListView lv;
        public ArrayList<String> collist;
        public ArrayAdapter<String> adapter;
        String motSug = "",listmot = "";
        Soundex sndx = new Soundex();
        NormalisationFr nrml = new NormalisationFr();

        DicoBDD dicoBdd = new DicoBDD(this);
        Cursor c ;
@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_avancee);

        collist = new ArrayList<String>();
        s = (SearchView) findViewById(R.id.searchView2);
        lv = (ListView) findViewById(R.id.listView2);



        dicoBdd.open();
        c = dicoBdd.getDico();

        if (c.moveToFirst()) {
                do {
                        listmot= c.getString(2) ;
                        motSug = c.getString(1);
                        collist.add(listmot + " : " + motSug);

                }
                while (c.moveToNext());
        }
        dicoBdd.close();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, collist);


        lv.setAdapter(adapter);

s.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
                char[] x = query.toUpperCase().toCharArray();
                char firstLetter = x[0];
                x = query.toLowerCase().toCharArray();
                query = firstLetter+"";
                for(int i=1 ; i<x.length;i++){
                        query = query + ""+x[i];
                }
                dicoBdd.open();

                query = sugg(query);
                query = dicoBdd.getFrenchNormalizedWithSoundex(query);




                dicoBdd.close();


              adapter.getFilter().filter(query);
                return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            //    adapter.getFilter().filter(newText);
                return false;
        }
});
}

        public String sugg (String text){
                text = nrml.norlamise(text);
                text = sndx.soundex(text);

                return text;
        }
}