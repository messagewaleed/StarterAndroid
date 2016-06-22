package android.iacsoftware.com.explicitintentsdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BackgroundDemo extends ActionBarActivity {

    TextView output;
    ProgressDialog bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_demo);
       output= (TextView) findViewById(R.id.textViewTask);

        //bar = (ProgressBar) findViewById(R.id.progressBar);
        //bar.setVisibility(View.INVISIBLE);

        Button start = (Button) findViewById(R.id.buttonStart);




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTask().execute("Task 1", "Task 2", "Task 3");//Calls doInBackground()
            }
        });


    }

class MyTask extends AsyncTask<String, String, String>
{
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       bar = new ProgressDialog(BackgroundDemo.this);
        bar.setMessage("Loading Data...");
        bar.setCancelable(false);
        bar.show();
        // bar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... params) {

        for(int val = 0; val < params.length; val++)
        {
publishProgress(params[val]);  //Calls onProgressUpdate
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Completed";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        output.append(values[0] + "\n");
    }

    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        output.append("All Tasks completed!!!");
        bar.cancel();
        //bar.setVisibility(View.INVISIBLE);
    }
}


}
