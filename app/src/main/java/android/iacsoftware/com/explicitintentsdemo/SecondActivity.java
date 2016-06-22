package android.iacsoftware.com.explicitintentsdemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void moveNext(View view)
    {
        EditText inputUser = (EditText) findViewById(R.id.editText);
        String value = inputUser.getText().toString();
        Log.e("status","Inside moveNext");
        Intent intent = new Intent(SecondActivity.this, Dashboard.class);

        intent.putExtra("valueUser", value);
        Log.e("status","PutExtra created");
        startActivity(intent);
    }
}
