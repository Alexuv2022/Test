package lesson15.dz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Main2 {

    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C://java/ip.txt");
            int i;
            String result = "";
            while ((i = fin.read()) != -1) {
                if (i == 13) {
                    continue;
                } else if (i == 10) {
                    String ip = result.split(":")[0];
                    int port = Integer.parseInt(result.split(":")[1]);
                    MyThread thread = new MyThread(ip, port);
                    thread.start();
                    result = "";
                } else if (i == 9) {
                    result += ":";
                } else {
                    result += (char) i;
                }

            }
            System.out.print(result);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class MyThread extends Thread {
    String ip;
    int port;

    public MyThread(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        checkProxy(ip, port);
    }
    public void checkProxy(String ip, int port) {
        System.out.println("Запрос к серверу с " + ip + ":" + port);

        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection connection = url.openConnection(proxy);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println("ip: " + ip + " port: " + port + " - РАБОТАЕТ!");
            proxyToFile(ip + ":" + port);
        } catch (Exception e) {
            System.out.println("ip: " + ip + " port: " + port + " - Не работает!");
        }
    }

    public void proxyToFile(String result) {
        try {
            FileOutputStream fos = new FileOutputStream("C://java/even_proxy.txt", true);
            String text = result + "\n";
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}