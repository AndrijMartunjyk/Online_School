package server;

import online_school.log.Log;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

    public void client() throws IOException, InterruptedException {
        Thread.sleep(1000);
        try {
            clientSocket = new Socket("localhost", Server.PORT);
            while (true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Введіть запис тут:");
                String word = reader.readLine();
                out.write(word + "\n");
                out.flush();
                String serverWord = in.readLine();
                System.out.println(serverWord);
            }
        } catch (IOException e) {
            System.err.println("Client was closed...");
            Log.error(Client.class.getName(), "IOException", e.getMessage());
        } finally {
            clientSocket.close();
            in.close();
            out.close();
        }
    }

    @Override
    public void run() {
        try {
            client();
        } catch (IOException | InterruptedException e) {
            Log.error(Client.class.getName(), "IOException | InterruptedException", e.getMessage());
        }
    }
}
