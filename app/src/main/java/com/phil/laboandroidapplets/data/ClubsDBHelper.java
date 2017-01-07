package com.phil.laboandroidapplets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by TSPhi on 2017-01-06.
 */

public class ClubsDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "clubs.db";
    private static final  int DATABASE_VERSION = 1;

    public ClubsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_CLUBS_TABLE = "CREATE TABLE "
                + ClubsContract.TABLE_NAME + " ("
                // ID provenant de BaseColumns
                + ClubsContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ClubsContract.COLUMN_NOM + " TEXT NOT NULL,"
                + ClubsContract.COLUMN_LOCAL + " TEXT NOT NULL,"
                + ClubsContract.COLUMN_ICONE + " TEXT NOT NULL,"
                + ClubsContract.COLUMN_SITEWEB + " TEXT NOT NULL"
                + ");";

        db.execSQL(SQL_CREATE_CLUBS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ClubsContract.TABLE_NAME);
        onCreate(db);
    }
}
