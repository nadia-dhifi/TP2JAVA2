package exercie;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CustomProcessBuilder {
    public static void main(String[] args) {
        List<String> commands = new ArrayList<>();
        commands.add("cmd.exe");
        commands.add("/c");
        commands.add("dir");
        commands.add("/b");
        try {
            ProcessBuilder processBuilder =new ProcessBuilder(commands);
            Process p=processBuilder.start();
            Scanner s= new Scanner(p.getInputStream());
            while(s.hasNextLine())
                System.out.println(s.nextLine());
            System.out.println("Error of Stream");
            Scanner s1 =new Scanner(p.getErrorStream());
            while(s1.hasNextLine())
                System.out.println(s1.nextLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }