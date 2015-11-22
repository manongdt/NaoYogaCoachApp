package de.robotik.nao.communicator.core.sections;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;


import de.robotik.nao.communicator.R;

public class SectionAlarm extends Section {
//définition des TimePicker 	
private TimePicker timePickerAlarm;
//int hour = timePickerAlarm.getCurrentHour();
//int min = timePickerAlarm.getCurrentMinute();


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
				return rootView;
	}

}
