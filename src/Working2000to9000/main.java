package Working2000to9000;

import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class main {

    public static void main(String args[]){


        Thread driver = null;

        System.out.println("Who are you?");
        System.out.println("    - C: I'm a client!");
        System.out.println("    - S: I'm a server...");
        Scanner scnr  = new Scanner(System.in);

        String input = scnr.next();

        if(input.compareTo("C") == 0 || input.compareTo("c") == 0){
            //Add random number for ip address configuration
            System.out.println("Whats your name?");
            String name = scnr.next();
            System.out.println("Starting interrogation!");
            driver = new Thread(new Client("127.0.0.1",9000, name));
        }

        if(input.compareTo("S") == 0 || input.compareTo("s") == 0){

            driver = new Thread(new Listener(9000, 100));

        }

        driver.start();

        try {
            driver.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
