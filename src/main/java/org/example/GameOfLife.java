package org.example;

import org.example.model.LogicGameOfLife;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GameOfLife {
    public static void main(String[] args) {
        game("src\\test\\resources\\test.txt","src\\test\\resources\\outputTest.txt");
    }
    public static void game(String inputPath, String outputPath){
        LogicGameOfLife logicGame = new LogicGameOfLife(inputPath,outputPath);
        logicGame.runGame();
    }
}
