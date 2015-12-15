package de.robotik.nao.communicator.core.sections;

<<<<<<< Updated upstream
import java.util.Calendar;

import android.content.Context;
=======

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
>>>>>>> Stashed changes
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< Updated upstream
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
=======
import android.widget.TextView;
import android.widget.TimePicker;
>>>>>>> Stashed changes
import de.robotik.nao.communicator.R;
import de.robotik.nao.communicator.core.RemoteNAO;
import de.robotik.nao.communicator.network.data.NAOCommands;

<<<<<<< Updated upstream
public class SectionAlarm extends Section {
//définition des TimePicker 	
private TimePicker timePickerAlarm;
private int hour, min;

//date picker
private DatePicker datePickerAlarm;
private Calendar calendar;
private int year, month, day;

//bouton
private Button btn;
=======
public class SectionAlarm extends Section implements OnClickListener{
	//definition des TimePicker 	
	private TimePicker timePickerAlarm;
	private Button btnOk;
	private Button btnMusic;
	private TextView txtMusic;
	private static final int REQUEST_PICK_MUSIC = 1;
	//int hour = timePickerAlarm.getCurrentHour();
	//int min = timePickerAlarm.getCurrentMinute();
>>>>>>> Stashed changes


	public SectionAlarm(String aTitle) {
		super(aTitle);
	}

	public SectionAlarm() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// connect ui widgets
		rootView = inflater.inflate(R.layout.page_alarm, container, false);
		
		(btnMusic = (Button) findViewById(R.id.musicButton)).setOnClickListener(this);
		(btnOk = (Button) findViewById(R.id.okButton)).setOnClickListener(this);
		txtMusic = (TextView) findViewById(R.id.musicText);
		
		//timePicker		
		timePickerAlarm = (TimePicker) findViewById(R.id.timePickerAlarm);	
<<<<<<< Updated upstream
		//datePicker
		datePickerAlarm = (DatePicker) findViewById(R.id.datePickerAlarm);	
		//button
		btn = (Button) findViewById(R.id.okButton);
	//onclick.......................................................	
		btn.setOnClickListener( new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
//get time				
 hour = timePickerAlarm.getCurrentHour();
 min = timePickerAlarm.getCurrentMinute();

//get date
 calendar = Calendar.getInstance();
 year = calendar.get(Calendar.YEAR);
 
 month = calendar.get(Calendar.MONTH);
 day = calendar.get(Calendar.DAY_OF_MONTH);
 
 /*Context context = getActivity().getApplicationContext();
 int text = hour;
 int duration = Toast.LENGTH_SHORT;

 Toast toast = Toast.makeText(context, text, duration);
 toast.show();*/			}
		} );
		

//................................................................................		
				return rootView;
=======
		
		return rootView;
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if( v ==  btnMusic){
			Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(i,REQUEST_PICK_MUSIC);
			
		} else if( v == btnOk ){
			RemoteNAO.sendCommand( NAOCommands.ALARM_SETTING );
			
		}
		
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		switch (requestCode) {

        	case REQUEST_PICK_MUSIC:
        		if (Activity.RESULT_OK == resultCode) {
        			Uri musicUri = intent.getData();
        			txtMusic.setText(musicUri.getPath());
        		}
		}
>>>>>>> Stashed changes
	}

}
