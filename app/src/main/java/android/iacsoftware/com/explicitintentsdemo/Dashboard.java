package android.iacsoftware.com.explicitintentsdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        Intent it = getIntent();
//        Bundle b = it.getExtras();
//        String val = b.getString("valueUser");
        Log.e("status", "Inside Dashboard");
String fromPrevious = getIntent().getExtras().getString("valueUser");

        TextView display = (TextView) findViewById(R.id.textViewWelcome);

        display.append(fromPrevious);

         Toast toast = Toast.makeText(Dashboard.this, "Welcome" + fromPrevious, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        Button next = (Button) findViewById(R.id.button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(Dashboard.this, ListDisplay.class));
            }
        });


    }
}
