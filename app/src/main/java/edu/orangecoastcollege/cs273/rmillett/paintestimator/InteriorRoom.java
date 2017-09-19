package edu.orangecoastcollege.cs273.rmillett.paintestimator;

/**
 * Created by rmillett on 9/19/2017.
 */

public class InteriorRoom {

    public static final float DOOR_AREA = 21f;
    public static final float WINDOW_AREA = 16f;
    public static final float SQ_FEET_PER_GALLON = 275f;

    private int mWindows;
    private int mDoors;

    private float mHeight;
    private float mWidth;
    private float mLength;

    public int getWindows() {
        return mWindows;
    }

    public void setWindows(int windows) {
        mWindows = windows;
    }

    public int getDoors() {
        return mDoors;
    }

    public void setDoors(int doors) {
        mDoors = doors;
    }

    public float getHeight() {
        return mHeight;
    }

    public void setHeight(float height) {
        mHeight = height;
    }

    public float getWidth() {
        return mWidth;
    }

    public void setWidth(float width) {
        mWidth = width;
    }

    public float getLength() {
        return mLength;
    }

    public void setLength(float length) {
        mLength = length;
    }

    public float doorAndWindowArea() {
        return mDoors * DOOR_AREA + mWindows * WINDOW_AREA;
    }

    public float wallSurfaceArea() {
        return 2 * mLength * mHeight + 2 * mWidth * mHeight + mLength * mWidth;
    }

    public float totalSurfaceArea() {
        return wallSurfaceArea() - doorAndWindowArea();
    }

    public float gallonsOfPaintRequired() {
        return totalSurfaceArea() / SQ_FEET_PER_GALLON;
    }
}
