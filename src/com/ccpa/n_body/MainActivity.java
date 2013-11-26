package com.ccpa.n_body;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.opengl.GLSurfaceView;

public class MainActivity extends Activity {

	Button nextButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        nextButton = (Button) findViewById(R.id.button1);
        
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
            	// Please note that there is something wrong with the way I've set up the GLsurfaceview in the OpenGL activity
            	// It seems that it requires that it be threaded so we can overlay it 
            	// please look up how to do that.
                Intent goToNextActivity = new Intent(arg0.getContext(),OpenGL.class);
                startActivity(goToNextActivity);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
