package com.example.mehdi.nibras_guide_etudiants;

/**
 * Created by mehdi on 28/04/16.
 */
public class Soundex {
    public Soundex()
    {
    }

    public static String soundex(String s) {
        char[] x = s.toUpperCase().toCharArray();
        char firstLetter = x[0];

        // convert letters to numeric code
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {

                case 'B':
                case 'P':
                    x[i] = '1';
                    break;

                case 'C':
                case 'K':
                case 'Q':
                    x[i] = '2';
                    break;

                case 'D':
                case 'T':
                    x[i] = '3';
                    break;

                case 'L':
                    x[i] = '4';
                    break;

                case 'M':
                case 'N':
                    x[i] = '5';
                    break;

                case 'R':
                    x[i] = '6';
                    break;

                case 'G':
                case 'J':
                    x[i] = '7';
                    break;

                case 'X':
                case 'Z':
                case 'S':
                    x[i] = '8';
                    break;

                case 'F':
                case 'V':
                    x[i] = '9';
                    break;

                default:
                    x[i] = '0';
                    break;
            }
        }
        // remove duplicates
        String output = "" + firstLetter;
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i-1] && x[i] != '0')
                output += x[i];

        // pad with 0's or truncate
        output = output + "0000";
        return output.substring(0, 4);
    }
}
