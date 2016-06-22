package android.iacsoftware.com.explicitintentsdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListDisplay extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_display);

        final ListView list = (ListView) findViewById(R.id.listView2);
String []values = {
        "HTC",
        "LG",
        "Apple",
        "Google",
        "Micromax",
        "Xiaomee",
        "Samsung",
        "Sony",
        "Motorola",
        "Lenovo",
        "Upcoming",
        "Others",
        "Extras",
        "Nokia",
};  // Values Array for The ListView

        ArrayAdapter<String> adapter = new ArrayAdapter(
           ListDisplay.this,
                android.R.layout.simple_list_item_1,
                values
        ); // Creating the adapter
  list.setAdapter(adapter);      // Mapping the adapter to the ListView

list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       //Integer i = parent.getSelectedItemPosition();
        //int val = list.getSelectedItemPosition();
           String valueSelected = list.getItemAtPosition(position).toString();

        Toast.makeText(ListDisplay.this, valueSelected + "Clicked...", Toast.LENGTH_SHORT).show();

//startActivity(new Intent(ListDisplay.this, ImageDraw.class));
    }
});



    }
}
