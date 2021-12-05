import java.util.Scanner;
import java.io.*;

public class main
{

    public static void main(String[] args) throws IOException
    {
            Scanner scanner = new Scanner(System.in);
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.print("Name des Timers:");
            String name = scanner.nextLine();
            System.out.print("Dauer (xx:xx min):");
            String duration = scanner.nextLine();
            if (duration.matches("\\d{2}:\\d{2}") || duration.matches("\\d:\\d{2}"));
            else {
                System.out.println("You didn't use the right format");
                Thread.sleep(1000);
                main.main(null);
                return;
            }
            timer timer = new timer(name, duration);
            timer.start();
        }
        catch (Exception e) {
            System.out.print(e);
        }
    }
}