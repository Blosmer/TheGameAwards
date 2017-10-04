package com.example.mac.thegameawards;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Mac on 20/11/2016.
 */

public class Winners extends AppCompatActivity {
/*
    private Button btnMonumento;
    private String monumento, descripcionID;
    private TextView txtNombre, txtFechBD, txtDescripcion, txtCivi, txtMonumento, txtImagen;
*/
    private SQLiteDatabase db;
    private TextView txtGoty, txtIndie, txtShooter, txtActionAdventure, txtRPG, txtSportsRacing,
            txtMusicSound, txtPerformance, txtNarrative, txtFighting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winners);
/*
        txtNombre = (TextView) findViewById(R.id.idNombre);
        txtFechBD = (TextView) findViewById(R.id.idFechBD);
        txtDescripcion = (TextView) findViewById(R.id.idDescripcion);
        txtCivi = (TextView) findViewById(R.id.idCivi);
        //txtImagen = (TextView) findViewById(R.id.idImagen);
        btnMonumento = (Button) findViewById(R.id.idMonumento);
*/

        txtGoty = (TextView) findViewById(R.id.idGoty);
        txtIndie = (TextView) findViewById(R.id.idIndie);
        txtShooter = (TextView) findViewById(R.id.idShooter);
        txtActionAdventure = (TextView) findViewById(R.id.idActionAdventure);
        txtFighting = (TextView) findViewById(R.id.idFighting);
        txtRPG = (TextView) findViewById(R.id.idRPG);
        txtSportsRacing = (TextView) findViewById(R.id.idSportRacing);
        txtMusicSound = (TextView) findViewById(R.id.idMusic);
        txtNarrative = (TextView) findViewById(R.id.idNarrative);
        txtPerformance = (TextView) findViewById(R.id.idPerformance);


        Intent i = getIntent();
        int opcionSelec = Integer.parseInt(i.getExtras().getString("opcionSelec"));

        //Abrimos la base de datos 'DBGameAwards' en modo escritura
        GameAwardsSQLiteHelper usdbh =
                new GameAwardsSQLiteHelper(this, "DBGameAwards", null, 1);

        db = usdbh.getReadableDatabase();

        /*
        Context context = getApplicationContext();
        CharSequence s = opcionSelec;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, s, duration);
        toast.show();
        */

        //metodo rawQuery()
        Cursor c = db.rawQuery("SELECT * FROM Game_Awards WHERE year = '"
                + opcionSelec + "'", null);

        if (c.moveToFirst()) {
            do {
                txtGoty.setText(c.getString(c.getColumnIndexOrThrow("goty")));
                txtIndie.setText(c.getString(c.getColumnIndexOrThrow("indie")));
                txtShooter.setText(c.getString(c.getColumnIndexOrThrow("shooter")));
                txtActionAdventure.setText(c.getString(c.getColumnIndexOrThrow("action_adventure")));
                txtFighting.setText(c.getString(c.getColumnIndexOrThrow("fighting")));
                txtRPG.setText(c.getString(c.getColumnIndexOrThrow("rpg")));
                txtSportsRacing.setText(c.getString(c.getColumnIndexOrThrow("sports_racing")));
                txtMusicSound.setText(c.getString(c.getColumnIndexOrThrow("music_sound")));
                txtNarrative.setText(c.getString(c.getColumnIndexOrThrow("narrative")));
                txtPerformance.setText(c.getString(c.getColumnIndexOrThrow("performance")));

            } while (c.moveToNext());
        }

/*
        if (c.moveToFirst()) {
            do {
                //Esto es para subrayar el texto, por alguna razon no dejan hacerlo en el layout
                txtNombre.setPaintFlags(txtNombre.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

                txtNombre.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
                txtFechBD.setText(c.getString(c.getColumnIndexOrThrow("fechaB")) + " - "
                        + c.getString(c.getColumnIndexOrThrow("fechaD")));


                // Aqui se guarda el id del string que quiero usar
                descripcionID = (c.getString(c.getColumnIndexOrThrow("descripcion")));

                // Y aqui querría usar la referencia al id que saco de la tabla en lugar de llamarlo
                // directamente
                txtDescripcion.setText(R.string.winstonD);

                // Para entendernos, algo asi, pero que funcione claro
                txtDescripcion.setText(R.string.winstonD);

                txtCivi.setText(c.getString(c.getColumnIndexOrThrow("civilizacion")));
                monumento = c.getString(c.getColumnIndexOrThrow("monumento"));
            } while (c.moveToNext());
        }


        btnMonumento.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:1,1?z=1&q=" + monumento));
                startActivity(intent);
            }
        });
        */
    }
}
