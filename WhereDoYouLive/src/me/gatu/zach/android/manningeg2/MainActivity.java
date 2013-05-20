package me.gatu.zach.android.manningeg2;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        final EditText	addressfield = (EditText) findViewById(R.id.address);
        final Button button = (Button) findViewById(R.id.launchmap);
        button.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View view) {
				try {
					String address = addressfield.getText().toString();
					address = address.replace(' ', '+');
					Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
					startActivity(geoIntent);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
