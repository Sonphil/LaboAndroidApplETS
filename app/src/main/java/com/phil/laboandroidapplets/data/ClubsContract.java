package com.phil.laboandroidapplets.data;

import android.provider.BaseColumns;

/**
 * Created by TSPhi on 2017-01-06.
 * Contrat utilisé par le DBHelper afin de créer la BD et la table contenant les clubs
 * Les chaînes de caractères constantes permettent de modifier facilement les noms si le besoin se
 * présente.
 */

public class ClubsContract implements BaseColumns {
    public static String TABLE_NAME = "tableclubs";
    public static String COLUMN_NOM = "nom";
    public static String COLUMN_LOCAL = "local";
    public static String COLUMN_ICONE = "icone";
    public static String COLUMN_SITEWEB = "siteweb";
}
