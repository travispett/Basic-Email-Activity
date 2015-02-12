package com.pett.travis.tapthree;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ConfirmEmailActivity extends ActionBarActivity {

    static final int SEND_EMAIL_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_email);

        Bundle extras = getIntent().getExtras();
        String to = extras.getString("to_field");
        String subject = extras.getString("subject_field");
        String message = extras.getString("message_field");

        TextView confirm = (TextView)findViewById(R.id.confirmEmailActivityTextView);
        confirm.setText("To: " + to + "\nSubject: " + subject + "\nMessage: " + message);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_confirm_email, menu);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SEND_EMAIL_REQUEST) {
            NavUtils.navigateUpFromSameTask(this);
        }
    }

    public void startEmailClient(View view) {
        Bundle extras = getIntent().getExtras();
        String to = extras.getString("to_field");
        String subject = extras.getString("subject_field");
        String message = extras.getString("message_field");

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", to, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(message));

        try {
            startActivityForResult(emailIntent, SEND_EMAIL_REQUEST);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.email_activity_error, Toast.LENGTH_SHORT).show();
        }
    }

    public void exitConfirmEmailActivity(View view) {
        NavUtils.navigateUpFromSameTask(this);
    }
}
