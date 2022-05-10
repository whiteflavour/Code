package com.google;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HelloClient {
    private static final Logger logger = LoggerFactory.getLogger(HelloClient.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        HelloClient helloClient = new HelloClient();
        Message message = (Message) helloClient.send(new Message("content from client"), "127.0.0.1", 6666);
        logger.info("client receives message: " + message.getContent());
    }

    public Object send(Message message, String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error("occurs exception: " + e);
        }
        return null;
    }
}
