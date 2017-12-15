package com.example.mehdi.nibras_guide_etudiants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mehdi on 28/04/16.
 */
public class DicoBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "Nibras.sqlite";

    private static final String TABLE_LIVRES = "univ";
    public static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    public static final String COL_ARABIC = "ARABIC";
    private static final int NUM_COL_ARABIC = 1;
    public static final String COL_FRENCH = "FRENCH";
    public static final int NUM_COL_FRENCH = 2;
    public static final String COL_ARABIC_NORMALIZED = "ARABIC_NORMALIZED";
    private static final int NUM_COL_ARABIC_NORMALIZED = 4;
    public static final String COL_FRENCH_NORMALIZED = "FRENCH_NORMALIZED";
    private static final int NUM_COL_FRENCH_NORMALIZED = 5;
    public static final String COL_SOUNDEX = "SOUNDEX";
    private static final int NUM_COL_SOUNDEX = 6;

    private SQLiteDatabase bdd;
    private MaBaseSQLite maBaseSQLite;

    public DicoBDD(Context context){
        //On crée la BDD et sa table
        maBaseSQLite = new MaBaseSQLite(context);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertDico(Dico livre){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_ARABIC, livre.getArabic());
        values.put(COL_FRENCH, livre.getFrench());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_LIVRES, null, values);
    }

    public int updateDico(int id, Dico livre){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_ARABIC, livre.getArabic());
        values.put(COL_FRENCH, livre.getFrench());
        return bdd.update(TABLE_LIVRES, values, COL_ID + " = " + id, null);
    }

    public int removeDicoWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_LIVRES, COL_ID + " = " + id, null);
    }

    public Dico getDicoWithTitre(String titre){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_LIVRES, new String[] {COL_ID, COL_ARABIC, COL_FRENCH}, COL_FRENCH + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToDico(c);
    }

    //Cette méthode permet de convertir un cursor en un livre
    public Dico cursorToDico(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Dico livre = new Dico();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        livre.setId(c.getInt(NUM_COL_ID));
        livre.setArabic(c.getString(NUM_COL_ARABIC));
        livre.setFrench(c.getString(NUM_COL_FRENCH));
        //On ferme le cursor
        c.close();

        //On retourne le livre
        return livre;
    }
    public Cursor getDico() {
        // sélection de tous les enregistrements de la table
        return bdd.rawQuery("SELECT * FROM "+TABLE_LIVRES, null);
    }

    public void cursorToString(Cursor c, String tab[]){
        int i=0;
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return ;

        if(c.moveToFirst()){
            do{
                //assing values
                tab[i] = c.getString(2);
                i++;
                //Do something Here with values

            }while(c.moveToNext());
        }
        c.close();



    }
    public Dico getDicoWithFrench(String titre){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_LIVRES, new String[] {COL_ID, COL_ARABIC, COL_FRENCH}, COL_FRENCH + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToDico(c);
    }

    public Dico getDicoWithFrenchNormalized(String titre){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_LIVRES, new String[] {COL_ID, COL_ARABIC,COL_FRENCH, COL_FRENCH_NORMALIZED}, COL_FRENCH_NORMALIZED + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToDico(c);
    }
    public Dico getDicoWithArabic(String titre){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_LIVRES, new String[] {COL_ID, COL_ARABIC,COL_FRENCH}, COL_ARABIC + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToDico(c);
    }
    public String getFrenchWithFrenchNormalized(String text){
        Cursor c = bdd.query(TABLE_LIVRES, new String[]{COL_FRENCH}, COL_FRENCH_NORMALIZED+"=? ", new String[]{text}, null, null, null);

        return cursorToStrings(c, text);
    }
    public String getFrenchNormalizedWithSoundex(String text){
        Cursor c = bdd.query(TABLE_LIVRES, new String[]{COL_FRENCH_NORMALIZED}, COL_SOUNDEX+"=? ", new String[]{text}, null, null, null);

        return cursorToStrings(c,text);
    }
    public String cursorToStrings(Cursor c, String text) {
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        if (c.moveToFirst()) {
            do {
                //assing values
                text = c.getString(0);
                //Do something Here with values

            } while (c.moveToNext());
        }
        c.close();
        return text;
    }
}
