package rkr.simplekeyboard.inputmethod.keyboard;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import rkr.simplekeyboard.inputmethod.latin.common.Constants;

public class DataHarvester {

    private static DataHarvester harvesterInstance = null;

    private Context mContext;
    private String currentFile;
    private int currentIndex = 0;

    public DataHarvester(Context context) {
        mContext = context;
    }

    public static DataHarvester getInstance(Context context)
    {
        if (harvesterInstance == null)
            harvesterInstance = new DataHarvester(context);

        return harvesterInstance;
    }

    /**
     * Returns a comma-separated string format for the Motion Event
     *
     * Values meaning (in order):
     *  - action name
     *  - key pressed (@TODO)
     *  - x position
     *  - y position
     *  - pressure
     *  - x precision
     *  - y precision
     *  - orientation
     *  - event time
     *
     * @param event MotionEvent from keyboard press
     * @return String Formatted keyEvent
     */
    public String keyEventToString(MotionEvent event)
    {
        String[] line = {
                MotionEvent.actionToString(event.getAction()),
                "Not implemented yet",
                String.valueOf(event.getX()),
                String.valueOf(event.getY()),
                String.valueOf(event.getPressure()),
                String.valueOf(event.getXPrecision()),
                String.valueOf(event.getYPrecision()),
                String.valueOf(event.getOrientation()),
                String.valueOf(event.getEventTime()),
        };

        return TextUtils.join(",", line) + "/n";
    }

    public void writeLineToFile(String line) {
        File path = mContext.getFilesDir();
        File file = new File(path, "key-" + currentIndex + ".txt");

        try (FileOutputStream stream = new FileOutputStream(file)) {
            stream.write(line.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
