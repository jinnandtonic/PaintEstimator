package edu.orangecoastcollege.cs273.rmillett.paintestimator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member variables for VIEW
    private EditText mLengthEditText;
    private EditText mWidthEditText;
    private EditText mHeightEditText;

    private EditText mDoorsEditText;
    private EditText mWindowsEditText;

    private TextView mGallonsTextView;

    // Member variables for MODEL
    private InteriorRoom mRoom = new InteriorRoom();

    // Member variable for SharedPreferences
    private SharedPreferences mPrefs;

    private void initializeViews() {
        mLengthEditText = (EditText) findViewById(R.id.lengthEditText);
        // TODO: finish initializations
    }

    private void loadSharedPreferences() {
        // TODO: add key string to strings.xml
        mPrefs = getSharedPreferences("edu.orangecoastcollege.cs273.rmillett.PaintEstimator",MODE_PRIVATE);

        if(mPrefs != null) {
            // Load all the room information
            mRoom.setDoors(mPrefs.getInt("doors",0));
            mDoorsEditText.setText(String.valueOf(mRoom.getDoors()));

            mRoom.setWindows(mPrefs.getInt("windows", 0));
            mWindowsEditText.setText(String.valueOf(mRoom.getWindows()));

            mRoom.setLength(mPrefs.getFloat("length", 0.0f));
            mHeightEditText.setText(String.valueOf(mRoom.getLength()));

            // TODO: continue...

            mRoom.setWidth(mPrefs.getFloat("width", 0.0f));
            mRoom.setHeight(mPrefs.getFloat("height", 0.0f));
        }
    }

    private void saveSharedPreferences() {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.clear(); // USE WITH CAUTION
        editor.putFloat("length", mRoom.getLength());
        editor.putFloat("width", mRoom.getWidth());
        editor.putFloat("height",mRoom.getHeight());
        // TODO: finish...

        // Save changes to the SharedPreferences file
        editor.commit(); // THIS IS IMPORTANT
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        loadSharedPreferences();
    }

    // TODO: link this to XML...
    protected void computeGallons(View v) {
        // Update MODEL first, then calculate
        mRoom.setLength(Float.parseFloat(mLengthEditText.getText().toString()));
        mRoom.setWidth(Float.parseFloat(mWidthEditText.getText().toString()));
        mRoom.setHeight(Float.parseFloat(mHeightEditText.getText().toString()));
        // TODO: finish...

        // NOW do calculations
        // TODO: make this prettier...
        mGallonsTextView.setText(getString(R.string.interior_surface_area_text)
        + mRoom.totalSurfaceArea() + "\n" + getString(R.string.gallons_needed_text)
        + mRoom.gallonsOfPaintRequired());
        saveSharedPreferences();
    }

    // TODO: link this to XML...
    protected void goToHelp(View v) {
        // Construct and EXPLICIT Intent to go to HelpActivity
        // Intent: specify where to start (context) and where to go (next Activity)
        Intent helpIntent = new Intent(this, HelpActivity.class);
        helpIntent.putExtra("gallons", mRoom.gallonsOfPaintRequired());
        startActivity(helpIntent);
    }


}
