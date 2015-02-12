package com.pett.travis.tapthree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class ComposeEmailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_email);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_compose_email, menu);
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

    public void startConfirmEmailActivity(View view) {
        EditText toEditText = (EditText)findViewById(R.id.composeEmailActivityToFieldLabel);
        EditText subjectEditText = (EditText)findViewById(R.id.composeEmailActivitySubjectFieldLabel);
        EditText messageEditText = (EditText)findViewById(R.id.composeEmailActivityMessageFieldLabel);

        Intent intent = new Intent(this, ConfirmEmailActivity.class);

        intent.putExtra("to_field", toEditText.getText().toString());
        intent.putExtra("subject_field", subjectEditText.getText().toString());
        intent.putExtra("message_field", messageEditText.getText().toString());

        startActivity(intent);
    }
}
