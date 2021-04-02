package rkr.simplekeyboard.inputmethod.keyboard;

import java.math.BigInteger;

public class DataHarvester {

    private static DataHarvester harvesterInstance = null;

    private String currentFile;
    private int currentIndex = 0;

    private DataHarvester()
    {

    }

    public static DataHarvester getInstance()
    {
        if (harvesterInstance == null)
            harvesterInstance = new DataHarvester();

        return harvesterInstance;
    }
}
