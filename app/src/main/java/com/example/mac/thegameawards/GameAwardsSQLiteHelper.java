package com.example.mac.thegameawards;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mac on 19/11/2016.
 */

public class GameAwardsSQLiteHelper extends SQLiteOpenHelper {
    //Sentencia SQL para crear la tabla de Personaje
    /*String sqlCreate2 = "CREATE TABLE Personajes (_id INTEGER PRIMARY KEY, nombre TEXT, " +
            "fechaB TEXT, fechaD TEXT, descripcion TEXT, monumento TEXT, imagen TEXT, civilizacion TEXT)";*/

    String sqlCreate = "CREATE TABLE Game_Awards (_id INTEGER PRIMARY KEY, year INTEGER, " +
            "goty TEXT, indie TEXT, shooter TEXT, action_adventure TEXT, rpg TEXT, fighting TEXT, " +
            " sports_racing TEXT, strategy TEXT, performance TEXT, narrative TEXT, music_sound TEXT)";

    public GameAwardsSQLiteHelper(Context contexto, String nombre,
                                  SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creacion de la tabla
        db.execSQL(sqlCreate);

        int id = 1;
        int year = 2014;
        String goty = "Dragon Age: Inquisition";
        String indie = "Shovel Knight";
        String shooter = "Far Cry 4";
        String action_adventure = "Middle-Earth: Shadow of Mordor";
        String rpg = "Dragon Age: Inquisition";
        String fighting = "Super Smash Bros. Wii U";
        String sports_racing = "Mario Kart 8";
        String performance = "Trey Parker, South Park: The Stick of Truth";
        String narrative = "Valiant Hearts: The Great War";
        String music_sound = "Destiny";

        //Insertamos los datos en la tabla Game_Awards
        db.execSQL("INSERT INTO Game_Awards (_id, year, goty, indie, shooter, action_adventure, rpg, fighting, " +
                "sports_racing, performance, narrative, music_sound) " +
                "VALUES (" + id + ", " + year + ", '" + goty + "', '" + indie + "', '" + shooter + "', '"
                + action_adventure + "', '" + rpg + "', '" + fighting + "', '" + sports_racing + "', '"
                + performance + "', '" + narrative + "', '" + music_sound + " ')");


        id = 2;
        year = 2015;
        goty = "The Witcher 3: Wild Hunt";
        indie = "Rocket League";
        shooter = "Splatoon";
        action_adventure = "Metal Gear Solid V: The Phantom Pain";
        rpg = "The Witcher 3: Wild Hunt";
        fighting = "Mortal Kombat X";
        sports_racing = "Rocket League";
        performance = "Viva Seifert, Her Story";
        narrative = "Her Story";
        music_sound = "Metal Gear Solid V: The Phantom Pain";

        //Insertamos los datos en la tabla Game_Awards
        db.execSQL("INSERT INTO Game_Awards (_id, year, goty, indie, shooter, action_adventure, rpg, fighting, " +
                "sports_racing, performance, narrative, music_sound) " +
                "VALUES (" + id + ", " + year + ", '" + goty + "', '" + indie + "', '" + shooter + "', '"
                + action_adventure + "', '" + rpg + "', '" + fighting + "', '" + sports_racing + "', '"
                + performance + "', '" + narrative + "', '" + music_sound + " ')");


        id = 3;
        year = 2016;
        goty = "Overwatch";
        indie = "Inside";
        shooter = "DOOM";
        action_adventure = "Dishonored 2";
        rpg = "The Witcher 3: Wild Hunt - Blood and Wine";
        fighting = "Street Fighter V";
        sports_racing = "Forza Horizon 3";
        performance = "Nolan North, Uncharted 4: A Thief´s End";
        narrative = "Uncharted 4: A Thief´s End";
        music_sound = "DOOM";

        //Insertamos los datos en la tabla Game_Awards
        db.execSQL("INSERT INTO Game_Awards (_id, year, goty, indie, shooter, action_adventure, rpg, fighting, " +
                "sports_racing, performance, narrative, music_sound) " +
                "VALUES (" + id + ", " + year + ", '" + goty + "', '" + indie + "', '" + shooter + "', '"
                + action_adventure + "', '" + rpg + "', '" + fighting + "', '" + sports_racing + "', '"
                + performance + "', '" + narrative + "', '" + music_sound + " ')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la version anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Game_Awards");

        //Se crea la nueva version de la tabla
        db.execSQL(sqlCreate);
    }
}
