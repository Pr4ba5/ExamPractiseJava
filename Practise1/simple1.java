package practiseQuestoin1;

import java.util.HashMap;
import java.util.Scanner;

public class simple1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    HashMap<String, String> usersMembers = new HashMap<>();
    usersMembers.put("Prabhash", "Prabhas13");
    usersMembers.put("Prasanna", "Prasanna12");
    usersMembers.put("Saniya", "saniya12");

    System.out.print("Enter username: ");
    String username = sc.nextLine();

    System.out.print("Enter your password: ");
    String password = sc.nextLine();
    sc.close();

    try {
      if (!usersMembers.containsKey(username)) {
        throw new MemberNotRegisteredException(
          "Sorry you're not registered yet."
        );
      }
      String StoredPassword = usersMembers.get(username);
      if (!StoredPassword.equals(password)) {
        throw new AccessDeniedException("Sorry access denied wrong password.");
      }
      System.out.println("Successfully logined, enjoy your");
    } catch (MemberNotRegisteredException | AccessDeniedException ex) {
      System.err.println("Login Failed: " + ex.getMessage());
    }
  }
}
