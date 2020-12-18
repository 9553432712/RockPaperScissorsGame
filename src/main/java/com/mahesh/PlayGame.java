package com.mahesh;

public interface PlayGame {
  void startTheGame();

  void twoPlayerGame();

  void playAgainstComputer();

  void twoComputerGame();

  void takeDecision(Type player1, String player1Name, Type player2, String player2Name);
}
