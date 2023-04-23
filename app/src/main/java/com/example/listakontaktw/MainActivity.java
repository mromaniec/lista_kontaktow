package com.example.listakontaktw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        ZarzadcaBazy zb = new ZarzadcaBazy(this);
        zb.dodajKontakt(new Kontakt("Jan","Kowalski", "22 505 555 555"));
        zb.dodajKontakt(new Kontakt("Jan","Nowak", "42 545 666 554"));
        zb.dodajKontakt(new Kontakt("Tomasz","Iksinski", "112"));

        for(Kontakt k:zb.dajWszystkie()) {
            Log.d("DB", k.getNr()+" "+k.getImie()+" "+k.getNazwisko()+
                    " "+k.getTelefon());
        }


        Kontakt toChange = new Kontakt("Tomasz", "Igrekowski", "112");
        toChange.setNr(6L);
        zb.aktualizujKontakt(toChange);
        for(Kontakt k:zb.dajWszystkie()) {
            Log.d("DB", k.toString());
        }

    }
}