package se.oscarb.differentlisteners;

import android.view.View;
import android.widget.Toast;

/*
    Lyssnare och händelser
    En lyssnarklass i en egen fil
 */
public class MyButtonListener implements View.OnClickListener {


    // Metoden onClick innehåller koden som ska köras vid knapptryck
    @Override
    public void onClick(View v) {
        // Kod som ska köras när man klickat på en knapp!

        // + Uppdelning kod som har med knapptryck från annan kod
        // +- Vi har ingen "naturlig" context, så vi hämtar den från knappen:
        // v.getContext()

        Toast.makeText(v.getContext(), "Dynamisk knapp med metoden onClick i egen klass!", Toast.LENGTH_SHORT).show();
    }
}
