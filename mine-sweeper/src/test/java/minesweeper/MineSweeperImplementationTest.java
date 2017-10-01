package minesweeper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Kacper
 */
public class MineSweeperImplementationTest {

    @Test
    public void minefield(){
        String input = "*...\n..*.\n....";
        String expectedOutput = "*211\n12*1\n0111";

        testMinefield(input, expectedOutput);
    }

    @Test
    public void minefieldWithSingleMineCell(){
        String input = "*";
        String expectedOutput = "*";

        testMinefield(input, expectedOutput);
    }

    @Test
    public void minefieldWithSingleEmptyField(){
        String input = ".";
        String expectedOutput = "0";

        testMinefield(input, expectedOutput);
    }

    @Test
    public void minefieldWithMineSquare(){
        String input = "**\n**";
        String expectedOutput = "**\n**";

        testMinefield(input, expectedOutput);
    }

    @Test
    public void minefieldWithEmptySquare(){
        String input = "..\n..";
        String expectedOutput = "00\n00";

        testMinefield(input, expectedOutput);
    }

    @Test
    public void minefieldWithOneMineInSquare(){
        String input = "..\n.*";
        String expectedOutput = "11\n1*";

        testMinefield(input, expectedOutput);
    }

    @Test
    public void minefieldWithTwoMinesInSquare(){
        String input = "*.\n.*";
        String expectedOutput = "*2\n2*";

        testMinefield(input, expectedOutput);
    }

    private static void testMinefield(String input, String expectedOutput){
        // given
        MineSweeper sweeper = new MineSweeperImplementation();

        // when
        sweeper.setMineField(input);
        String actualOutput = sweeper.getHintField();

        // then
        assertEquals(expectedOutput, actualOutput);
    }
}