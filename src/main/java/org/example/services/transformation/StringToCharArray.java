package org.example.services.transformation;

import java.util.List;

public class StringToCharArray {
    private int widthArray;
    private int heightArray;

    public StringToCharArray(int widthArray, int heightArray) {
        this.widthArray = widthArray;
        this.heightArray = heightArray;
    }

    public char[][] transformationToArray(List<String> list) {
        int countHeight = 0;
        char[][] array = new char[heightArray][widthArray];
        for (String s : list) {
            array[countHeight] = s.toCharArray();
            countHeight++;
        }
        return array;
    }
}

