import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends GeneralConnection{

	private ServerSocket servSocket;

	public Server(int port){
		this.port = port;

	}
	public void runServer(){
		
		boolean run = true;
		
		try {

			servSocket = new ServerSocket(port);
			clSocket = servSocket.accept();
			printer = new PrintWriter(clSocket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(clSocket.getInputStream()));

			//Unit Test: Connection
			inputString = reader.readLine();
			System.out.println("Client: "+inputString);

			if(inputString != null) {

				printer.println("Success");
				printer.flush();
			}
			//end

			while(run){

				if(reader.ready()){

					inputString = reader.readLine();
					System.out.println("Client: "+inputString);

					Scanner scanner = new Scanner(System.in);
					outputString = scanner.nextLine();

					printer.println(outputString);
					printer.flush();
					outputString = null;
				}
				if (inputString.equals("bye")) {

					printer.println("bye");
					printer.flush();

					System.out.println("Server: " + inputString);

					run = false;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Client is not available");
		}



	}

}