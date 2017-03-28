package edu.up.cs371.ajimine19.customcoloringhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

/*
 *@author Devin Ajimine
 * With code reasources (please view MySurfaceView Class)
 * @Date 3/26/17
 * @version Spring 2015
 *
 */
public class MainActivity extends AppCompatActivity {

    //instantiated variables for touch
    private SeekBar redSeeker;
    private SeekBar greenSeeker;
    private SeekBar blueSeeker;
    private TextView elementName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //created a textview for each elements name to be passed through
        elementName = (TextView)findViewById(R.id.elementName);

        //Created a surfaceView to get access to pass listeners
        MySurfaceView canvasView = (MySurfaceView) findViewById(R.id.surfaceView);
        canvasView.setOnTouchListener(canvasView);

        //set seek bars fro red, green, and blue
        redSeeker = (SeekBar) findViewById(R.id.redSeek);
        redSeeker.setOnSeekBarChangeListener(canvasView);

        greenSeeker = (SeekBar) findViewById(R.id.greenSeek);
        greenSeeker.setOnSeekBarChangeListener(canvasView);

        blueSeeker = (SeekBar) findViewById(R.id.blueSeek);
        blueSeeker.setOnSeekBarChangeListener(canvasView);

        //called the set method to pass all the listeners into my drawable class aka MySurfaceView
        canvasView.setTextView(elementName,redSeeker, greenSeeker, blueSeeker);
    }
}