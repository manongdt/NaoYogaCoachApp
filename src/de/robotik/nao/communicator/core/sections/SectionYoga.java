package de.robotik.nao.communicator.core.sections;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import de.robotik.nao.communicator.R;

public class SectionYoga extends Section implements OnClickListener{

	public SectionYoga(String nomPage) {
		// TODO Auto-generated constructor stub
	}
	
	public SectionYoga() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// connect ui widgets
		View rootView = inflater.inflate(R.layout.page_yoga, container, false);

		// ................................................................................
		return rootView;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}
