package Working2000to9000;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{

    private String ip;
    private int port;
    Socket con;
    DataInputStream in;
    DataOutputStream out;
    String clientID;

    String message;

    Client(String i, int p, String name) {


        ip = i;
        port = p;
        clientID = name;

        try {
            con = new Socket(ip,port);
            in = new DataInputStream(con.getInputStream());
            out = new DataOutputStream(con.getOutputStream());

            System.out.println("GNU connection!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void run() {
        while(con.isConnected()) {
            Scanner scnr = new Scanner(System.in);
            System.out.println("What do you have to say for yourself?");
            message = scnr.nextLine();
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
