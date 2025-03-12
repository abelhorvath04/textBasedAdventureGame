package org.lecture.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The NPC (Non-Player Character) class is an abstract class representing characters in the game
 * that are not controlled by the player.
 */
@Getter
@Setter
@AllArgsConstructor
public abstract class NPC {
    public abstract void speak();
}
