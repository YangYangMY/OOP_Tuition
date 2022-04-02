/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuition;

/**
 *
 * @author Wee Yan
 */
public class Screen {
  public static void clear() {
    try {
      String operatingSystem = System.getProperty("os.name"); // Check the current operating system

      if (operatingSystem.contains("Windows")) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        Process startProcess = pb.inheritIO().start();
        startProcess.waitFor();
      } else {
        ProcessBuilder pb = new ProcessBuilder("clear");
        Process startProcess = pb.inheritIO().start();

        startProcess.waitFor();
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public static void pause(float seconds) {
    int miliSeconds = (int)(seconds * 1000);
    try {
      Thread.sleep(miliSeconds);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
