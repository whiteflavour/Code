package com.google;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    private static final Logger logger = LoggerFactory.getLogger(HelloServer.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        HelloServer helloServer = new HelloServer();
        helloServer.start(6666);
    }

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                logger.info("client connected");
                try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    Message message = (Message) objectInputStream.readObject();
                    logger.info("server receive message: " + message.getContent());
                    message.setContent("new content");
                    objectOutputStream.writeObject(message);
                    objectOutputStream.flush();
                } catch (ClassNotFoundException e) {
                    logger.error("occur exception: " + e);
                }
            }
        } catch (IOException e) {
            logger.error("occur exception: " + e);
        }
    }
}
