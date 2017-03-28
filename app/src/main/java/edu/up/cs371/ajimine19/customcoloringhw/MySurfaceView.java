package edu.up.cs371.ajimine19.customcoloringhw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * MySurfaceView is my draw method that has a set method to retrieve my seekbar and textView
 * This method is called to draw the actal Gui that calls on Custom Circle
 * and Custom Rectangle to make SPONGEBOB
 *
 * Code help from Nuxoll's TouchEventsDemo SourceCode File found on moodle
 *
 *
 * Created by devinajimine on 3/26/17.
 */


//implements OnTouchListener and OnSeekbarChangeListener while also extending from the actual surfaceview
public class MySurfaceView extends SurfaceView implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    //instantiated variables to be used in methods below
    // xCor and yCor given values
    int xCor = 1500;
    int yCor = 1500;

    //variables for touch listener and method
    TextView nameOf;
    SeekBar redBar;
    SeekBar greenBar;
    SeekBar blueBar;

    //Universal variable that keeps tracks of the current element that is touched
    CustomElement current = null;

    //element instantions
    CustomRect seaFloor;
    CustomRect body;
    CustomRect legL;
    CustomRect legR;
    CustomRect shirt;
    CustomRect pants;
    CustomRect armL;
    CustomRect armR;
    CustomRect mouth;
    CustomRect toothL;
    CustomRect toothR;


    CustomCircle eyeL;
    CustomCircle eyeR;
    CustomCircle eyeL2;
    CustomCircle eyeR2;
    CustomCircle belt;

    /** called by the ctors to initialize the variables I've added to this class */
    private void myInitializations()
    {
        setWillNotDraw(false);

    }

    public MySurfaceView(Context context) {
        super(context);
        myInitializations();
    }

    /*
    *Constructor that sets the pictures to a color,
    * IMPORTANT: it is important to set your colors in the constructor so it only called once
    * if it is set in the onDraw method the colors will not change since invaldation causes
    * the color to always be set as the original, learned this the hard way :(
    */
    public MySurfaceView(Context context, AttributeSet set) {

        super(context, set);
        myInitializations();

        //set colors and demensions by called CustomRect and CustomCircle
        int sandColor = Color.rgb(255, 230, 204);
        seaFloor = new CustomRect("SeaFloor",sandColor,0, 1100,2100 ,1400 );
        body = new CustomRect("Body",Color.YELLOW,500, 200,1100 ,800);
        shirt = new CustomRect("Shirt",Color.WHITE,500,800 ,1100 ,900 );
        int selectedColor = Color.rgb(210,105,30);
        pants = new CustomRect("Pants",selectedColor,500,900 ,1100 ,1000 );
        legL = new CustomRect("Left Leg",Color.YELLOW,650, 1000,700 ,1100);
        legR = new CustomRect("Right Leg",Color.YELLOW,900, 1000,950 ,1100 );
        armL = new CustomRect("Left Arm",Color.YELLOW,400,550 ,500 ,600 );
        armR = new CustomRect("Right Arm",Color.YELLOW,1100,550 ,1200 ,600 );
        mouth =new CustomRect("Mouth",Color.MAGENTA,600,600 ,1000 ,650 );
        toothL = new CustomRect("Left Tooth",Color.WHITE,700, 650,750 ,675);
        toothR = new CustomRect("Right Tooth",Color.WHITE,850, 650,900 ,675 );

        eyeL = new CustomCircle("Left Eye",Color.BLACK, 700,300, 75);
        eyeR = new CustomCircle("Right Eye",Color.BLACK, 900,300, 75);

        belt = new CustomCircle("Belt",Color.RED, 800,900, 50);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyle) {

        super(context, attrs, defStyle);
        myInitializations();
    }
    //onDraw method draws the elements on the canvas, or
    @Override
    protected void onDraw(Canvas canvas) {

        //Sea Floor
        seaFloor.drawMe(canvas);

        //SpongeBOB body with clothes
        body.drawMe(canvas);
        shirt.drawMe(canvas);
        pants.drawMe(canvas);
        legL.drawMe(canvas);
        legR.drawMe(canvas);
        eyeL.drawMe(canvas);
        eyeR.drawMe(canvas);
        armL.drawMe(canvas);
        armR.drawMe(canvas);
        mouth.drawMe(canvas);
        toothL.drawMe(canvas);
        toothR.drawMe(canvas);
        belt.drawMe(canvas);

        //Conditions to see which element got touched based on the x and y coordinates

        if(eyeL.containsPoint(xCor,yCor))
        {
            //set the element to current
            //retrieves the name to change the textView to the name that
            // was passed in through the set method below
            current = eyeL;
            eyeL.drawHighlight(canvas);
            nameOf.setText(eyeL.getName());

            //get the color of the element, then with a static method red() to get the red values
            //and set the progress according to the seekbar
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
        else if(mouth.containsPoint(xCor,yCor))
        {
            current = mouth;
            mouth.drawHighlight(canvas);
            nameOf.setText(mouth.getName());
            redBar.setProgress(Color.red(mouth.getColor()));
            greenBar.setProgress(Color.green(mouth.getColor()));
            blueBar.setProgress(Color.blue(mouth.getColor()));

        }
        else if(toothL.containsPoint(xCor,yCor))
        {
            current = toothL;
            toothL.drawHighlight(canvas);
            nameOf.setText(toothL.getName());
            redBar.setProgress(Color.red(toothL.getColor()));
            greenBar.setProgress(Color.green(toothL.getColor()));
            blueBar.setProgress(Color.blue(toothL.getColor()));

        }
        else if(toothR.containsPoint(xCor,yCor))
        {
            current = toothR;
            toothR.drawHighlight(canvas);
            nameOf.setText(toothR.getName());
            redBar.setProgress(Color.red(toothR.getColor()));
            greenBar.setProgress(Color.green(toothR.getColor()));
            blueBar.setProgress(Color.blue(toothR.getColor()));

        }
        else if(belt.containsPoint(xCor,yCor))
        {
            current = belt;
            belt.drawHighlight(canvas);
            nameOf.setText(belt.getName());
            redBar.setProgress(Color.red(belt.getColor()));
            greenBar.setProgress(Color.green(belt.getColor()));
            blueBar.setProgress(Color.blue(belt.getColor()));

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
        else if(armL.containsPoint(xCor,yCor))
        {
            current = armL;
            armL.drawHighlight(canvas);
            nameOf.setText(armL.getName());
            redBar.setProgress(Color.red(armL.getColor()));
            greenBar.setProgress(Color.green(armL.getColor()));
            blueBar.setProgress(Color.blue(armL.getColor()));

        }
        else if(armR.containsPoint(xCor,yCor))
        {
            current = armR;
            armR.drawHighlight(canvas);
            nameOf.setText(armR.getName());
            redBar.setProgress(Color.red(armR.getColor()));
            greenBar.setProgress(Color.green(armR.getColor()));
            blueBar.setProgress(Color.blue(armR.getColor()));

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
        else if(pants.containsPoint(xCor,yCor))
        {
            current = pants;
            pants.drawHighlight(canvas);
            nameOf.setText(pants.getName());
            redBar.setProgress(Color.red(pants.getColor()));
            greenBar.setProgress(Color.green(pants.getColor()));
            blueBar.setProgress(Color.blue(pants.getColor()));

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
            //else return to get out of the method or when no element is touched to do nothing
    }


    // when someone touched the board it takes in th ex-coordinates and y-coordinates
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        if(event.getAction() != MotionEvent.ACTION_UP)
        {
            return true;
        }

        xCor = (int) event.getX();
        yCor = (int) event.getY();

        //then invalidate to draw again
        invalidate();
        return true;
    }


    //Setter method to recieve the seekbars and textView
    public void setTextView(TextView nameElement, SeekBar redSeek, SeekBar greenSeeker, SeekBar blueSeeker)
    {
        nameOf = nameElement;
        redBar = redSeek;
        greenBar = greenSeeker;
        blueBar = blueSeeker;
    }

    //method to change the color according to the seek bar
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        //new Color based on the progress of the seekbars
        int newColor = 0;

        if(current == null){return;}

        //conditions based on which seekbar is being used
        //takes in the progress and leaves the others alone
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

        //invalidate to draw again
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