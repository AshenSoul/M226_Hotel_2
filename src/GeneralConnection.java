import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public abstract class GeneralConnection {

    public Socket clSocket;
    public BufferedReader reader;
    public PrintWriter printer;
//    public OutputStream outstream;
//    public InputStreamReader instream;
    public String inputString, outputString;
    public int port;

}
