package com.sibich.my_keepsolid_internship_app.utils;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sibich.my_keepsolid_internship_app.models.Article;
import com.sibich.my_keepsolid_internship_app.models.TimesIndiaItem;

import java.util.List;

public class Database {

    private final Context ctx;

    private DBHelper dbHelper;

    private SQLiteDatabase mDB;

    public Database(Context ctx) {
        this.ctx = ctx;
    }

    public void open() {
        dbHelper = new DBHelper(ctx, Consts.DB_NAME, null, Consts.DB_VERSION);
        mDB = dbHelper.getWritableDatabase();
    }

    public void close() {
        if (dbHelper != null) {
            dbHelper.close();
        }
    }

    public Cursor getAllData() {
        return mDB.query(Consts.DB_TABLE_NAME, null, null, null, null, null, Consts.DB_COL_ID_PRIMARY + " DESC");
    }

    public void clearData() {
        mDB.delete(Consts.DB_TABLE_NAME, null, null);
    }

    private void addRec(Article article) {
        ContentValues cv = new ContentValues();

       /* Article article = item.getArticles().get(0);*/

        cv.put(Consts.DB_COL_TITLE, article.getTitle());
        cv.put(Consts.DB_COL_AUTHOR, article.getAuthor());
        cv.put(Consts.DB_COL_DESCRIPTION, article.getDescription());
        cv.put(Consts.DB_COL_URL_IMAGE, article.getUrlToImage());
        cv.put(Consts.DB_COL_URL, article.getUrl());
      //  cv.put(Consts.DB_COL_ID, item.getNewsId());
      //  cv.put(Consts.DB_COL_AUTHOR, item.getAuthor());
     //   cv.put(Consts.DB_COL_TITLE, item.getTitle());
     //   cv.put(Consts.DB_COL_DESCRIPTION, item.getDescription());
     //   cv.put(Consts.DB_COL_URL, item.getWebUrl().toString());

    //    cv.put(Consts.DB_COL_URL_IMAGE, item.getWebImageUrl().toString());
     //   cv.put(Consts.DB_COL_URL_IMAGE, item.getWebUrl().toString());

        mDB.insert(Consts.DB_TABLE_NAME, null, cv);
    }

    public void addApiData(TimesIndiaItem item) {
        List<Article> articles = item.getArticles();
        if(articles.size() != 0) {
            for(int i = articles.size()-1; i>=0; i--) {
                addRec(articles.get(i));
            }
        }
    }

    /**
     * Subclass of {@link SQLiteOpenHelper} which provides custom database helper.
     */
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Consts.DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(Consts.DB_DELETE_ENTRIES);
            onCreate(db);
        }
    }

}
