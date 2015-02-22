package com.example.silverwindz.project1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CalorieDBHelper extends SQLiteOpenHelper {

    private static final String name = "cal.sqlite3";
    private static final int version = 2;


    public CalorieDBHelper(Context ctx) {
        super(ctx, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE course (" +
                "_id integer primary key autoincrement," +
                "gender text not null," +             // course code
                "height double default 0," +           // credit
                "weight double defalut 0," +            // letter grade e.g. A, B+
                "age double defalut 0," +
                "bmr double defalut 0," +
                "exerlist text not null," +
                "time double defalut 0," +
                "calorie default 0.0);";         // grade value e.g. 4, 3.5
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS cal;";
        db.execSQL(sql);
        this.onCreate(db);
    }
}
