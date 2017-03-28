package edu.up.cs371.ajimine19.customcoloringhw;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar redSeeker;
    private SeekBar greenSeeker;
    private SeekBar blueSeeker;
    private TextView elementName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementName = (TextView)findViewById(R.id.elementName);

        MySurfaceView canvasView = (MySurfaceView) findViewById(R.id.surfaceView);
        canvasView.setOnTouchListener(canvasView);

        redSeeker = (SeekBar) findViewById(R.id.redSeek);
        redSeeker.setOnSeekBarChangeListener(canvasView);

        greenSeeker = (SeekBar) findViewById(R.id.greenSeek);
        greenSeeker.setOnSeekBarChangeListener(canvasView);

        blueSeeker = (SeekBar) findViewById(R.id.blueSeek);
        blueSeeker.setOnSeekBarChangeListener(canvasView);



        canvasView.setTextView(elementName,redSeeker, greenSeeker, blueSeeker);

        //return;


    }





}