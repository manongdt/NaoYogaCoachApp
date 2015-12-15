package de.robotik.nao.communicator.core.sections;

import java.io.File;

import android.content.Context;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.TimePicker;
import de.robotik.nao.communicator.MainActivity;
import de.robotik.nao.communicator.R;
import de.robotik.nao.communicator.core.RemoteNAO;
import de.robotik.nao.communicator.network.ConnectionState;
import de.robotik.nao.communicator.network.NAOConnector;
import de.robotik.nao.communicator.network.data.NAOCommands;

public class SectionAlarm extends Section implements OnClickListener {
	private static final String NAO_SOUND_DIRECTORY = "sounds";
	// definition des TimePicker
	private TimePicker timePickerAlarm;
	private Button btnOk;
	private Button btnMusic;
	private TextView txtMusic;
	private static final int REQUEST_PICK_MUSIC = 1;

	public SectionAlarm(String aTitle) {
		super(aTitle);
	}

	public SectionAlarm() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// connect ui widgets
		rootView = inflater.inflate(R.layout.page_alarm, container, false);

		(btnMusic = (Button) findViewById(R.id.musicButton))
				.setOnClickListener(this);
		(btnOk = (Button) findViewById(R.id.okButton)).setOnClickListener(this);
		txtMusic = (TextView) findViewById(R.id.musicText);

		// timePicker
		timePickerAlarm = (TimePicker) findViewById(R.id.timePickerAlarm);

		return rootView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v == btnMusic) {
			Intent i = new Intent(
					Intent.ACTION_PICK,
					android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(i, REQUEST_PICK_MUSIC);

		} else if (v == btnOk) {
			Context context = getActivity().getApplicationContext();
			// int text = hour;
			int duration = Toast.LENGTH_SHORT;
			Toast toast = Toast.makeText(context, "coucou", duration);
			toast.show();
			RemoteNAO.sendCommand(NAOCommands.ALARM_SETTING);

		}

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		switch (requestCode) {

		case REQUEST_PICK_MUSIC:
			if (Activity.RESULT_OK == resultCode) {
				//Uri musicUri = intent.getData();

				String vFilePath = getRealPathFromURI(MainActivity
						.getInstance().getApplicationContext(),
						intent.getData());
				File vFile = new File(vFilePath);

				txtMusic.setText(vFile.getName());
				//uploadFile(vFile);
			}
		}
	}

	private String getRealPathFromURI(Context context, Uri contentUri) {
		
		String[] proj = { MediaStore.Audio.Media.DATA };
		CursorLoader loader = new CursorLoader(context, contentUri, proj, null,
				null, null);
		Cursor cursor = loader.loadInBackground();
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
		cursor.moveToFirst();
		String vPath = cursor.getString(column_index);
		cursor.close();
		return vPath;
	}

/*	private String uploadFile(File aFile) {

		// start async task to upload file
		new AsyncTask<File, Void, File>() {

			@Override
			protected File doInBackground(File... params) {
				if (params.length > 0) {

					// get connector and file
					File vFile = (File) params[0];
					RemoteNAO vRemoteNao = RemoteNAO.getCurrentRemoteNao();
					NAOConnector vConnector = vRemoteNao.getConnector();

					// wait for connector to establish connection
					while (vConnector.getConnectionState() != ConnectionState.CONNECTION_ESTABLISHED
							&& vConnector.getConnectionState() == ConnectionState.CONNECTION_INIT) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
						}
					}

					// upload file
					if (vConnector.uploadSFTP(vFile, NAO_SOUND_DIRECTORY)) {
						return vFile;
					}
					;
				}

				return null;
			}

		}.execute(new File[] { aFile });

		return aFile.getName();
	}*/
	
	private String uploadFile(File aFile) {

		// start async task to upload file
		new AsyncTask<File, Void, File>() {

			@Override
			protected File doInBackground(File... params) {
				if (params.length > 0) {

					// get connector and file
					File vFile = (File) params[0];
					RemoteNAO vRemoteNao = RemoteNAO.getCurrentRemoteNao();
					NAOConnector vConnector = vRemoteNao.getConnector();

					// wait for connector to establish connection
					while (vConnector.getConnectionState() != ConnectionState.CONNECTION_ESTABLISHED
							&& vConnector.getConnectionState() == ConnectionState.CONNECTION_INIT) {
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
						}
					}

					// upload file
					if (vConnector.uploadSFTP(vFile, NAO_SOUND_DIRECTORY)) {
						return vFile;
					}
					;
				}

				return null;
			}

		}.execute(new File[] { aFile });

		return aFile.getName();
	}
}
