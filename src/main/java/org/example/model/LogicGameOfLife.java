package org.example.model;

import org.example.services.read_file.ReadFile;
import org.example.services.transformation.StringToCharArray;
import org.example.services.write_file.WriteFile;

import java.util.List;

public class LogicGameOfLife {
    private String inputPath;
    private String outputPath;
    private int countCycle;
    private int widthArray;
    private int heightArray;
    private char[][] arrayOfLife;
    private char[][] cloneArrayOfLife;
    private List<String> list;
    private List<String> resultLife;

    public LogicGameOfLife(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }
    private void uploadFile(){
       ReadFile readFile = new ReadFile();
       list = readFile.readTheFile(inputPath);
    }
    private void unloading(List<String> list){
        WriteFile writeFile = new WriteFile();
        writeFile.writeToFile(outputPath, list);
    }
    private void uploadingSetting(){
       String[] line = list.get(0).split(",");
        heightArray = Integer.parseInt(line[0]);
        widthArray = Integer.parseInt(line[1]);
        countCycle = Integer.parseInt(line[2]);
        list.remove(0);
        arrayOfLife = new StringToCharArray(heightArray,widthArray).transformationToArray(list);
    }

    private void cellScan(){
        for (int i = 0; i < arrayOfLife.length; i++) {
            int count = 0;
            for (int j = 0; j < arrayOfLife[i].length; j++) {
                count = topCell(j,i) + bottomCell(j,i) + leftCell(j,i) + rightCell(j,i);
                System.out.println("x: "+ j + " y: " + i +" " + count);
            }
        }
    }
    private int isLive(char ch) {
        if(ch == 'O'|| ch == '0'){
            return 1;
        }else {
            return 0;
        }
    }
    private int topCell(int x, int y){
        if((y-1) >= 0){
            return isLive(arrayOfLife[y-1][x]);
        }else {
            return isLive(arrayOfLife[heightArray-1][x]);
        }
    }
    private int bottomCell(int x, int y){
        if((y+1) <= heightArray-1){
            return isLive(arrayOfLife[y+1][x]);
        }else {
            return isLive(arrayOfLife[0][x]);
        }
    }
    private int leftCell(int x, int y){
        if((x-1) >= 0){
            return isLive(arrayOfLife[y][x-1]);
        }else{
            return isLive(arrayOfLife[y][widthArray-1]);
        }
    }
    private int rightCell(int x, int y){
        if((x+1) <= widthArray-1){
            return isLive(arrayOfLife[y][x+1]);
        }else{
            return isLive(arrayOfLife[y][0]);
        }
    }
    private int topLeftCell(int x, int y) {
        if ((y - 1) >= 0) {
           return leftCell(x,y-1);
           /* if ((x - 1) >= 0) {
                return isLive(arrayOfLife[y - 1][x - 1]);
            } else {
                return isLive(arrayOfLife[y - 1][widthArray - 1]);
            }*/
        } else {
            return leftCell(x,heightArray - 1);
           /* if ((x - 1) >= 0) {
                return isLive(arrayOfLife[heightArray - 1][x - 1]);
            } else {
                return isLive(arrayOfLife[heightArray - 1][widthArray - 1]);
            }*/
        }
    }
    private int topRightCell(int x, int y){
        if ((y - 1) >= 0) {
            return rightCell(x,y-1);
           /* if ((x - 1) >= 0) {
                return isLive(arrayOfLife[y - 1][x - 1]);
            } else {
                return isLive(arrayOfLife[y - 1][widthArray - 1]);
            }*/
        } else {
            return rightCell(x,heightArray - 1);
           /* if ((x - 1) >= 0) {
                return isLive(arrayOfLife[heightArray - 1][x - 1]);
            } else {
                return isLive(arrayOfLife[heightArray - 1][widthArray - 1]);
            }*/
        }
    }
    private int bottomLeftCell(int x, int y){
        if((y+1) <= heightArray-1){
            return leftCell(x,y+1);
        }else {
            return leftCell(x,0);
        }
    }
    private int bottomRightCell(int x, int y){
        if((y+1) <= heightArray-1){
            return rightCell(x,y+1);
        }else {
            return rightCell(x,0);
        }
    }

    public void runGame(){
        uploadFile();
        uploadingSetting();
        cellScan();
       // unloading(resultLife);
    }
}
