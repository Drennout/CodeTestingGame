package com.app;

import com.app.game.Game;

import java.util.Scanner;

public class StartupApp {
    public static void main(String[] args) {
        Game game = new Game();

        game.start();
    }
}
