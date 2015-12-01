package de.robotik.nao.communicator.core.sections;

import java.util.Calendar;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;
import de.robotik.nao.communicator.R;

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


	public SectionAlarm(String aTitle) {
		super(aTitle);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// connect ui widgets
				rootView = inflater.inflate(R.layout.page_alarm, container, false);
		//get widget
		//timePicker		
		timePickerAlarm = (TimePicker) findViewById(R.id.timePickerAlarm);	
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
	}

}
