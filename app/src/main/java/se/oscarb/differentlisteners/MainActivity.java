package se.oscarb.differentlisteners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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

    // Skilja på vilken knapp man klickade på med hjälp av tags...
    public void runMethod2(View view) {
        String tag = view.getTag().toString();
        String message = "";
        if(tag.equals("dog")) {
            message = "Du klickade på en HUND!";
        } else if(tag.equals("cat")) {
            message = "Du klickade på en KATT!";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Skilja på vilken knapp man klickade på med hjälp av ID...
    public void runMethod3 (View view) {
        String message;

        // if (view.getId() == R.id.special_button_1) ...

        switch(view.getId()) {
            case R.id.special_button_1: message = "Speciell knapp 1"; break;
            case R.id.special_button_2: message = "Speciell knapp 2"; break;
            default: message = "Ingen speciell knapp!";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /*
        Demonstration av lyssnare och händelser
     */

    // Metod som skapar en knapp dynamiskt.
    // Den skapade knappen kopplas sen ihop med en lyssnare
    public void createButton1(View view)  {
        // Vi behöver komma åt var vi vill placera knappen
        LinearLayout buttonContainer1 = (LinearLayout) findViewById(R.id.button_container1);

        // Skapa knappen
        Button myButton = new Button(this);
        myButton.setText("Created Button 1");

        // Placera i vår LinearLayout buttonContainer1
        buttonContainer1.addView(myButton);

        // Koppla ihop nyligen skapad knapp med lyssnare

        // Alternativ 1:
        MyButtonListener myButtonListener = new MyButtonListener();
        myButton.setOnClickListener(myButtonListener);

    }





}
