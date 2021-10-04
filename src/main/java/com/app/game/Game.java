package com.app.game;

import com.app.entities.Level;
import com.app.entities.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Game {
    private GameSettings settings;

    private List<Player> players;
    private List<Level> levels;

    public Game(){
        settings = new GameSettings(2, 3, new File("game/rules/rule1.txt"));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void start(){
        //Creating levels
        levels = new ArrayList<>();
        levels.add(new Level(new File("game/levels/level1.txt")));
        levels.add(new Level(new File("game/levels/level2.txt")));
        levels.add(new Level(new File("game/levels/level3.txt")));

        //Creating players
        players = new ArrayList<>();
        Player p1 = new Player(1, "player1", 0);
        Player p2 = new Player(2, "player2", 0);
        players.add(p1);
        players.add(p2);

        //Rule output
        System.out.println(settings.outputRule());

        //Starting game
        for (Level level: levels){
            String answer;
            int current_id;
            System.out.println("Следующий уровень");
            System.out.println(level.getContent());

            do {
                System.out.println("Кто отвечает?");
                current_id = new Scanner(System.in).nextInt();

                System.out.println("Введи ответ");
                answer = new Scanner(System.in).nextLine();

                if(level.getAnswer().equals(answer)) {
                    System.out.println(players.get(addScore(current_id, players)).getName() + " получает 1 балл");
                }
                else
                    System.out.println("Ответ неверный");
            }while (!level.getAnswer().equals(answer));
        }
        System.out.println(resultsOfGame());
        System.out.println("Конец игры");
    }

    public String resultsOfGame(){
        if (players.get(0).getScore() > players.get(1).getScore())
            return "Выиграл игрок " + players.get(0).getName() + " со счетом " + players.get(0).getScore() + ":" + players.get(1).getScore();
        else
            return "Выиграл игрок " + players.get(1).getName() + " со счетом " + players.get(1).getScore() + ":" + players.get(0).getScore();
    }

    public int addScore(int current_id, List<Player> players){
        int finalCurrent_id = current_id;
        Optional<Player> curruent_player = players.stream().filter(player -> player.getId() == finalCurrent_id).findFirst();
        int indx = players.indexOf(curruent_player.get());
        curruent_player.get().setScore(curruent_player.get().getScore() + 1);
        players.set(indx, curruent_player.get());
        return indx;
    }
}
