package Conncetion;

/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
import Ip.Ip;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Arthur
 */
public class Client {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private FileInputStream fileInputStream;
    private byte[] bytes;
    private BufferedInputStream bufferedInputStream;
    private BufferedOutputStream bufferedOutputStream;
    private int count;

    /**
     *
     * @param file
     * @throws IOException
     */
    public void send(File file,Ip ip) throws IOException {          
        socket = new Socket(ip.getIp_rede_local(), ip.getPorta_rede());

        // Send file name
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(file.getName());
        dataOutputStream.flush();

        // Send file 
        fileInputStream = new FileInputStream(file);
        bytes = new byte[fileInputStream.available()];
        bufferedInputStream = new BufferedInputStream(fileInputStream);
        bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        while ((count = bufferedInputStream.read(bytes)) > 0) {
            bufferedOutputStream.write(bytes, 0, count);
        }
        bufferedOutputStream.flush();

        // Close all conections        
        bufferedOutputStream.close();
        fileInputStream.close();
        bufferedInputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}
