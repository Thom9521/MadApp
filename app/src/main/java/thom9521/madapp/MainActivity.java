package thom9521.madapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    public Button madGBtn;
    public Button retterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        madGBtn = findViewById(R.id.madBtn);
        retterBtn = findViewById(R.id.retterBtn);

        madGBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent madGActivity = new Intent(getApplicationContext(), MadGActivity.class);
                startActivity(madGActivity);
            }
        });

        retterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retterActivity = new Intent(getApplicationContext(), RetterActivity.class);
                startActivity(retterActivity);
            }
        });
    }
}
