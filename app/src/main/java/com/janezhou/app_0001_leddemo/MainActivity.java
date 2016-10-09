package com.janezhou.app_0001_leddemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.janezhou.hardlibrary.*;

import java.util.concurrent.Callable;


public class MainActivity extends AppCompatActivity {

     private Button  button = null;
     private boolean ledon = false;
     private CheckBox checkbox1 = null;
    private CheckBox checkbox2 = null;
    private CheckBox checkbox3 = null;
    private CheckBox checkbox4 = null;

    class MyButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            HardControl hardControl = new HardControl();

            ledon = !ledon;
            if (ledon) {
                button.setText("All OFF");
                checkbox1.setChecked(true);
                checkbox2.setChecked(true);
                checkbox3.setChecked(true);
                checkbox4.setChecked(true);
            }
            else {
                button.setText("All ON");
                checkbox1.setChecked(false);
                checkbox2.setChecked(false);
                checkbox3.setChecked(false);
                checkbox4.setChecked(false);
            }
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.CHECKBOX1:
                if (checked)
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED1 ON", Toast.LENGTH_SHORT).show();
                else
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED1 OFF", Toast.LENGTH_SHORT).show();
                break;
            case R.id.CHECKBOX2:
                if (checked)
                    Toast.makeText(getApplicationContext(), "LED2 ON", Toast.LENGTH_SHORT).show();
                else
                    // I'm lactose intolerant
                    Toast.makeText(getApplicationContext(), "LED2 OFF", Toast.LENGTH_SHORT).show();
                break;
            case R.id.CHECKBOX3:
                if (checked)
                    // Put some meat on the sandwich
                    Toast.makeText(getApplicationContext(), "LED3 ON", Toast.LENGTH_SHORT).show();
                else
                    // Remove the meat
                    Toast.makeText(getApplicationContext(), "LED3 OFF", Toast.LENGTH_SHORT).show();
                break;
            case R.id.CHECKBOX4:
                if (checked)
                    Toast.makeText(getApplicationContext(), "LED4 ON", Toast.LENGTH_SHORT).show();
                else
                    // I'm lactose intolerant
                    Toast.makeText(getApplicationContext(), "LED4 OFF", Toast.LENGTH_SHORT).show();
                break;
            // TODO: Veggie sandwich
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.BUTTON);
        checkbox1 = (CheckBox) findViewById(R.id.CHECKBOX1);
        checkbox2 = (CheckBox) findViewById(R.id.CHECKBOX2);
        checkbox3 = (CheckBox) findViewById(R.id.CHECKBOX3);
        checkbox4 = (CheckBox) findViewById(R.id.CHECKBOX4);

        button.setOnClickListener(new MyButtonListener());
        /*
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
             ledon = !ledon;
                if (ledon)
                   button.setText("All OFF");
                else
                    button.setText("All ON");
            }
        }); */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
