package com.mahesh;

import static com.mahesh.CommonConstants.COMPUTER;
import static com.mahesh.CommonConstants.COMPUTER1;
import static com.mahesh.CommonConstants.COMPUTER2;
import static com.mahesh.CommonConstants.GAME_LIMIT;
import static com.mahesh.CommonConstants.GAME_TYPE_MSG;
import static com.mahesh.CommonConstants.PAPER_AGAINST_ROCK_WIN_MSG;
import static com.mahesh.CommonConstants.PAPER_AGAINST_SCISSORS_LOST_MSG;
import static com.mahesh.CommonConstants.PLAYER;
import static com.mahesh.CommonConstants.PLAYER1;
import static com.mahesh.CommonConstants.PLAYER2;
import static com.mahesh.CommonConstants.PLAY_AGAIN_MSG;
import static com.mahesh.CommonConstants.REPRESENTATION_MSG;
import static com.mahesh.CommonConstants.ROCK_AGAINST_PAPER_LOST_MSG;
import static com.mahesh.CommonConstants.ROCK_AGAINST_SCISSORS_WIN_MSG;
import static com.mahesh.CommonConstants.SCISSORS_AGAINST_PAPER_WIN_MSG;
import static com.mahesh.CommonConstants.SCISSORS_AGAINST_ROCK_LOST_MSG;
import static com.mahesh.CommonConstants.TIE_MSG;
import static com.mahesh.CommonConstants.USER_CHOOSE_MSG;
import static com.mahesh.CommonConstants.WON_MSG;
import static com.mahesh.CommonConstants.WRONG_GAME_CHOOSE_MSG;
import static com.mahesh.CommonConstants.WRONG_MSG;

import java.util.Random;
import java.util.Scanner;

public class PlayGameRPS implements PlayGame {
  private static final Random random = new Random();
  private static final Scanner scanner = new Scanner(System.in);


  public void startTheGame() {

    System.out.println(GAME_TYPE_MSG);
    int gameChoice = readGameChoice();

    switch (gameChoice) {
      case 1:
        playAgainstComputer();
        break;
      case 2:
        twoPlayerGame();
        break;
      case 3:
        twoComputerGame();
        break;
      default:
        System.out.println(WRONG_GAME_CHOOSE_MSG);
    }

  }

  public void playAgainstComputer() {
    String toContinue;
    Type player1;
    Type player2;

    System.out.println(REPRESENTATION_MSG);
    System.out.println(Type.getRepresentation());
    do {
      player1 = readUserInput(PLAYER);
      player2 = readComputerInput();
      takeDecision(player1, PLAYER, player2, COMPUTER);

      System.out.println(PLAY_AGAIN_MSG);
      toContinue = scanner.nextLine();

    } while (toContinue.equals("Y"));
  }

  public void twoPlayerGame() {
    String toContinue;
    Type player1;
    Type player2;

    System.out.println(REPRESENTATION_MSG);
    System.out.println(Type.getRepresentation());
    do {
      player1 = readUserInput(PLAYER1);
      player2 = readUserInput(PLAYER2);
      takeDecision(player1, PLAYER1, player2, PLAYER2);

      System.out.println(PLAY_AGAIN_MSG);
      toContinue = scanner.nextLine();

    } while (toContinue.equals("Y"));
  }

  public void twoComputerGame() {
    String toContinue;
    Type player1;
    Type player2;

    System.out.println(REPRESENTATION_MSG);
    System.out.println(Type.getRepresentation());
    do {
      player1 = readComputerInput();
      player2 = readComputerInput();
      takeDecision(player1, COMPUTER1, player2, COMPUTER2);

      System.out.println(PLAY_AGAIN_MSG);
      toContinue = scanner.nextLine();
    } while (toContinue.equals("Y"));
  }


  private int readGameChoice() {
    int result = 0;
    try {
      result = Integer.parseInt(scanner.nextLine());
    } catch (Exception e) {
      System.out.println(WRONG_GAME_CHOOSE_MSG);
    }
    return result;
  }


  private Type readUserInput(String userName) {
    Type userType;
    try {
      System.out.println(userName + USER_CHOOSE_MSG);
      userType = Type.valueOf(scanner.nextLine());
    } catch (Exception e) {
      userType = Type.N;
      System.out.println(WRONG_MSG);
    }
    return userType;
  }

  private Type readComputerInput() {
    Type computerType;
    try {
      computerType = Type.valueOf(random.nextInt(GAME_LIMIT));
    } catch (Exception e) {
      computerType = Type.N;
      System.out.println(WRONG_MSG);
    }
    return computerType;
  }

  public void takeDecision(Type player1, String player1Name, Type player2, String player2Name) {
    if (player1.equals(player2)) {
      System.out.println(TIE_MSG);
    } else if (player1.equals(Type.R)) {
      if (player2.equals(Type.S)) {
        System.out.println(player1Name + WON_MSG + ROCK_AGAINST_SCISSORS_WIN_MSG);
      } else if (player2.equals(Type.P)) {
        System.out.println(player2Name + WON_MSG + ROCK_AGAINST_PAPER_LOST_MSG);
      }
    } else if (player1.equals(Type.P)) {
      if (player2.equals(Type.S)) {
        System.out.println(player2Name + WON_MSG + PAPER_AGAINST_SCISSORS_LOST_MSG);
      } else if (player2.equals(Type.R)) {
        System.out.println(player1Name + WON_MSG + PAPER_AGAINST_ROCK_WIN_MSG);
      }
    } else if (player1.equals(Type.S)) {
      if (player2.equals(Type.P)) {
        System.out.println(player1Name + WON_MSG + SCISSORS_AGAINST_PAPER_WIN_MSG);
      } else if (player2.equals(Type.R)) {
        System.out.println(player2Name + WON_MSG + SCISSORS_AGAINST_ROCK_LOST_MSG);
      }
    }
  }
}
