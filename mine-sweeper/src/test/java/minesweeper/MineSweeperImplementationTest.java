package minesweeper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kacper
 */
public class MineSweeperImplementationTest {

    @Test
    public void minefield(){
        // given
        MineSweeper sweeper = new MineSweeperImplementation();
        String input = "*...\n..*.\n....";
        String expectedOutput = "*211\n12*1\n0111";

        // when
        sweeper.setMineField(input);
        String actualOutput = sweeper.getHintField();

        // then
        assertEquals(expectedOutput, actualOutput);
    }
}