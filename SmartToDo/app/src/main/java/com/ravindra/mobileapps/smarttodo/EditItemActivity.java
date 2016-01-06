package com.ravindra.mobileapps.smarttodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

/*
This class is to support Edit todo activity.
 */
public class EditItemActivity extends AppCompatActivity {
    EditText etToDoItem;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
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

        String todoitem = getIntent().getStringExtra("todoitem");
        position = getIntent().getIntExtra("position", 0);

        etToDoItem = (EditText)findViewById(R.id.etToDoItem);
        etToDoItem.setText(todoitem);
    }

    /*
    This method supports update todo action
     */
    public void onSubmit(View v) {
        etToDoItem = (EditText) findViewById(R.id.etToDoItem);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("todoitem", etToDoItem.getText().toString());
        data.putExtra("position", position); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}