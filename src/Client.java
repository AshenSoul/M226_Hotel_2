import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client extends  GeneralConnection{

	private String hostName;


	public Client(String hostName, int port){
		this.hostName = hostName;
		this.port = port;
	}
	public void runClient() {

		boolean run = true;

		try {

			clSocket = new Socket(hostName, port);
			printer = new PrintWriter(clSocket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(clSocket.getInputStream()));

			printer.println("Success");
			printer.flush();

			while (run) {

				Scanner scanner = new Scanner(System.in);
				outputString = scanner.nextLine();


				printer.println(outputString);
				printer.flush();

				if (reader.ready()) {
					inputString = reader.readLine();
					System.out.println("Server: " + inputString);
				}

				if (inputString != null && inputString.equals("bye")) {

					printer.println("bye");
					printer.flush();

					System.out.println("Server: " + inputString);

					run = false;
					scanner.close();
				}

			}


		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Server not available");
		}
		


	}
}