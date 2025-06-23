package practise3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Practise3 {

  public static void main(String[] args) {
    String mealChoice = "practise3/MealChoices.txt";
    String NonVegList = "practise3/NonVegList.txt";
    int StudentVeg = 0;
    int StudentNonveg = 0;

    try (
      BufferedReader bfr = new BufferedReader(new FileReader(mealChoice));
      BufferedWriter bfw = new BufferedWriter(new FileWriter(NonVegList))
    ) {
      String line;
      while ((line = bfr.readLine()) != null) {
        line = line.trim();
        if (line.isEmpty()) continue;

        String[] token = line.split(",");
        if (token.length < 2) {
          throw new IncompleteDataException("Incomplete data: " + line);
        }

        String name = token[0].trim();
        String choice = token[1].trim();

        if (choice.equalsIgnoreCase("veg")) {
          StudentVeg++;
        } else if (choice.equalsIgnoreCase("non-veg")) {
          StudentNonveg++;
          bfw.write(line); // Only write the name
          bfw.newLine();
        }
      }
    } catch (IncompleteDataException ex) {
      System.err.println("Error: " + ex.getMessage());
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    System.out.println("Total number of veg student: " + StudentVeg);
    System.out.println("Total number of non-veg student: " + StudentNonveg);
  }
}
