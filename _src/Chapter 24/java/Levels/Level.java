package com.gamecodeschool.c24platformer.Levels;

import java.util.ArrayList;

public abstract class Level {
    // If you want to build a new level then extend this class
    ArrayList<String> tiles;
    public ArrayList<String> getTiles(){
        return tiles;
    }
}
