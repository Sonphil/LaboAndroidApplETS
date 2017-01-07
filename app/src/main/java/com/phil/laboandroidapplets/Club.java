package com.phil.laboandroidapplets;

import android.provider.BaseColumns;

/**
 * Created by TSPhi on 2017-01-06.
 */
public class Club implements BaseColumns{

    private String nom;
    private String local;
    private String icone;
    private String sitweb;

    public Club(String nom, String local, String icone, String sitweb) {
        this.nom = nom;
        this.local = local;
        this.icone = icone;
        this.sitweb = sitweb;
    }

    public String getNom() {
        return nom;
    }

    public String getLocal() {
        return local;
    }

    public String getIcone() {
        return icone;
    }

    public String getSitweb() {
        return sitweb;
    }

    /**
     * Contrat utilisé par le DBHelper afin de créer la BD et la table contenant les clubs
     * Les chaînes de caractères constantes permettent de modifier facilement les noms si le besoin
     * se présente.
     */
    public static final class ClubContract implements BaseColumns {
        public static final String TABLE_NAME = "tableclubs";
        public static final String COLUMN_NOM = "nom";
        public static final String COLUMN_LOCAL = "local";
        public static final String COLUMN_ICONE = "icone";
        public static final String COLUMN_SITEWEB = "siteweb";
    }
}
