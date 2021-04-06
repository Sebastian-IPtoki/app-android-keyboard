package rkr.simplekeyboard.inputmethod.keyboard;

import android.view.MotionEvent;

public class UserEvent {

    private static final String TAG = "UserEvent";

    private final int action;
    private final float posX;
    private final float posY;
    private final float pressure;
    private final float precisionX;
    private final float precisionY;
    private final float orientation;
    private final float eventTime;

    /**
     * Save all the required values we need in
     * the object
     *
     * @param event MotionEvent from the keyboard
     */
    public UserEvent(MotionEvent event) {
        action = event.getAction();
        posX = event.getX();
        posY = event.getY();
        pressure = event.getPressure();
        precisionX = event.getXPrecision();
        precisionY = event.getYPrecision();
        orientation = event.getOrientation();
        eventTime = event.getEventTime();
    }

    /**
     * Check if this UserEvent is 'ACTION_UP' meaning we finished
     * the user interaction. 'ACTION_UP' is sent when a user removes his
     * fingers from the screen.
     *
     * @return boolean Whether the action is the last of the movement
     */
    public boolean isLastAction() {
        return action == MotionEvent.ACTION_UP;
    }

    /**
     * Returns the name in String of this UserEvent action
     *
     * @return String name of the action
     * @see MotionEvent
     */
    public String getActionName() {
        return MotionEvent.actionToString(action);
    }

    /**
     * Convert the UserEvent class to a String
     * and return the result
     *
     * @return String UserEvent as a string
     */
    public String toString() {
        String result = "";

        String[] line = {
                String.valueOf(action),
                String.valueOf(posX),
                String.valueOf(posY),
                String.valueOf(pressure),
                String.valueOf(precisionX),
                String.valueOf(precisionY),
                String.valueOf(orientation),
                String.valueOf(eventTime),
        };

        StringBuilder sb = new StringBuilder();

        for (String s : line) {
            sb.append(s).append(",");
        }

        result = sb.deleteCharAt(sb.length() - 1).toString();
        result = sb.append( "\n").toString();
        return result;
    }
}
