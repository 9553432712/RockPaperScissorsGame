package com.mahesh;

import static com.mahesh.CommonConstants.PLAYER1;
import static com.mahesh.CommonConstants.PLAYER2;
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

class PlayGameAgainstTwoPlayersRPSTest {
  PlayGame playGame;
  private static final String NEW_LINE = System.lineSeparator();

  private final PrintStream systemOut = System.out;
  private ByteArrayOutputStream testOut;

  @Test
  void testDecision_Player1Rock_Player2Scissors() {
    playGame.takeDecision(Type.R, PLAYER1, Type.S, PLAYER2);
    assertEquals(PLAYER1 + WON_MSG + ROCK_AGAINST_SCISSORS_WIN_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Player1Rock_Player2Paper() {
    playGame.takeDecision(Type.R, PLAYER1, Type.P, PLAYER2);
    assertEquals(PLAYER2 + WON_MSG + ROCK_AGAINST_PAPER_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Player1Rock_Player2Rock() {
    playGame.takeDecision(Type.R, PLAYER1, Type.R, PLAYER2);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Player1Paper_Player2Scissors() {
    playGame.takeDecision(Type.P, PLAYER1, Type.S, PLAYER2);
    assertEquals(PLAYER2 + WON_MSG + SCISSORS_AGAINST_PAPER_WIN_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Player1Paper_Player2Rock() {
    playGame.takeDecision(Type.P, PLAYER1, Type.R, PLAYER2);
    assertEquals(PLAYER1 + WON_MSG + ROCK_AGAINST_PAPER_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Player1Paper_Player2Paper() {
    playGame.takeDecision(Type.P, PLAYER1, Type.P, PLAYER2);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Player1Scissors_Player2Scissors() {
    playGame.takeDecision(Type.S, PLAYER1, Type.S, PLAYER2);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Player1Scissors_Player2Rock() {
    playGame.takeDecision(Type.S, PLAYER1, Type.R, PLAYER2);
    assertEquals(PLAYER2 + WON_MSG + SCISSORS_AGAINST_ROCK_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_Player1Scissors_Player2Paper() {
    playGame.takeDecision(Type.S, PLAYER1, Type.P, PLAYER2);
    assertEquals(PLAYER1 + WON_MSG + SCISSORS_AGAINST_PAPER_WIN_MSG + NEW_LINE, testOut.toString());
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