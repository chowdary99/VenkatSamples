package com.examp.recorder;
import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class RecorderActivity extends Activity {
	TextView tv1;
 private Button record, reset, stop;
	Chronometer c;
	long timeWhenStopped;
	private String file = null;
	MediaRecorder myRecorder;
	MediaPlayer mp;
	private ArrayList<String> myList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recorder);
		tv1 = (TextView) findViewById(R.id.tv1);
		record = (Button) findViewById(R.id.b1);
		reset = (Button) findViewById(R.id.b2);
		stop = (Button) findViewById(R.id.b3);
		c = (Chronometer) findViewById(R.id.c1);
		file = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/javacodegeeksRecording.3gpp";

		myRecorder = new MediaRecorder();
		myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
		myRecorder.setOutputFile(file);
		
	}

	public void open(View v){
		int id = v.getId();
		switch (id) {
		case R.id.b1:
			tv1.setText("Recording started");

			c.setBase(SystemClock.elapsedRealtime());
			c.start();

			try {
				myRecorder.prepare();
				myRecorder.start();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			record.setEnabled(false);
			stop.setEnabled(true);
			Toast.makeText(this, "Recording Started", 3000).show();

			break;
		case R.id.b2:
			tv1.setText("reset recording");
			c.setBase(SystemClock.elapsedRealtime());

			break;
		case R.id.b3:
			tv1.setText("Stop Recording");
			timeWhenStopped = c.getBase() - SystemClock.elapsedRealtime();
			c.stop();
			try {
				myRecorder.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			myRecorder.release();
			stop.setEnabled(false);
			record.setEnabled(true);
			AlertDialog.Builder b=new AlertDialog.Builder(this);
//			b.setMessage("Do You Want To Save File ?").setCancelable(false);
			b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int id) {
              Intent i=new Intent(getApplicationContext(),MainActivity.class);
              startActivity(i);
			
				}
			});
			b.setNegativeButton("No", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog .cancel();
				}
			});
			AlertDialog a=b.create();
			a.setTitle("Do You Want To Save File ?");
			a.show();

			break;
		}
	}		
	}


