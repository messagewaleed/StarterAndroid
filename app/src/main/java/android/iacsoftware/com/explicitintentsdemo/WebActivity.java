package android.iacsoftware.com.explicitintentsdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class WebActivity extends ActionBarActivity {

    Button webOpen,emailSend;
    ListView spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webOpen = (Button) findViewById(R.id.webButton);

        emailSend = (Button) findViewById(R.id.emailButton);

        spin = (ListView) findViewById(R.id.listView);
        String[] values = {"9858392856","9797920229","9697011692"};
        ArrayAdapter adapter = new ArrayAdapter(WebActivity.this,android.R.layout.simple_list_item_1,values);
        spin.setAdapter(adapter);

        spin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) spin.getItemAtPosition(position);
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                Uri callUri = Uri.parse("tel: " + itemValue);
                callIntent.setData(callUri);
                startActivity(callIntent);
            }
        });


    }



    public void openInBrowser(View view)
    {
        Uri webUri = Uri.parse("http://iacsoftware.com");

        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);

        startActivity(webIntent);
    }

    public void sendEmail(View view)
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        String []emailTo = new String[3];
        emailTo[0] = "waleedahqureshi@gmail.com";
        emailTo[1] = "javeedxp@gmail.com";
        emailTo[2] = "yousufdar0012@gmail.com";

        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailTo);
        emailIntent.putExtra(Intent.EXTRA_CC,new String[]{"raspumerg@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email From IAC");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"This email comes from an android device...");

        emailIntent.setType("message/rfc822");

        startActivity(Intent.createChooser(emailIntent,"Please choose the email client:"));




    }

    public void callFriend(View view)
    {






    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
