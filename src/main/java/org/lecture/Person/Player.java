package org.lecture.Person;

import lombok.EqualsAndHashCode;

/**
 * The Player class represents a player in the game.
 */
@EqualsAndHashCode
public class Player {
    private String name;
    private int healthPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                '}';
    }

    /**
     * Constructs a new Player object with default name and health points.
     */
    public Player() {
        this.name = "";
        this.healthPoints = 0;
    }
    public boolean survivedRoom() {
        return healthPoints > 0;
    }
}
