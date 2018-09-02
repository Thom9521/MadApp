package thom9521.madapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RetterActivity extends AppCompatActivity {

    RandomNumber randomNumber = new RandomNumber();
    FirebaseDatabase database;
    DatabaseReference mad;
    Button tilføjBtn;
    TextView madEditText;
    ListView listView;
    private ArrayList<String> listNavn = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retter);

        database = FirebaseDatabase.getInstance();
        mad = FirebaseDatabase.getInstance().getReference("thomasogdittemad");

        listView = findViewById(R.id.listview);
        tilføjBtn = findViewById(R.id.tilføjBtn);
        madEditText = findViewById(R.id.madEditText);

        //Definerer ArrayAdapter og initialiserer den
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1, listNavn);

        listView.setAdapter(arrayAdapter);

        final String hentmad = madEditText.getText() + "";
        tilføjBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            addMad();
            arrayAdapter.notifyDataSetChanged();
            }

        });


        final Query queryRef = mad.orderByChild("mad");

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String navn = (String) dataSnapshot.child("mad").getValue();
                listNavn.add(navn);
                arrayAdapter.notifyDataSetChanged();
            }

            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Collections.reverse(listNavn);
            }
            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                //Umiddelbart intet indhold
            }
            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                //Umiddelbart intet indhold
            }

            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Umiddelbart intet indhold
            }

        });

        queryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Collections.reverse(listNavn);
            }

            // Hvis denne metode fjernes får vi fejl
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Umiddelbart intet indhold
            }
        });

    }
    private void addMad() {

        // Tager imod det indtastede navn.
        String nymad = madEditText.getText().toString().trim();

        // Tjekker om navn er blevet indtastet, og udfører en handling ud fra det.
        if(!TextUtils.isEmpty(madEditText.getText().toString())){


            // Opretter HashMap til at samle data.
            Map<String, Object> madMap = new HashMap<>();

            // Tilføjer elementer til HashMap
            madMap.put("mad", nymad);


            // Indsender dataerne med deres rigtige værdier til firebase databasen.
            mad.child("Madnummer" + randomNumber.number).setValue(madMap);
            randomNumber.number = randomNumber.number +1;



        }
        else {
            // Viser en fejlmeddelse om at der mangler at blive indtastet navn.
            Toast.makeText(this,"Indtast ny mad!", Toast.LENGTH_LONG).show();
        }
    }

}
