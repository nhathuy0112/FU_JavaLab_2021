package P0067;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class AnalysisString {
  Scanner sc = new Scanner(System.in);

  public String checkInputString(String information) {
    while (true) {
      String result = sc.nextLine().trim();
      if (result.isEmpty()) {
        System.out.println("Cannot be empty");
        System.out.print("Input " + information + ": ");
      } else
        return result;
    }
  }

  public HashMap<String, List<Integer>> getNumber(String input) {
    HashMap<String, List<Integer>> numbersMap = new HashMap<>();
    List<Integer> allNumbers = new ArrayList<>();
    List<Integer> perfectSquareNumbers = new ArrayList<>();
    List<Integer> evenNumbers = new ArrayList<>();
    List<Integer> oddNumbers = new ArrayList<>();
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(input);
    while (m.find()) {
      allNumbers.add(Integer.parseInt(m.group()));
    }
    for (int number : allNumbers) {
      if (number % 2 == 0)
        evenNumbers.add(number);
      if (number % 2 != 0)
        oddNumbers.add(number);
      if (Math.sqrt(number) - Math.floor(number) == 0)
        perfectSquareNumbers.add(number);
    }
    numbersMap.put("Perfect Square Numbers: ", perfectSquareNumbers);
    numbersMap.put("Odd Numbers: ", oddNumbers);
    numbersMap.put("Even Numbers: ", evenNumbers);
    numbersMap.put("All Numbers: ", allNumbers);

    return numbersMap;
  }

  public void displayNumberMap(HashMap<String, List<Integer>> map) {
    for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
      System.out.println(entry.getKey() + entry.getValue());
    }
  }

  public HashMap<String, StringBuilder> getCharacter(String input) {
    HashMap<String, StringBuilder> charactersMap = new HashMap<>();
    StringBuilder allCharacters = new StringBuilder();
    StringBuilder upperCaseCharacter = new StringBuilder();
    StringBuilder lowerCaseCharacrer = new StringBuilder();
    StringBuilder specialCharacter = new StringBuilder();
    String[] charArr = input.split("\\d+");
    for (int i = 0; i < charArr.length; i++) {
      allCharacters.append(charArr[i]);
    }
    Pattern p = Pattern.compile("[^a-zA-Z0-9]+");
    Matcher m = p.matcher(input);
    while (m.find()) {
      specialCharacter.append(m.group());
    }
    for (int i = 0; i < allCharacters.length(); i++) {
      if (Character.isLowerCase(allCharacters.charAt(i)))
        lowerCaseCharacrer.append(allCharacters.charAt(i));
      if (Character.isUpperCase(allCharacters.charAt(i)))
        upperCaseCharacter.append(allCharacters.charAt(i));
    }

    charactersMap.put("Uppercase Characters: ", upperCaseCharacter);
    charactersMap.put("Lowercase Character: ", lowerCaseCharacrer);
    charactersMap.put("Special Character: ", specialCharacter);
    charactersMap.put("All Characters: ", allCharacters);

    return charactersMap;
  }

  public void displayCharacterMap(HashMap<String, StringBuilder> map) {
    for (Map.Entry<String, StringBuilder> entry : map.entrySet()) {
      System.out.println(entry.getKey() + entry.getValue());
    }
  }

  public static void main(String[] args) {
    AnalysisString program = new AnalysisString();
    System.out.println("===== Analysis String program ====");
    System.out.print("Input String: ");
    String string = program.checkInputString("String");
    System.out.println("-----Result Analysis------");
    program.displayNumberMap(program.getNumber(string));
    program.displayCharacterMap(program.getCharacter(string));

  }
}
