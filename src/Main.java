import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("Enter c for Client or s for Server");

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		if(input.toLowerCase().equals("c")) {


			System.out.println("Client");

			Client client = new Client("127.0.0.1", 4445);
			client.runClient();
		}
		else if(input.toLowerCase().equals("s")){

			System.out.println("Server");

			Server server = new Server(4445);
			server.runServer();

		}

	}

}