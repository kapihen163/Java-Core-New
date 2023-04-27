package Lesson6_Class.Lesson6;

//        1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
//        пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
//        2. Подобрать источник самостоятельно. Можно использовать api accuweather, порядок следующий:
//        зарегистрироваться, зарегистрировать тестовое приложение для получения api ключа,
//        найдите нужный endpoint и изучите документацию. Бесплатный тарифный план предполагает
//        получение погоды не более чем на 5 дней вперед (этого достаточно для выполнения д/з).

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен и ожидает соединения...");

            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключен!");

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true){
                String clientRequest = dataInputStream.readUTF();
                if ("end".equals(clientRequest)) break;

                System.out.println("Получили строчку" + clientRequest);
                dataOutputStream.writeUTF("Сервер отвечает" + clientRequest);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}