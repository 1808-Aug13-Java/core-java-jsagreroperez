package ProjectZero.src.com.revature.bank;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class bankApp {
	//private static Logger Log = Logger.getAnonymousLogger();
	static credentials defaultUser = new credentials();
	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		Display menu = new Display();
		int userInput = -1;
		boolean check = false;
		do {
			do
			{
				menu.loginMenu();
				
				while(!(input.hasNextInt())) {

					System.out.println("Please enter a valid integer");
					menu.loginMenu();
					input.nextLine();

				}
				userInput = input.nextInt();
				if((userInput == 1) && (defaultUser.checkFile()))
				{
					System.out.println("There are no users registered at this bank!\n Please enroll by choosing option 2.");
					userInput = -1;
				}
			}while((userInput < 0) || (userInput > 2));
			input.nextLine();//clear buffer
			
			switch (userInput) {
			case 2: {
				boolean checkNewUser =false, createUserName  =false, createPassword = false;
				String newusrName = new String();
				String psw = new String();
				System.out.println("Hello, and Thank you for choosing Blah Banking.");
				do {
					do {
						System.out.println("Please enter a valid Email ( It will serve as your Username ) : ");
						newusrName = input.nextLine();
					} while(!defaultUser.validPassword(newusrName));
					newusrName = newusrName.replaceAll(" " , "");
					do {
						System.out.println("Please enter your Password ( Must be at least 6 characters long) : ");
						psw = input.nextLine();
						
						
					} while(!defaultUser.validPassword(psw));
					psw = psw.replaceAll(" ", "");
					
					createUserName = defaultUser.newUser(newusrName, psw); // returns true if successfully in creating account
				}while(createUserName == true);
				//after user successfully enters valid credentials and creates a new account fall down to case 1 since they must validate their credentials to ensure both parties agree on the login credentials chosen,
				System.out.println("Please validate your new account by entering your login credentials.\n");
			}
			case 1: {
				String usrName = new String();
				String psw = new String();
				check = false;
				if(defaultUser.checkFile()) {
					System.out.println("There are no users registered at this bank!\n Please enroll by choosing option 2.");
					break;
				}
				do {
					System.out.println("Please enter your Username: ");
					usrName = input.nextLine();
					System.out.println("Please enter your Password: ");
					psw = input.nextLine();
					check = defaultUser.validateUser(usrName, psw);
					
				}while(check == false);
				
				
				userInput = -1;
				do {
					do
					{
						menu.mainMenu();
						
						while(!(input.hasNextInt())) {
							input.nextLine();
							System.out.println("Please enter a valid integer");
							menu.loginMenu();

						}
						userInput = input.nextInt();
					}while((userInput < 0) || (userInput > 3));
					//clean stream since we parsed an integer, maybe the user entered a space in there :o ?
					input.nextLine();
					switch(userInput) {
					
						case 1: {
							int num = defaultUser.number("How much would you like to deposit?");
							defaultUser.depositMonies(num);
							//deposit
							break;
						}
						case 2: {
							int num = defaultUser.number("How much would you like to withdraw?");
							defaultUser.withdrawMonies(num);
							//withdrawal
							break;
						}
						case 3: {
							defaultUser.viewBalance(defaultUser);
							//view balance
							break;
						}
						case 0: {
							//loggout and exit
							break;
						}
					}
						
						
			}while(userInput != 0);
				System.out.println("Logging you out...");
				defaultUser.loggout(defaultUser.getAccountNumber(), new String(defaultUser.getUsername()+" "+ defaultUser.getPassword()+ " " + defaultUser.getFirstName()+ " "+ defaultUser.getLastName()+ " "+ defaultUser.getAccountBalance() + " " + defaultUser.getAccountNumber()+ "\n"));
			}
			case 0: {
				
			}
				}
		
	}while(userInput != 0);
		System.out.println("Loggout complete, have a nice day.");

}
}
