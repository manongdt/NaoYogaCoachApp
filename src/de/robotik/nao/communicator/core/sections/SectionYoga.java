package de.robotik.nao.communicator.core.sections;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import de.robotik.nao.communicator.R;
import de.robotik.nao.communicator.core.RemoteNAO;
import de.robotik.nao.communicator.network.data.NAOCommands;

public class SectionYoga extends Section implements OnClickListener{
ImageButton btnYoga;

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

		//get view ................................................................................
		btnYoga = (ImageButton) findViewById(R.id.btnYoga);
		
		// set listener
	
		btnYoga.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        playProgram();
		    }
		});
		
		
		
		return rootView;
	}
	
	
private void playProgram(){
		
			// send command
		RemoteNAO.sendCommand(NAOCommands.PLAY_YOGA);
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
