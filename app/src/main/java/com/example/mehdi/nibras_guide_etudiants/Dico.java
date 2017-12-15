package com.example.mehdi.nibras_guide_etudiants;

/**
 * Created by mehdi on 28/04/16.
 */
public class Dico {
        private int id;
        private String arabic;
        private String french;
        private String arabic_normalized;
        private String french_normalized;
        private String soundex;
        public Dico(){}

        public Dico(String arabic, String french){
            this.arabic = arabic;
            this.french = french;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getArabic() {
            return arabic;
        }

        public void setArabic(String arabic) {
            this.arabic = arabic;
        }

        public String getFrench() {
            return french;
        }

        public void setFrench(String french) {
            this.french = french;
        }


        public String getArabicNormalized() {
            return arabic_normalized;
        }

        public void setArabicNormalized(String arabic_normalized) {
            this.arabic_normalized = arabic_normalized;
        }

        public String getFrenchNormalized() {
            return french_normalized;
        }

        public void setFrenchNormalized(String french_normalized) {
            this.french_normalized = french_normalized;
        }
         public String getSoundex(){
             return soundex;
         }
        public void setSoundex(String soundex){
            this.soundex = soundex;
         }

        public String toString(){
            return "ID : "+id+"\nARABIC : "+arabic+"\nFRENCH : "+french;
        }
    }


