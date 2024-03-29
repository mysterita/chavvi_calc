package com.chavviCalcExample;

import java.util.*;

/*
 * chavvi calc calculator
 */
public class ChavviCalcExampleApp {
  static double a = 0.0;
  static double b = 0.0;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Character command = '_';

    // loop until user quits
    while (command != 'q') {
      printMenu();
      System.out.print("Enter a command: ");
      command = menuGetCommand(scan);

      executeCommand(scan, command);
    }

    scan.close();
  }

  //
  // menu functions
  //
  // Print a line to separate menu sections

  private static void printMenuLine() {
    System.out.println(
        "----------------------------------------------------------");
  }

  // Print a static menu command
  private static void printMenuCommand(Character command, String desc) {
    System.out.printf("%s\t%s\n", command, desc);
  }

  // prints the menu
  public static void printMenu() {
    printMenuLine();
    System.out.println("ChavviCalc");
    printMenuLine();
    printMenuParameters();
    printMenuLine();
    printMenuCommand('a', "Enter a value for A");
    printMenuCommand('b', "Enter a value for B");
    printMenuCommand('+', "Add");
    printMenuCommand('-', "Subtract");
    printMenuCommand('*', "Multiply");
    printMenuCommand('/', "Divide");
    printMenuCommand('c', "Clear");
    printMenuCommand('q', "Quit");

    printMenuLine();
  }

  // Print the current values of A and B
  private static void printMenuParameters() {
    System.out.printf("A = %.3f    B = %.3f%n", a, b);
  }

  // get first character from input
  private static Character menuGetCommand(Scanner scan) {
    Character command = '_';

    String rawInput = scan.nextLine();

    if (rawInput.length() > 0) {
      rawInput = rawInput.toLowerCase();
      command = rawInput.charAt(0);
    }

    return command;
  }

  // calculator functions
  // Execute the selected command
  private static Boolean executeCommand(Scanner scan, Character command) {
    Boolean success = true;

    switch (command) {
      case 'a':
        System.out.println("Enter value for A");
        try {
          a = Double.parseDouble(scan.nextLine());
        } catch (Exception e) {
          System.out.println("Error: 'A' must be a numerical value");
          success = false;
        }
        break;
      case 'b':
        System.out.println("Enter value for B");
        try {
          b = Double.parseDouble(scan.nextLine());
        } catch (Exception e) {
          System.out.println("Error: 'B' must be a numerical value");
          success = false;
        }
        break;
      case '+':
        System.out.printf("Result is: %.3f%n", a + b);
        break;
      case '-':
        System.out.printf("Result is: %.3f%n", a - b);
        break;
      case '*':
        System.out.printf("Result is: %.3f%n", a * b);
        break;
      case '/':
        if (b != 0) {
          System.out.printf("Result is: %.3f%n", a / b);
        } else {
          System.out.println("ERROR: Division by zero.");
        }
        break;
      case 'c':
        System.out.println("Cleared values for A and B.");
        a = 0.0;
        b = 0.0;
        break;
      case 'q':
        System.out.println("Thank you for using Chavvi Calc");
        break;
      default:
        System.out.printf("ERROR: Unknown commmand: %s%n", command);
        success = false;
    }

    return success;
  }
}
