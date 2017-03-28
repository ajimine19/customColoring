package edu.up.cs371.ajimine19.customcoloringhw;

import java.util.Vector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by devinajimine on 3/26/17.
 */



public class MySurfaceView extends SurfaceView implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    // A list of where the spots are
    int xCor = 1500;
    int yCor = 1500;
    TextView nameOf;
    SeekBar redBar;
    SeekBar greenBar;
    SeekBar blueBar;
    CustomElement current = null;

    CustomRect seaFloor;
    CustomRect body;
    CustomRect legL;
    CustomRect legR;
    CustomRect shirt;

    CustomCircle eyeL;
    CustomCircle eyeR;
    CustomCircle lollipop;






    /** called by the ctors to initialize the variables I've added to this class */
    private void myInitializations()
    {
        setWillNotDraw(false);

    }

    public MySurfaceView(Context context) {
        super(context);
        myInitializations();
    }

    public MySurfaceView(Context context, AttributeSet set) {
        super(context, set);
        myInitializations();
        seaFloor = new CustomRect("SeaFloor",Color.GREEN,0, 1100,2100 ,1400 );
        body = new CustomRect("Body",Color.YELLOW,500, 200,1100 ,800);
        int selectedColor = Color.rgb(210,105,30);
        shirt = new CustomRect("Shirt",selectedColor,500,800 ,1100 ,1000 );
        legL = new CustomRect("Left Leg",Color.YELLOW,650, 1000,700 ,1100);
        legR = new CustomRect("Right Leg",Color.YELLOW,850, 1000,900 ,1100 );
        eyeL = new CustomCircle("Left Eye",Color.BLACK, 700,300, 75);
        eyeR = new CustomCircle("Right Eye",Color.BLACK, 900,300, 75);
        lollipop = new CustomCircle("lollipop",Color.BLUE, 800,900, 50);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        myInitializations();
    }




    @Override
    protected void onDraw(Canvas canvas) {





        seaFloor.drawMe(canvas);


        body.drawMe(canvas);


        shirt.drawMe(canvas);


        legL.drawMe(canvas);


        legR.drawMe(canvas);


        //face

        eyeL.drawMe(canvas);

        //eyes

        eyeR.drawMe(canvas);


        lollipop.drawMe(canvas);

/*
        if(current != null)
            current.drawHighlight(canvas);


*/


        //Initial checks after drawing everything



        if(eyeL.containsPoint(xCor,yCor))
        {
            current = eyeL;
            eyeL.drawHighlight(canvas);
            nameOf.setText(eyeL.getName());
            redBar.setProgress(Color.red(eyeL.getColor()));
            greenBar.setProgress(Color.green(eyeL.getColor()));
            blueBar.setProgress(Color.blue(eyeL.getColor()));

        }
        else if(eyeR.containsPoint(xCor,yCor))
        {
            current = eyeR;
            eyeR.drawHighlight(canvas);
            nameOf.setText(eyeR.getName());
            redBar.setProgress(Color.red(eyeR.getColor()));
            greenBar.setProgress(Color.green(eyeR.getColor()));
            blueBar.setProgress(Color.blue(eyeR.getColor()));

        }
        else if(lollipop.containsPoint(xCor,yCor))
        {
            current = lollipop;
            lollipop.drawHighlight(canvas);
            nameOf.setText(lollipop.getName());
            redBar.setProgress(Color.red(lollipop.getColor()));
            greenBar.setProgress(Color.green(lollipop.getColor()));
            blueBar.setProgress(Color.blue(lollipop.getColor()));

        }
        else if(seaFloor.containsPoint(xCor,yCor))
        {
            current = seaFloor;
            seaFloor.drawHighlight(canvas);
            nameOf.setText(seaFloor.getName());
            redBar.setProgress(Color.red(seaFloor.getColor()));
            greenBar.setProgress(Color.green(seaFloor.getColor()));
            blueBar.setProgress(Color.blue(seaFloor.getColor()));

        }
        else if(body.containsPoint(xCor,yCor))
        {

            current = body;
            body.drawHighlight(canvas);
            nameOf.setText(body.getName());
            redBar.setProgress(Color.red(body.getColor()));
            greenBar.setProgress(Color.green(body.getColor()));
            blueBar.setProgress(Color.blue(body.getColor()));

        }
        else if(shirt.containsPoint(xCor,yCor))
        {
            current = shirt;
            shirt.drawHighlight(canvas);
            nameOf.setText(shirt.getName());
            redBar.setProgress(Color.red(shirt.getColor()));
            greenBar.setProgress(Color.green(shirt.getColor()));
            blueBar.setProgress(Color.blue(shirt.getColor()));

        }
        else if(legL.containsPoint(xCor,yCor))
        {
            current = legL;
            legL.drawHighlight(canvas);
            nameOf.setText(legL.getName());
            redBar.setProgress(Color.red(legL.getColor()));
            greenBar.setProgress(Color.green(legL.getColor()));
            blueBar.setProgress(Color.blue(legL.getColor()));

        }
        else if(legR.containsPoint(xCor,yCor))
        {
            current = legR;
            legR.drawHighlight(canvas);
            nameOf.setText(legR.getName());
            redBar.setProgress(Color.red(legR.getColor()));
            greenBar.setProgress(Color.green(legR.getColor()));
            blueBar.setProgress(Color.blue(legR.getColor()));

        }
        else
            return;

    }



    /** when the user touches the surface view, add a spot there */
    @Override
    public boolean onTouch(View v, MotionEvent event) {


        if(event.getAction() != MotionEvent.ACTION_UP)
        {
            return true;
        }

        xCor = (int) event.getX();
        yCor = (int) event.getY();










        invalidate();

        return true;
    }



    public void setTextView(TextView nameElement, SeekBar redSeek, SeekBar greenSeeker, SeekBar blueSeeker)
    {

        nameOf = nameElement;
        redBar = redSeek;
        greenBar = greenSeeker;
        blueBar = blueSeeker;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


        int newColor = 0;

        if(current == null){return;}

        if(seekBar.equals(redBar))
        {
            newColor = Color.rgb(redBar.getProgress(),Color.green(current.getColor()), Color.blue(current.getColor()));

        }
        else if(seekBar.equals(greenBar))
        {
            newColor = Color.rgb(Color.red(current.getColor()),greenBar.getProgress(), Color.blue(current.getColor()));

        }
        else if(seekBar.equals( blueBar))
        {
            newColor = Color.rgb(Color.red(current.getColor()),Color.green(current.getColor()), blueBar.getProgress());
        }
        current.setColor(newColor);


        invalidate();

        return;





    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}// class MySurfaceView