package server;

import online_school.log.Log;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    public static final int PORT = 4004;
    private ServerSocket server;
    private BufferedReader in;
    private BufferedWriter out;
    private boolean isPresent = false;

    public void server() throws IOException {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запустився!");
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Address of client: " + clientSocket.getLocalSocketAddress());
                while (!reader(clientSocket)) {
                    System.out.println("Welcome");
                    do {
                        isPresent = false;
                        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        String word = in.readLine();
                        out.write("Привіт, це Сервер! Підтверджую, ви написали : " + word + "\n");
                        out.flush();
                    } while (!isPresent);
                }
                if (reader(clientSocket)) {
                    System.out.println("IP address in black list!!!");
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            Log.error(Server.class.getName(), "IOException", e.getMessage());
        } finally {
            System.out.println("Сервер закритий!");
            server.close();
            in.close();
            out.close();
        }
    }

    private boolean reader(Socket clientSocket) {
        boolean isPresentReader = false;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("directory_with_Black_IP/List of black IP.txt"))) {
            String ipAddressOfClient = String.valueOf(clientSocket.getLocalAddress());
            String blackIp;

            while ((blackIp = bufferedReader.readLine()) != null) {
                if (blackIp.contains(ipAddressOfClient)) {
                    isPresentReader = true;
                    break;
                }
            }
        } catch (Exception e) {
            Log.error(Server.class.getName(), "Exception", e.getMessage());
        }
        return isPresentReader;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    @Override
    public void run() {
        try {
            server();
        } catch (IOException e) {
            Log.error(Server.class.getName(), "method \"run\"", e.getMessage());
        }
    }
}

