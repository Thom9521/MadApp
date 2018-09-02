package thom9521.madapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class MadGActivity extends AppCompatActivity {

    TextView madTextView;
    Button findmadBtn;
    DatabaseReference mDatabase;
    RandomNumber x = new RandomNumber();

/*
    public void databasemetode(){
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String navn = (String) dataSnapshot.child("Madnummer" + randomNumber.randomx()).child("mad").getValue();
                madTextView.setText(navn);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_g);

        madTextView = findViewById(R.id.madTextView);
        findmadBtn = findViewById(R.id.findmadBtn);
        mDatabase = FirebaseDatabase.getInstance().getReference("thomasogdittemad");

        findmadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Random random = new Random();
                int x = random.nextInt(20)+1;

                if (x ==1){
                    madTextView.setText("Suppe");
            }
            else if (x==2){
                madTextView.setText("Kylling i karry");
            }
            else if (x==3){
                madTextView.setText("Lasagne");
            }
            else if (x==4){
                madTextView.setText("Mørbrad grydde");
            }
            else if (x==5){
                madTextView.setText("Boller i karry");
            }
            else if (x==6){
                madTextView.setText("Hjemmelavet pizza");
            }
            else if (x==7){
                madTextView.setText("Hjemmelavet burger");
            }
            else if (x==8){
                madTextView.setText("Fredagsmad / grillmad");
            }
            else if (x==9){
                madTextView.setText("Kartoffelmos m. millionbøf");
            }
            else if (x==10){
                madTextView.setText("Brændende kærlighed");
            }
            else if (x==11){
                madTextView.setText("Tarteletter");
            }
            else if (x==12){
                madTextView.setText("Spaghetti m. kødsovs");
            }
            else if (x==13){
                madTextView.setText("Mexikansk");
            }
            else if (x==14){
                madTextView.setText("Pandekager");
            }
            else if (x==15){
                madTextView.setText("Hakkebøffer");
            }
            else if (x==16){
                madTextView.setText("Frikadeller");
            }
            else if (x==17){
                madTextView.setText("Æggekage");
            }
            else if (x==18){
                madTextView.setText("Carbonara/ostesovs");
            }
            else if (x==19){
                madTextView.setText("Fiskefrikadeller");
            }
            else if (x==20){
                madTextView.setText("Paprikagrydde");
            }


            }
        });


    }
}
