package Working2000to9000;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Server implements Runnable{

    private Socket clientConnection;

    public Server(Socket c){
        clientConnection = c;
    }

    @Override
    public void run() {


        try {
            while(true) {
                DataInputStream in = new DataInputStream(clientConnection.getInputStream());
                DataOutputStream out = new DataOutputStream(clientConnection.getOutputStream());
                String s = in.readUTF();
                if(s.compareTo("Quit") == 0){
                    break;
                }
                System.out.println("He tells me: " + s);
                out.writeUTF("There is no excuse!");

            }
            clientConnection.close();
        } catch (IOException e) {
            System.out.println("Error in Server " + e.getMessage());
        }


    }
}
