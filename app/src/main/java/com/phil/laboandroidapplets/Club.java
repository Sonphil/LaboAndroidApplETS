package com.phil.laboandroidapplets;

import android.provider.BaseColumns;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by TSPhi on 2017-01-06.
 */
public class Club {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false)
    private String nom;
    @DatabaseField
    private String local;
    @DatabaseField
    private String icone;
    @DatabaseField
    private String sitweb;

    public Club() {

    }

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

}
