package edu.up.cs371.ajimine19.customcoloringhw;

/**
 * Created by devinajimine on 3/26/17.
 */


import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;

/** This class represents a single round spot (circle) on the screen */
public class Spot {

    protected int x; // x-coord
    protected int y; // y-coord
    protected int size = 20; // all spots are size 10
    protected Paint myPaint; // how the spot is drawn

    /** gives the spot a random colored paint */
    protected void setRandomPaint() {
        int color = Color.rgb((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256));
        myPaint = new Paint();
        myPaint.setColor(color);
    }

    /** this ctor initializes a spot with random values */
    public Spot() {
        // place a spot in a random location
        x = (int) (Math.random() * 500) + 5;
        y = (int) (Math.random() * 500) + 5;
        setRandomPaint();
    }

    /** this ctor creates a spot at a specified location */
    public Spot(int initX, int initY) {
        // place a spot in a random location
        x = initX;
        y = initY;
        setRandomPaint();
    }

    /** a spot knows how to draw itself on a given canvas
     *
     * @param canvas  is the canvas to draw upon
     */
    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, size, myPaint);
    }
}// class Spot
