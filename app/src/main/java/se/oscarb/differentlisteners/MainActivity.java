package se.oscarb.differentlisteners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Alternativ #1: Metoden är kopplad till en knapp i layout-filen activity_main.xml
    public void runMethod1(View view) {
        Toast.makeText(this, "Klickade på knappen!", Toast.LENGTH_SHORT).show();
    }



}
