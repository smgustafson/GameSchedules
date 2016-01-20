package com.example.shayla.myapplication;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String SPORTS_TABLE_NAME = "sports";
    public static final String SPORTS_COLUMN_ID = "sportId";
    public static final String SPORTS_COLUMN_NAME = "sportName";
    public static final String TEAMS_TABLE_NAME = "teams";
    public static final String TEAMS_COLUMN_ID = "teamId";
    public static final String TEAMS_COLUMN_NAME = "teamName";
    public static final String TEAMS_COLUMN_SPORTID = "sportIdFK";
    public static final String GAMES_TABLE_NAME = "games";
    public static final String GAMES_COLUMN_ID = "gamesId";
    public static final String GAMES_COLUMN_TEAMID = "teamIdFK";
    public static final String GAMES_COLUMN_DATE = "gamesDate";
    public static final String GAMES_COLUMN_OPPONENT = "gamesOpponent";
    public static final String GAMES_COLUMN_LOCATION = "gamesLocation";

    private HashMap hp;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table " + SPORTS_TABLE_NAME +
                        "(" + SPORTS_COLUMN_ID +" integer primary key, " + SPORTS_COLUMN_NAME + " text)"
        );
        db.execSQL(
                "create table " + TEAMS_TABLE_NAME + " " +
                        "(" + TEAMS_COLUMN_ID + " integer primary key," + TEAMS_COLUMN_NAME + " text," + TEAMS_COLUMN_SPORTID + " integer, " +
                        " FOREIGN KEY(" + TEAMS_COLUMN_SPORTID + ") REFERENCES " + SPORTS_TABLE_NAME + "(" + SPORTS_COLUMN_ID + "))"
        );
        db.execSQL(
                "create table " + GAMES_TABLE_NAME + " " +
                        "(" + GAMES_COLUMN_ID + " integer primary key," + GAMES_COLUMN_TEAMID + " integer," + GAMES_COLUMN_DATE + " datetime, " + GAMES_COLUMN_OPPONENT + " text, " + GAMES_COLUMN_LOCATION + " text, " +
                        " FOREIGN KEY(" + GAMES_COLUMN_TEAMID + ") REFERENCES " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + "))"
        );
        //---------------------------------------------------------------------------------------------
        //-------------------------INSERT ALL OF THE SPORTS--------------------------------------------
        //---------------------------------------------------------------------------------------------
        db.execSQL(
                "insert into " + SPORTS_TABLE_NAME + "(" + SPORTS_COLUMN_ID + ", " + SPORTS_COLUMN_NAME + ")" + " values (1, 'Football')"
        );
        db.execSQL(
                "insert into " + SPORTS_TABLE_NAME + "(" + SPORTS_COLUMN_ID + ", " + SPORTS_COLUMN_NAME + ")" + " values (2, 'Mens Basketball')"
        );
        db.execSQL(
                "insert into " + SPORTS_TABLE_NAME + "(" + SPORTS_COLUMN_ID + ", " + SPORTS_COLUMN_NAME + ")" + " values (3, 'Womens Basketball')"
        );
        db.execSQL(
                "insert into " + SPORTS_TABLE_NAME + "(" + SPORTS_COLUMN_ID + ", " + SPORTS_COLUMN_NAME + ")" + " values (4, 'Hockey')"
        );
        //---------------------------------------------------------------------------------------------
        //--------------------------------INSERT ALL OF THE TEAMS--------------------------------------
        //---------------------------------------------------------------------------------------------
        db.execSQL(
                "insert into " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + ", " + TEAMS_COLUMN_SPORTID + ", " + TEAMS_COLUMN_NAME + ")" + " values (1, 1, 'Coyote')"
        );
        db.execSQL(
                "insert into " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + ", " + TEAMS_COLUMN_SPORTID + ", " + TEAMS_COLUMN_NAME + ")" + " values (2, 1, 'Bison')"
        );
        db.execSQL(
                "insert into " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + ", " + TEAMS_COLUMN_SPORTID + ", " + TEAMS_COLUMN_NAME + ")" + " values (3, 2, 'Coyote')"
        );
        db.execSQL(
                "insert into " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + ", " + TEAMS_COLUMN_SPORTID + ", " + TEAMS_COLUMN_NAME + ")" + " values (4, 2, 'Bison')"
        );
        db.execSQL(
                "insert into " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + ", " + TEAMS_COLUMN_SPORTID + ", " + TEAMS_COLUMN_NAME + ")" + " values (5, 3, 'Coyote')"
        );
        db.execSQL(
                "insert into " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + ", " + TEAMS_COLUMN_SPORTID + ", " + TEAMS_COLUMN_NAME + ")" + " values (6, 3, 'Bison')"
        );
        db.execSQL(
                "insert into " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + ", " + TEAMS_COLUMN_SPORTID + ", " + TEAMS_COLUMN_NAME + ")" + " values (7, 4, 'Stampede')"
        );
        db.execSQL(
                "insert into " + TEAMS_TABLE_NAME + "(" + TEAMS_COLUMN_ID + ", " + TEAMS_COLUMN_SPORTID + ", " + TEAMS_COLUMN_NAME + ")" + " values (8, 4, 'Force')"
        );
        //------------------------------------------------------------------------------------------------
        //--------------------------------INSERT ALL OF THE GAME SCHEDULES--------------------------------
        //------------------------------------------------------------------------------------------------
        //USD Football
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'New Mexico', '2016-09-03 14:00:00', 'Albuquerque, NM')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'Weber State', '2016-09-10 14:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'North Dakota', '2016-09-17 14:00:00', 'Grand Forks, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'Youngstown State', '2016-10-01 14:00:00', 'Youngstown, OH')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'Northern Iowa', '2016-10-08 14:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'Indiana State', '2016-10-15 14:00:00', 'Terre Haute, IN')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'Illinois State', '2016-10-22 14:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'Western Illinois', '2016-10-29 14:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'Southern Illinois', '2016-11-05 14:00:00', 'Carbondale, IL')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'South Dakota State', '2016-11-12 14:00:00', 'Brookings, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (1, 'North Dakota State', '2016-11-19 14:00:00', 'Vermillion, SD')"
        );
        //Bison Football
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'Eastern Washington', '2016-09-10 14:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'Iowa', '2016-09-17 14:00:00', 'Iowa City, IA')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'Illinois State', '2016-10-01 14:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'Missouri State', '2016-10-08 14:00:00', 'Springfield, MO')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'South Dakota State', '2016-10-15 14:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'Western Illinois', '2016-10-22 14:00:00', 'Macomb, IL')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'Northern, Iowa', '2016-10-29 14:00:00', 'Cedar Fall, IA')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'Youngstown State', '2016-11-05 14:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'Indiana State', '2016-11-12 14:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (2, 'South Dakota', '2016-11-19 14:00:00', 'Vermillion, SD')"
        );
        //USD Men's Basketball
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'Western Illinois', '2016-01-20 19:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'South Dakota State', '2016-01-23 16:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'Denver', '2016-01-28 20:00:00', 'Denver, CO')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'Omaha', '2016-01-30 19:00:00', 'Omaha, NE')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'Fort Wayne', '2016-02-04 19:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'Oral Roberts', '2016-02-06 14:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'North Dakota State', '2016-02-11 19:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'South Dakota State', '2016-02-13 16:30:00', 'Brookings, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'York College', '2016-02-17 19:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'Denver', '2016-02-21 14:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'IUPUI', '2016-02-25 18:00:00', 'Indianapolis, IN')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (3, 'Western Illinois', '2016-02-27 19:00:00', 'Macomb, IL')"
        );
        //Bison Men's Basketball
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'Fort Wayne', '2016-01-21 18:00:00', 'Fort Wayne, IN')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'Western Illinois', '2016-01-23 14:00:00', 'Macomb, IL')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'IUPUI', '2016-01-31 12:00:00', 'Indianapolis, IN')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'Oral Roberts', '2016-02-04 19:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'Fort Wayne', '2016-02-06 16:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'South Dakota', '2016-02-11 19:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'Omaha', '2016-02-13 13:00:00', 'Omaha, NE')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'Western Illinois', '2016-02-17 19:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'IUPUI', '2016-02-20 16:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'South Dakota State', '2016-02-25 19:00:00', 'Brookings, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (4, 'Denver', '2016-02-27 17:00:00', 'Denver, CO')"
        );
        //USD Women's Basketball
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'Fort Wayne', '2016-01-21 19:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'IUPUI', '2016-01-23 13:30:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'Western Illinois', '2016-01-27 19:00:00', 'Macomb, IL')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'North Dakota State', '2016-01-30 16:30:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'Denver', '2016-02-05 20:00:00', 'Denver, CO')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'Omaha', '2016-02-07 14:00:00', 'Omaha, NE')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'Oral Roberts', '2016-02-13 14:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'Western Illinois', '2016-02-18 19:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'South Dakota State', '2016-02-20 14:00:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'Fort Wayne', '2016-02-25 18:00:00', 'Fort Wayne, IN')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (5, 'IUPUI', '2016-02-27 18:00:00', 'Indianapolis, IN')"
        );
        //Bison Women's Basketball
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'Western Illinois', '2016-01-21 19:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'Fort Wayne', '2016-01-23 14:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'South Dakota', '2016-01-30 16:30:00', 'Vermillion, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'Oral Roberts', '2016-02-04 19:00:00', 'Tulsa, OK')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'South Dakota State', '2016-02-06 16:30:00', 'Brookings, SD')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'IUPUI', '2016-02-12 19:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'Omaha', '2016-02-14 14:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'Denver', '2016-02-20 13:00:00', 'Fargo, ND')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'Western Illinois', '2016-02-25 19:00:00', 'Macomb, IL')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (6, 'Fort Wayne', '2016-02-27 13:00:00', 'Fort Wayne, IN')"
        );
        //Stampede Hockey
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Green Bay Gamblers', '2016-01-21 19:05:00', 'Resch Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Green Bay Gamblers', '2016-01-23 19:05:00', 'Resch Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Waterloo', '2016-01-29 19:05:00', 'Young Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Waterloo', '2016-01-30 19:05:00', 'Young Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Waterloo', '2016-02-05 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Lincoln Stars', '2016-02-06 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Des Moines Buccaneers', '2016-02-12 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Tri-City Storm', '2016-02-13 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Tri-City Storm', '2016-02-19 19:30:00', 'Viaero Event Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Fargo Force', '2016-02-20 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Des Moines Buccaneers', '2016-02-26 19:05:00', 'Buccaneer Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Sioux City Musketeers', '2016-02-27 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Des Moines Buccaneers', '2016-03-02 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Dubuque Fighting Saints', '2016-03-04 19:35:00', 'Mystique Ice Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Dubuque Fighting Saints', '2016-03-05 19:05:00', 'Mystique Ice Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Madison Capitols', '2016-03-11 19:05:00', 'Alliant Energy Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Waterloo Black Hawks', '2016-03-12 19:05:00', 'Young Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Madison Capitols', '2016-03-15 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Team USA', '2016-03-18 18:00:00', 'USA Hockey Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Chicago Steel', '2016-03-19 19:05:00', 'Edge Ice Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Sioux City Musketeers', '2016-03-26 19:05:00', 'Tyson Events Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Des Moines Buccaneers', '2016-04-01 19:05:00', 'Buccaneer Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Lincoln Stars', '2016-04-02 19:05:00', 'The Ice Box')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Des Moines Buccaneers', '2016-04-05 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Fargo Force', '2016-04-08 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (7, 'Fargo Force', '2016-04-09 19:05:00', 'Scheels Arena')"
        );
        //Force Hockey
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Waterloo Black Hawks', '2016-01-22 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Waterloo Black Hawks', '2016-01-23 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Tri-City Storm', '2016-01-29 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Tri-City Storm', '2016-01-30 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Green Bay Gamblers', '2016-02-05 19:05:00', 'Green Bay')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Green Bay Gamblers', '2016-02-06 19:05:00', 'Green Bay')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Youngstown', '2016-02-12 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Youngstown', '2016-02-13 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Omaha', '2016-02-15 16:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Sioux City Musketeers', '2016-02-19 19:05:00', 'Tyson Events Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Sioux Falls Stampede', '2016-02-20 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Lincoln Stars', '2016-02-26 19:05:00', 'Lincoln')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Lincoln Stars', '2016-02-27 19:05:00', 'Lincoln')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Sioux City Musketeers', '2016-03-04 19:05:00', 'Tyson Events Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Lincoln Stars', '2016-03-05 19:05:00', 'Lincoln')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Des Moines Buccaneers', '2016-03-06 18:05:00', 'Des Moines')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Des Moines Buccaneers', '2016-03-11 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Des Moines Buccaneers', '2016-03-12 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Sioux City Musketeers', '2016-03-18 19:05:00', 'Tyson Events Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Omaha', '2016-03-19 19:05:00', 'Omaha')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Omaha', '2016-03-20 17:05:00', 'Omaha')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Omaha', '2016-03-25 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Omaha', '2016-03-26 19:05:00', 'Scheels Arena')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Tri-City Storm', '2016-04-01 19:30:00', 'Tri-City')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Tri-City Storm', '2016-04-02 19:05:00', 'Tri-City')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Sioux City Musketeers', '2016-04-03 15:05:00', 'Tyson Events Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Sioux Falls Stampede', '2016-04-09 19:05:00', 'Denny Sanford PREMIER Center')"
        );
        db.execSQL(
                "insert into " + GAMES_TABLE_NAME + "(" + GAMES_COLUMN_TEAMID + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_LOCATION + ")" +
                        " values (8, 'Sioux Falls Stampede', '2016-04-09 19:05:00', 'Scheels Arena')"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + GAMES_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TEAMS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SPORTS_TABLE_NAME);
        onCreate(db);
    }

    boolean insertSport  (String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(SPORTS_COLUMN_NAME, name);
        db.insert(SPORTS_TABLE_NAME, null, contentValues);
        return true;
    }

    boolean insertTeam  (String name, String sport)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TEAMS_COLUMN_NAME, name);
        contentValues.put(TEAMS_COLUMN_SPORTID, sport);
        db.insert(TEAMS_TABLE_NAME, null, contentValues);
        return true;
    }

    boolean insertGame  (String team, Date date, String opponent, String location)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(GAMES_COLUMN_TEAMID, team);
       // contentValues.put(GAMES_COLUMN_DATE, date);
        contentValues.put(GAMES_COLUMN_OPPONENT, opponent);
        contentValues.put(GAMES_COLUMN_LOCATION, location);
        db.insert(GAMES_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getDataForSports(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + SPORTS_TABLE_NAME + " where " + SPORTS_COLUMN_ID + "="+id+"", null );
        return res;
    }

    public int numberOfSports(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, SPORTS_TABLE_NAME);
        return numRows;
    }

    public Cursor getDataForTeams(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + TEAMS_TABLE_NAME + " where " + TEAMS_COLUMN_ID + "="+id+"", null );
        return res;
    }

    public Cursor getDataForAllTeams(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select " + TEAMS_COLUMN_NAME + " as teamName, " + SPORTS_COLUMN_NAME + " as sportName from " + TEAMS_TABLE_NAME + " join " + SPORTS_TABLE_NAME + " on " + TEAMS_TABLE_NAME + "." + TEAMS_COLUMN_SPORTID + "=" + SPORTS_TABLE_NAME + "." + SPORTS_COLUMN_ID, null );
        return res;
    }

    public int numberOfTeams(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TEAMS_TABLE_NAME);
        return numRows;
    }
    public Cursor getDataForGames(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + GAMES_TABLE_NAME + " where " + GAMES_COLUMN_ID + "="+id+"", null );
        return res;
    }

    public int numberOfGames(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, GAMES_TABLE_NAME);
        return numRows;
    }

    public Cursor getGamesForTeam(String teamName, String sport) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select " + GAMES_COLUMN_DATE + ", " + GAMES_COLUMN_OPPONENT + ", " + GAMES_COLUMN_LOCATION + " from " + GAMES_TABLE_NAME + " where " + GAMES_COLUMN_TEAMID + "=(select " + TEAMS_COLUMN_ID + " from " + TEAMS_TABLE_NAME + " where " + TEAMS_COLUMN_NAME + "='" + teamName + "' AND " + TEAMS_COLUMN_SPORTID + "= (select " + SPORTS_COLUMN_ID + " from " + SPORTS_TABLE_NAME + " where " + SPORTS_COLUMN_NAME + "='" + sport + "'))", null );
        return res;
    }

    //TODO: THIS METHOD DOES NOT WORK - ALWAYS RETURNS 1, also need to fix column names
    public int getNumGamesForTeam(String teamName, int sport) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select count(*) from " + GAMES_TABLE_NAME + " where id=(select id from " + TEAMS_TABLE_NAME + " where " + TEAMS_COLUMN_NAME + "='" + teamName + "' AND " + TEAMS_COLUMN_SPORTID + "=" + sport + ")", null );
        return res.getCount();
    }

    public ArrayList<String> getAllSports()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + SPORTS_TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(SPORTS_COLUMN_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

    public ArrayList<String> getAllTeams()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select " + TEAMS_COLUMN_NAME + " as teamName, " + SPORTS_COLUMN_NAME + " as sportName from " + TEAMS_TABLE_NAME + " join " + SPORTS_TABLE_NAME + " on " + TEAMS_TABLE_NAME + "." + TEAMS_COLUMN_SPORTID + "=" + SPORTS_TABLE_NAME + "." + SPORTS_COLUMN_ID, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            String team = res.getString(res.getColumnIndex("teamName"));
            String sport = res.getString(res.getColumnIndex("sportName"));
            array_list.add(team + " (" + sport + ")");
            res.moveToNext();
        }
        return array_list;
    }

    //HERE ARE SOME METHODS I PROBABLY WON'T EVER NEED
    //    public boolean updateContact (Integer id, String name, String phone, String email, String street,String place)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", name);
//        contentValues.put("phone", phone);
//        contentValues.put("email", email);
//        contentValues.put("street", street);
//        contentValues.put("place", place);
//        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
//        return true;
//    }
//
//    public Integer deleteContact (Integer id)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete("contacts",
//                "id = ? ",
//                new String[] { Integer.toString(id) });
//    }
}

