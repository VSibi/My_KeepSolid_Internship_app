package com.sibich.my_keepsolid_internship_app.utils;


public class Consts {

    public final static String PREFS_NAME = "com.sibich.my_keepsolid_internship.SETTINGS";
    public final static String PREFS_USERS_REPO = "PREFS_USERS_REPO";
    public final static String PREFS_DONT_CLEAR_LIST = "PREFS_DONT_CLEAR_LIST";

    public final static String PREFS_REPO_LIST = "PREFS_REPO_LIST";


    // Configuration of a CursorLoader
    public final static int LOADER_ID = 0;

    // Configuration of a database
    public final static String DB_NAME = "internship_app_db";
    public final static String DB_TABLE_NAME = "news";
    public final static String DB_COL_ID_PRIMARY = "_id";
    public final static String DB_COL_ID = "newsId";
    public final static String DB_COL_AUTHOR = "newsAuthor";
    public final static String DB_COL_TITLE = "newsTitle";
    public final static String DB_COL_DESCRIPTION = "newsDescription";
    public final static String DB_COL_URL = "newsUrl";
    public final static String DB_COL_URL_IMAGE = "newsImageUrl";
    public final static String DB_COL_DATE = "newsDate";
    public final static int DB_VERSION = 1;

    // SQL Query
    public static final String DB_CREATE =
            "create table " + DB_TABLE_NAME + "(" +
                    DB_COL_ID_PRIMARY + " integer primary key autoincrement, " +
                    DB_COL_ID + " integer, " +
                    DB_COL_AUTHOR + " text," +
                    DB_COL_TITLE + " text," +
                    DB_COL_DESCRIPTION + " text, " +
                    DB_COL_URL + " text," +
                    DB_COL_URL_IMAGE + " text," +
                    DB_COL_DATE + " text," +
                    " UNIQUE ( " + DB_COL_ID + " ) ON CONFLICT IGNORE" +
                    ");";

    public static final String DB_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DB_TABLE_NAME;


}
