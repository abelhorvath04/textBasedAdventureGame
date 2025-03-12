package org.lecture.Room;

import org.lecture.Game.ColorText;
import org.lecture.Person.Player;

/**
 * The EndRoom class represents a special room in the game where the player finishes the game.
 * It extends the Room class and overrides the survivedRoom method to handle the end of the game.
 */
public class EndRoom extends Room{

    public EndRoom() {
        super(null);
    }


    /**
     * Overrides the survivedRoom method to print a congratulatory message and check if the player has survived.
     *
     * @param player the player who reached the end room
     * @return true if the player has survived, false otherwise
     */
    @Override
    public boolean survivedRoom(Player player) {
        String congrats = "Congrats!";
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "You are the winner "
                + ColorText.BLUE_BOLD
                + player.getName()
                + ColorText.RESET_COLOR
                + " with "
                + ColorText.BLUE_BOLD
                + player.getHealthPoints()
                + ColorText.RESET_COLOR
                + " HP \n"
                + ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + ColorText.GREEN_BOLD
                + congrats
                + ColorText.RESET_COLOR);
        printFirework();
        return player.survivedRoom();
    }

    /**
     * Prints a firework animation to celebrate the player's victory.
     */
    private static void printFirework() {
        System.out.println(ColorText.YELLOW_BOLD + "                                                 .''." + ColorText.RESET_COLOR);
        System.out.println(ColorText.BLUE_BOLD + "                       .''.             *''*    :_\\/_:     ." + ColorText.RESET_COLOR);
        System.out.println(ColorText.GREEN_BOLD + "                      :_\\/_:   .    .:.*_\\/_*   : /\\ :  .'.:.'." + ColorText.RESET_COLOR);
        System.out.println(ColorText.RED_BOLD + "                  .''.: /\\ : _\\(/_  ':'* /\\ *  : '..'.  -=:o:=-" + ColorText.RESET_COLOR);
        System.out.println(ColorText.YELLOW_BOLD + "                 :_\\/_:'.:::. /)\\*''*  .|.* '.\\'/.'_\\(/_'.':'.'" + ColorText.RESET_COLOR);
        System.out.println(ColorText.BLUE_BOLD + "                 : /\\ : :::::  '*_\\/_* | |  -= o =- /)\\    '  *" + ColorText.RESET_COLOR);
        System.out.println(ColorText.GREEN_BOLD + "                  '..'  ':::'   * /\\ * |'|  .'/.\\'.  '._____" + ColorText.RESET_COLOR);
        System.out.println(ColorText.RED_BOLD + "                      *        __*..* |  |     :      |.   |' .---\"|" + ColorText.RESET_COLOR);
        System.out.println(ColorText.YELLOW_BOLD + "                       _*   .-'   '-. |  |     .--'|  ||   | _|    |" + ColorText.RESET_COLOR);
        System.out.println(ColorText.BLUE_BOLD + "                    .-'|  _.|  |    ||   '-__  |   |  |    ||      |" + ColorText.RESET_COLOR);
        System.out.println(ColorText.GREEN_BOLD + "                    |' | |.    |    ||       | |   |  |    ||      |" + ColorText.RESET_COLOR);
        System.out.println(ColorText.RED_BOLD + "                 ___|  '-'     '    \"\"       '-'   '-.'    '`      |____" + ColorText.RESET_COLOR);
        System.out.println(ColorText.YELLOW_BOLD + "                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ColorText.RESET_COLOR);
        System.out.println(ColorText.BLUE_BOLD + "                                    " + ColorText.RESET_COLOR);
        System.out.println(ColorText.GREEN_BOLD + "                ------------------------------------------------" + ColorText.RESET_COLOR);
        System.out.println(ColorText.RED_BOLD + "                \"\"\"" + ColorText.RESET_COLOR);
    }
}
