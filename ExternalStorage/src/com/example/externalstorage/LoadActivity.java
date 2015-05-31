package com.example.externalstorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class LoadActivity extends ActionBarActivity {
	EditText edText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_load);
		edText = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.load, menu);
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
	public void loadInternalCache(View v) {
		// TODO Auto-generated method stub
    	File folder = getCacheDir();
    	File mfile = new File(folder, "debashis_text1.txt");
    	String text=readFile(mfile);
    	edText.setText(text);
	}
    public void loadExternalCache(View v) {
		// TODO Auto-generated method stub
    	File folder = getExternalCacheDir();
    	File mfile = new File(folder, "debashis_text2.txt");
    	String text=readFile(mfile);
    	edText.setText(text);
	}
    public void loadExternalPrivate(View v) {
		// TODO Auto-generated method stub
    	File folder = getExternalFilesDir("Debashis");
    	File mfile = new File(folder, "debashis_text3.txt");
    	String text=readFile(mfile);
    	edText.setText(text);
	}
    public void loadExternalPublic(View v) {
		// TODO Auto-generated method stub
    	File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    	File mfile = new File(folder, "debashis_text4.txt");
    	String text=readFile(mfile);
    	edText.setText(text);
	}
    public void startSaveActivity(View v) {
		// TODO Auto-generated method stub
    	Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
	}
    private String readFile(File mfile){
    	FileInputStream fi = null;
    	int read = -1;
    	StringBuffer bfr = new StringBuffer();
    	try {
			fi = new FileInputStream(mfile);
			try {
				while((read=fi.read())!=-1)
				{
					bfr.append((char)read);
				}
				Toast.makeText(this, bfr.toString(), Toast.LENGTH_SHORT).show();
				return bfr.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally {
    		if(fi!=null) {
    			try {
					fi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    	return null;
    }
}
