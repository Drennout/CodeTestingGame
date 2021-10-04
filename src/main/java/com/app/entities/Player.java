package com.app.entities;

public class Player {
    private int id;
    private String name;
    private int score;

    public Player(int id, String name, int score) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
