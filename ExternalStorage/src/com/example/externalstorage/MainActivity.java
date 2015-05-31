package com.example.externalstorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
	EditText editText;
	String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void saveInternalCache(View v) {
		// TODO Auto-generated method stub
    	File folder = getCacheDir();
    	File mfile = new File(folder, "debashis_text1.txt");
    	data = editText.getText().toString();
    	writeFile(mfile, data);
	}
    public void saveExternalCache(View v) {
		// TODO Auto-generated method stub
    	File folder = getExternalCacheDir();
    	File mfile = new File(folder, "debashis_text2.txt");
    	data = editText.getText().toString();
    	writeFile(mfile, data);
	}
    public void saveExternalPrivate(View v) {
		// TODO Auto-generated method stub
    	File folder = getExternalFilesDir("Debashis");
    	File mfile = new File(folder, "debashis_text3.txt");
    	data = editText.getText().toString();
    	writeFile(mfile, data);
	}
    public void saveExternalPublic(View v) {
		// TODO Auto-generated method stub
    	File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    	File mfile = new File(folder, "debashis_text4.txt");
    	data = editText.getText().toString();
    	writeFile(mfile, data);
	}
    public void startLoadActivity(View v) {
		// TODO Auto-generated method stub
    	Intent intent = new Intent(this, LoadActivity.class);
    	startActivity(intent);
	}
    private void writeFile(File mfile, String name){
    	FileOutputStream fo = null;
    	try {
			fo = new FileOutputStream(mfile);
			try {
				fo.write(name.getBytes());
				Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
    		if(fo!=null) {
    			try {
					fo.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	Toast.makeText(this, "File saved successfully to.."+mfile.getAbsolutePath(), Toast.LENGTH_LONG).show();
    }
}
