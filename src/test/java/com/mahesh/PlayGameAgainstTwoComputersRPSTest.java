package com.mahesh;

import static com.mahesh.CommonConstants.COMPUTER1;
import static com.mahesh.CommonConstants.COMPUTER2;
import static com.mahesh.CommonConstants.ROCK_AGAINST_PAPER_LOST_MSG;
import static com.mahesh.CommonConstants.ROCK_AGAINST_SCISSORS_WIN_MSG;
import static com.mahesh.CommonConstants.SCISSORS_AGAINST_PAPER_WIN_MSG;
import static com.mahesh.CommonConstants.SCISSORS_AGAINST_ROCK_LOST_MSG;
import static com.mahesh.CommonConstants.TIE_MSG;
import static com.mahesh.CommonConstants.WON_MSG;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PlayGameAgainstTwoComputersRPSTest {
  PlayGame playGame;
  private static final String NEW_LINE = System.lineSeparator();

  private final PrintStream systemOut = System.out;
  private ByteArrayOutputStream testOut;

  @Test
  void testDecision_Computer1Rock_Computer2Scissors() {
    playGame.takeDecision(Type.R, COMPUTER1, Type.S, COMPUTER2);
    assertEquals(COMPUTER1 + WON_MSG + ROCK_AGAINST_SCISSORS_WIN_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Computer1Rock_Computer2Paper() {
    playGame.takeDecision(Type.R, COMPUTER1, Type.P, COMPUTER2);
    assertEquals(COMPUTER2 + WON_MSG + ROCK_AGAINST_PAPER_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Computer1Rock_Computer2Rock() {
    playGame.takeDecision(Type.R, COMPUTER1, Type.R, COMPUTER2);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Computer1Paper_Computer2Scissors() {
    playGame.takeDecision(Type.P, COMPUTER1, Type.S, COMPUTER2);
    assertEquals(COMPUTER2 + WON_MSG + SCISSORS_AGAINST_PAPER_WIN_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Computer1Paper_Computer2Rock() {
    playGame.takeDecision(Type.P, COMPUTER1, Type.R, COMPUTER2);
    assertEquals(COMPUTER1 + WON_MSG + ROCK_AGAINST_PAPER_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Computer1Paper_Computer2Paper() {
    playGame.takeDecision(Type.P, COMPUTER1, Type.P, COMPUTER2);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Computer1Scissors_Computer2Scissors() {
    playGame.takeDecision(Type.S, COMPUTER1, Type.S, COMPUTER2);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Computer1Scissors_Computer2Rock() {
    playGame.takeDecision(Type.S, COMPUTER1, Type.R, COMPUTER2);
    assertEquals(COMPUTER2 + WON_MSG + SCISSORS_AGAINST_ROCK_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Computer1Scissors_Computer2Paper() {
    playGame.takeDecision(Type.S, COMPUTER1, Type.P, COMPUTER2);
    assertEquals(COMPUTER1 + WON_MSG + SCISSORS_AGAINST_PAPER_WIN_MSG + NEW_LINE, testOut.toString());
  }

  @BeforeEach
  public void setUpOutput() {
    playGame = new PlayGameRPS();
    testOut = new ByteArrayOutputStream();
    System.setOut(new PrintStream(testOut));
  }

  @AfterEach
  public void restoreOutput() {
    System.setOut(systemOut);
  }
}