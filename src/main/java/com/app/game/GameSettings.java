package com.app.game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class GameSettings {
    private int quantityOfPlayers;
    private int getQuantityOfLevels;
    private File rules;

    public GameSettings(int quantityOfPlayers, int getQuantityOfLevels, File rules) {
        this.quantityOfPlayers = quantityOfPlayers;
        this.getQuantityOfLevels = getQuantityOfLevels;
        this.rules = rules;
    }

    public String outputRule(){
        try(FileReader rf = new FileReader(rules))
        {

            BufferedReader reader = new BufferedReader(rf);
            String line = reader.readLine();
            String rule = "";

            while(line != null){
                rule += line + "\n";

                line = reader.readLine();
            }
            return rule;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            return null;
        }
    }

    public int getQuantityOfPlayers() {
        return quantityOfPlayers;
    }

    public void setQuantityOfPlayers(int quantityOfPlayers) {
        this.quantityOfPlayers = quantityOfPlayers;
    }

    public int getGetQuantityOfLevels() {
        return getQuantityOfLevels;
    }

    public void setGetQuantityOfLevels(int getQuantityOfLevels) {
        this.getQuantityOfLevels = getQuantityOfLevels;
    }
}
