
package com.examp.recorder;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView record;
	ListView lv;
   
 
	private ArrayList<String> myList;

	private static String history;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		record = (ImageView) findViewById(R.id.iv1);
		lv=(ListView)findViewById(R.id.lv1);
		
	}
	public void open1(View v) {
		Intent intent = new Intent(this,RecorderActivity.class);
		startActivity(intent);
		
//		startActivityForResult(intent, RQS_RECORDING);
	}

//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		if (requestCode == RQS_RECORDING) {
//			if (resultCode == RESULT_OK) {
//				OutputFile = data.getData();
////				String sep = File.separator; // Use this instead of hardcoding the "/"
////				String newFolder = "FolderName";
////				String extStorageDirectory = Environment.getExternalStorageDirectory().getAbsolutePath().toString();
////				File myNewFolder = new File(extStorageDirectory,System.currentTimeMillis()+"AudioFile.3gpp" + sep + newFolder);
////				myNewFolder.mkdir();
////			
////			
//				Toast.makeText(this, "Saved: " +Environment.getExternalStorageDirectory().getAbsolutePath().toString()
//						+ "/Audio File/",
//						Toast.LENGTH_LONG).show();
////
////			
////
////				File list[] = myNewFolder.listFiles();
////				for (int i = 0; i < list.length; i++) {
////						myList.add(list[i].getName());
//				}
////
////				ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
////						android.R.layout.simple_list_item_1, myList);
////				lv = (ListView) findViewById(R.id.lv1);
////				lv.setAdapter(adapter);
////				lv.setOnItemClickListener(new OnItemClickListener() {
////
////					@Override
////					public void onItemClick(AdapterView<?> parent, final View view,
////							final int position, long id) {
////						PopupMenu popupMenu = new PopupMenu(getApplicationContext(),
////								view);
////						popupMenu.getMenuInflater().inflate(R.menu.popup,
////								popupMenu.getMenu());
////						popupMenu
////								.setOnMenuItemClickListener(new OnMenuItemClickListener() {
////
////									@Override
////									public boolean onMenuItemClick(MenuItem item) {
////
////										switch (item.getItemId()) {
////										case R.id.play:
////											Uri myUri =Uri.parse("file:/"+lv.getPositionForView(view));
////											Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
////											intent.setDataAndType(myUri, "audio/mp3"); 
////											startActivity(intent);
////
////											break;
////										case R.id.delete:
////											myList.remove(position);
////
////											break;
////										case R.id.share:
////
////											String sharedDesc = null;
////											sharedDesc = history.substring(0, 255);
////											Intent sharingIntent = new Intent(
////													Intent.ACTION_SEND);
////											sharingIntent.setType("text/plain");
////											sharingIntent.putExtra(
////													android.content.Intent.EXTRA_TEXT,
////													sharedDesc);
////											startActivity(Intent.createChooser(
////													sharingIntent,
////													"Complete Action Using"));
////
////											break;
////										}
////
////										return true;
////									}
////								});
////						popupMenu.show();
////
////					}
////				});
////			}
//			 else {
//				Toast.makeText(this, "User Cancelled!", Toast.LENGTH_LONG)
//						.show();
//			}
	//	}
	}






