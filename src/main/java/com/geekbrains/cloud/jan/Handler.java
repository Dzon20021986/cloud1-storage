package com.geekbrains.cloud.jan;

import java.io.*;
import java.net.Socket;

public class Handler implements Runnable {
    DataInputStream is;
    DataOutputStream os;

    public Handler(Socket socket) throws IOException, ClassNotFoundException {
        is = new DataInputStream(socket.getInputStream());
        os = new DataOutputStream(socket.getOutputStream());

        TransferFileObject file = new TransferFileObject("tag", "file");
        System.out.println(file);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data/file.txt"));
        os.writeObject(file);

        ObjectInputStream is = new ObjectInputStream(new FileInputStream("data/file.txt"));
        TransferFileObject file1 =(TransferFileObject)is.readObject();
        System.out.println(file1);

    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = is.readUTF();
                System.out.println("received: " + message);
                os.writeUTF(message);
                os.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
