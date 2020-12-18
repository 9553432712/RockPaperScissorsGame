package com.mahesh;

import static com.mahesh.CommonConstants.COMPUTER;
import static com.mahesh.CommonConstants.PLAYER;
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

class PlayGameAgainstComputerRPSTest {
  PlayGame playGame;
  private static final String NEW_LINE = System.lineSeparator();

  private final PrintStream systemOut = System.out;
  private ByteArrayOutputStream testOut;

  @Test
  void testDecision_PlayerRock_ComputerScissors() {
    playGame.takeDecision(Type.R, PLAYER, Type.S, COMPUTER);
    assertEquals(PLAYER + WON_MSG + ROCK_AGAINST_SCISSORS_WIN_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_PlayerRock_ComputerPaper() {
    playGame.takeDecision(Type.R, PLAYER, Type.P, COMPUTER);
    assertEquals(COMPUTER + WON_MSG + ROCK_AGAINST_PAPER_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_PlayerRock_ComputerRock() {
    playGame.takeDecision(Type.R, PLAYER, Type.R, COMPUTER);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_PlayerPaper_ComputerScissors() {
    playGame.takeDecision(Type.P, PLAYER, Type.S, COMPUTER);
    assertEquals(COMPUTER + WON_MSG + SCISSORS_AGAINST_PAPER_WIN_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_PlayerPaper_ComputerRock() {
    playGame.takeDecision(Type.P, PLAYER, Type.R, COMPUTER);
    assertEquals(PLAYER + WON_MSG + ROCK_AGAINST_PAPER_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_PlayerPaper_ComputerPaper() {
    playGame.takeDecision(Type.P, PLAYER, Type.P, COMPUTER);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_PlayerScissors_ComputerScissors() {
    playGame.takeDecision(Type.S, PLAYER, Type.S, COMPUTER);
    assertEquals(TIE_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_PlayerScissors_ComputerRock() {
    playGame.takeDecision(Type.S, PLAYER, Type.R, COMPUTER);
    assertEquals(COMPUTER + WON_MSG + SCISSORS_AGAINST_ROCK_LOST_MSG + NEW_LINE, testOut.toString());
  }

  @Test
  void testDecision_PlayerScissors_ComputerPaper() {
    playGame.takeDecision(Type.S, PLAYER, Type.P, COMPUTER);
    assertEquals(PLAYER + WON_MSG + SCISSORS_AGAINST_PAPER_WIN_MSG + NEW_LINE, testOut.toString());
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