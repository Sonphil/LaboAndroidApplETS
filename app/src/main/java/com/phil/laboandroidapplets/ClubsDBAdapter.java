package com.phil.laboandroidapplets;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TSPhi on 2017-01-06.
 */

public class ClubsDBAdapter {
    private Context context;
    private SQLiteOpenHelper DBHelper;
    private SQLiteDatabase db;


    public ClubsDBAdapter(Context context) {
        this.context = context;
        DBHelper = new ClubsDBHelper(context);
        db = DBHelper.getWritableDatabase();
    }

    public long insertClub(Club club) {
        ContentValues newRow = new ContentValues();
        newRow.put(Club.ClubContract.COLUMN_NOM, club.getNom());
        newRow.put(Club.ClubContract.COLUMN_LOCAL, club.getLocal());
        newRow.put(Club.ClubContract.COLUMN_ICONE, club.getIcone());
        newRow.put(Club.ClubContract.COLUMN_SITEWEB, club.getSitweb());

        return db.insert(Club.ClubContract.TABLE_NAME, null, newRow);
    }

    public Cursor getAllClubs() {
        return db.query(Club.ClubContract.TABLE_NAME, null, null, null, null, null, null, null);
    }

    public int getCount() {
        return getAllClubs().getCount();
    }

    public List<Club> getAllClubsAsList() {
        Cursor mCursor = getAllClubs();
        ArrayList<Club> list = new ArrayList<Club>();

        for(mCursor.moveToFirst(); !mCursor.isAfterLast(); mCursor.moveToNext()) {
            String nom = mCursor.getString(mCursor.
                    getColumnIndexOrThrow(Club.ClubContract.COLUMN_NOM));
            String local = mCursor.getString(mCursor.
                    getColumnIndexOrThrow(Club.ClubContract.COLUMN_LOCAL));
            String icone = mCursor.getString(mCursor.
                    getColumnIndexOrThrow(Club.ClubContract.COLUMN_ICONE));
            String siteweb = mCursor.getString(mCursor.
                    getColumnIndexOrThrow(Club.ClubContract.COLUMN_SITEWEB));
            Club club = new Club(nom, local, icone, siteweb);
            list.add(club);
        }

        return list;
    }
}
