package com.codepath.simpletodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class EditItemActivity extends ActionBarActivity {
    String data;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        data = getIntent().getStringExtra("data");
        pos = getIntent().getIntExtra("pos", 0);
        EditText editItem = (EditText) findViewById(R.id.editText);
        editItem.setText(data, TextView.BufferType.EDITABLE);
        if (data.length() > 0) {
            editItem.setSelection(data.length());
        }
        else {
            editItem.selectAll();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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

    public void onSaveItem(View v) {
        EditText editItem = (EditText) findViewById(R.id.editText);
        String itemText = editItem.getText().toString();
        Intent i = new Intent();
        // Pass relevant data back as a result
        i.putExtra("data", itemText);
        i.putExtra("pos", pos);
        // Activity finished ok, return the data
        setResult(RESULT_OK, i); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
