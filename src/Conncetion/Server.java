package Conncetion;

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
import Ip.Ip;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Arthur
 */
public class Server {

    private String SERVER_FOLDER = "C:\\Server\\";

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream inputStream;
    private FileOutputStream fileOutputStream;
    private BufferedOutputStream bufferedOutputStream;
    private int bufferSize;
    private String pathName;
    private String nome;
    private Ip ip;
    private int count;
    private byte[] bytes;

    /**
     *
     * @throws IOException
     */
    public void receive(Ip ip) throws IOException {
        serverSocket = null;
        socket = null;
        inputStream = null;
        fileOutputStream = null;
        bufferedOutputStream = null;
        bufferSize = 0;
        pathName = SERVER_FOLDER;
        nome = "";

        try {
            serverSocket = new ServerSocket(ip._porta_rede);
        } catch (IOException ex) {
            System.out.println("You can`t connect to the server on that port.");
        }

        try {
            socket = serverSocket.accept();
        } catch (IOException ex) {
            System.out.println("Connection refused.");
        }

        try {
            DataInputStream stream = new DataInputStream(socket.getInputStream());
            nome = stream.readUTF();

            inputStream = socket.getInputStream();
            bufferSize = socket.getReceiveBufferSize();
        } catch (IOException ex) {
            System.out.println("Streamming refused.");
        }

        try {
            fileOutputStream = new FileOutputStream(pathName + nome);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

        bytes = new byte[bufferSize];

        while ((count = inputStream.read(bytes)) > 0) {
            bufferedOutputStream.write(bytes, 0, count);
        }

        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
