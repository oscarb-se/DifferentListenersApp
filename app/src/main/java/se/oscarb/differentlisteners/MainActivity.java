package se.oscarb.differentlisteners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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
        // Använder klassen MyButtonListener i filen MyButtonListener.java
        // MyButtonListener myButtonListener = new MyButtonListener();
        // myButton.setOnClickListener(myButtonListener);

        // Alternativ 2:
        // Använd en existerande klass (den här klassen!)
        // Lägg till så att den här klassen implementerar View.OnClickListener()
        // myButton.setOnClickListener(this);

        // Alternativ 3:
        // Använd en inre anonym klass
        // Lägg till kod direkt där argumentet ska vara
        myButton.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                        public void onClick(View v) {
                                           // Kod som ska köras när knapp trycks på
                                           Toast.makeText(MainActivity.this,
                                                          "Dynamisk knapp med onClick i inre anonym klass!",
                                                           Toast.LENGTH_SHORT).show();
                                       }
                                    }
        );

        /* Om setOnClickListener används flera gånger för samma knapp så
           byts koden (metoden) ut som körs när knappen klickas på.

           Flera olika knappar kan ha samma metod om alternativ 1 eller 2 används
           För att ta reda på vilken knapp som klickades på, se exemplena högst upp!
         */




    }

    // Alternativ 2 (var vi klan placera kod för knapptryck)
    // Den här metoden är med eftersom den här klassen, MainActivity, implementerar View.OnClickListener
    @Override
    public void onClick(View v) {
        // Kod som ska köras när en knapp trycks på
        Toast.makeText(this, "Dynamisk knapp med metoden onClick i samma klass!", Toast.LENGTH_SHORT).show();
    }
}
