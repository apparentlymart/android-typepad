package com.typepad.androidpost;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

public class PostToTypePad extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent intent = this.getIntent();
        String action = intent.getAction();

        if (Intent.ACTION_SEND.equals(action)) {
            String type = intent.getType();
            Uri stream = (Uri)intent.getParcelableExtra(Intent.EXTRA_STREAM);

            if (stream != null && type != null) {
                TextView tv = (TextView)this.findViewById(R.id.debug_textview);
                tv.setText("User wants to post "+type+" "+stream);
            }
        }

    }
}
