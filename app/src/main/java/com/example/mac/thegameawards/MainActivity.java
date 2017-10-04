package com.example.mac.thegameawards;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener{

    private ListView lstGameAwards;
    private TextView errores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        errores = (TextView) findViewById(R.id.LblEtiqueta);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.mario_jump_sound);

        generarLista();

        SharedPreferences pref =
                PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        if (pref.getBoolean("mute", false)) {
            mp.setVolume(0f, 0f);
        } else {
            mp.setVolume(0.8f, 0.8f);
        }

        if (pref.getBoolean("rotation", false)) {
            Settings.System.putInt(this.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0);
        } else {
            Settings.System.putInt(this.getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 1);
        }


        lstGameAwards.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                mp.start();
                String opcionSeleccionada = ((TextView) v.findViewById(R.id.lblYear))
                        .getText().toString();
                Intent i = new Intent(MainActivity.this, Winners.class);
                i.putExtra("opcionSelec", opcionSeleccionada);
                startActivity(i);
/*
                Context c = getApplicationContext();
                CharSequence s = opcionSeleccionada;
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(c, s, duration);
                toast.show();
*/
            }
        });


        lstGameAwards.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> a, View v, int position, long id) {

                lstGameAwards.setChoiceMode(lstGameAwards.CHOICE_MODE_MULTIPLE_MODAL);
                lstGameAwards.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        return false;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {

                    }

                    @Override
                    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                    }
                });
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(MainActivity.this, OpcionesActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void generarLista() {
        lstGameAwards = (ListView) findViewById(R.id.LstGameAwards);

        //Abrimos la base de datos 'DBPersonajes' en modo lectura
        GameAwardsSQLiteHelper usdbh = new GameAwardsSQLiteHelper(this, "DBGameAwards", null, 1);

        SQLiteDatabase db = usdbh.getReadableDatabase();

        //metodo rawQuery()
        Cursor c = db.rawQuery("SELECT * FROM Game_Awards", null);

        AdaptadorLista listAdap = new AdaptadorLista(this, c);
        lstGameAwards.setAdapter(listAdap);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
