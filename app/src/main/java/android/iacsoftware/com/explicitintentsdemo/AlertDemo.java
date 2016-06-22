package android.iacsoftware.com.explicitintentsdemo;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

public class AlertDemo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_demo);

        Button exit = (Button) findViewById(R.id.buttonExit);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
AlertDialog.Builder builder = new AlertDialog.Builder(AlertDemo.this);
builder.setMessage("Are you sure?");
builder.setCancelable(false);
builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        AlertDemo.this.finish();
    }
}) ;
 builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
     @Override
     public void onClick(DialogInterface dialog, int which) {
         dialog.cancel();
     }
 });

 AlertDialog dailog = builder.create();
              dailog.show();
            }
        });


    }
}
