package com.example.mehdi.nibras_guide_etudiants;

/**
 * Created by mehdi on 28/04/16.
 */
public class NormalisationFr {
    public NormalisationFr(){}



    public static String norlamise(String s){
        char[] x = s.toLowerCase().toCharArray();

        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {

                case 'à':
                case 'â':
                    x[i] = 'a';
                    break;

                case 'ç':
                    x[i] = 'c';
                    break;

                case 'è':
                case 'é':
                case 'ê':
                    x[i] = 'e';
                    break;

                case 'î':
                    x[i] = 'i';
                    break;

                case 'ô':
                    x[i] = 'o';
                    break;

                case 'ù':
                case 'û':
                    x[i] = 'u';
                    break;


                default:

                    break;
            }

        }
        s = String.valueOf(x);

        return s;

    }
}
