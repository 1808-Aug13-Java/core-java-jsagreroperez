package ProjectZero.src.com.revature.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class credentials {
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private int accountBalance;
	private boolean loggedIn;
	private int accountNumber;
	
	
	public credentials() {
		super();
		// TODO Auto-generated constructor stub
	}





	public credentials(String username, String password, String firstName, String lastName, int accountBalance,
			boolean loggedIn) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountBalance = accountBalance;
		this.loggedIn = loggedIn;
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}





	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}





	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountBalance;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (loggedIn ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		credentials other = (credentials) obj;
		if (accountBalance != other.accountBalance)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (loggedIn != other.loggedIn)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}





	@Override
	public String toString() {
		return "credentials [username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", accountBalance=" + accountBalance + ", loggedIn=" + loggedIn + "]";
	}


	public boolean logIn(String username, String password) {
		this.loggedIn = ((this.username.equals(username)) && (this.password.equals(password))) ? true:false;
		return this.loggedIn;
	}
	
	public boolean logOut(credentials  user) {
		user.loggedIn = false;
		return user.loggedIn;
	}
	
	public void depositMonies(int deposit) {
		this.accountBalance += deposit;
		System.out.println("Your new account balance is: " + this.accountBalance);
	}
	
	public void withdrawMonies(int withdrawal) {
		this.accountBalance-=withdrawal;
		System.out.println("Your new account balance is: " + this.accountBalance);
		
	}
	
	public void viewBalance(credentials user) {
		System.out.println("Your current account balance is: " + user.accountBalance);
	}
	
	
	
	
	
	public boolean validateUser(String usrName, String psw) {
		String usr = new String();
		String passw = new String();
		String holder = new String();
		boolean check = false;
		try {
		//	FileReader fileReader = new FileReader("src/com/revature/bank/Database.txt");
			URL url = getClass().getResource("Database.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader(url.getPath()));
			while(((holder = bufferedReader.readLine()) != null) && (check == false) ) {
				//System.out.println(holder);
				String[] tokens = holder.split(" ");
				usr = tokens[0];
			//	System.out.println(usr);
				passw = tokens[1];
			//	System.out.println(passw);
				usrName = usrName.replaceAll(" ", "");
				psw = psw.replaceAll(" ", "");
				if(passw.equals(psw) && usr.equals(usrName)) {
					this.username = tokens[0];
					this.password = tokens[1];
					this.firstName = tokens[2];
					this.lastName = tokens[3];
					this.accountBalance = Integer.parseInt(tokens[4]);
					this.accountNumber = Integer.parseInt(tokens[5]);
					this.loggedIn = true;
				}
				check = (passw.equals(psw) && usr.equals(usrName)) ? true:false;
				
			}
			bufferedReader.close();
			
		}
		catch(FileNotFoundException ex) {
			//Stack Trace is a list of method calls from the point when the application was started to the point where the exception was thrown. The most recent method calls are at the top
			ex.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(check == false)
				System.out.println("Invalid Username and/or Password.");
			return check;
			
		}
	
	
	
	
	
	
	public int getAccountNumber() {
		return accountNumber;
	}





	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}





	public String input() {
		Scanner data = new Scanner(System.in);
		return data.nextLine();
	}
	
	
	
	
	
	
	public boolean checkFile( ) { // returns false if empty
		boolean check = false;
		try {
			URL url = getClass().getResource("Database.txt");
			//FileReader fileReader = new FileReader("src/com/revature/bank/Database.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader (url.getPath()));
			check = (bufferedReader.readLine() == null)? true:false;
			bufferedReader.close();
			
		}
			catch(FileNotFoundException ex) {
				//Stack Trace is a list of method calls from the point when the application was started to the point where the exception was thrown. The most recent method calls are at the top
				ex.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return check;
			}
	
	
	
	
	
	public boolean validPassword(String pswrd) {
		Scanner input = new Scanner(pswrd);
		String pswrdNew = input.next();
		if(pswrdNew.length() < 6)
		{
			System.out.println("That is an invalid password");
			return false;
		}
		else if(input.hasNext()) {
			if(!(input.nextLine().replaceAll(" ", "").equals("") ) ) {
				
				System.out.println("That is an invalid password");
				return false;
			}
			else
				return true;
		}
		else
			return true;
		
	} 
	
	
	
	

	
	
	
	
	// check is the email is already in the system and return true if the email is in the system
	public boolean newUser(String input, String psw) {
		String usr = new String();
		String holder = new String();
		boolean check = false;
		int num = 1;
		if(!this.checkFile()) {
		try {
			//FileReader fileReader = new FileReader("src/com/revature/bank/Database.txt");
			URL url = getClass().getResource("Database.txt");
			BufferedReader bufferedReader = new BufferedReader(new FileReader(url.getPath()));
			while(((holder = bufferedReader.readLine()) != null) && (check == false) ) {
				String [] tokens = holder.split(" ");
				System.out.println(holder = bufferedReader.readLine());
				usr = tokens[0];
				num +=1;
				check = (usr.equals(input)) ? true:false;
			}
			
			bufferedReader.close();
			
		}
		catch(FileNotFoundException ex) {
			//Stack Trace is a list of method calls from the point when the application was started to the point where the exception was thrown. The most recent method calls are at the top
			ex.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			check = false;
		}
		
		if(check == true)
			System.out.println("Email is already in the System, in order to open a new account, please use another email address.");
		else {
			System.out.println("Thank you for opening an account with us today!\n Please enter your first name:");
			String neam = this.input();
			System.out.println("Please enter your last name: ");
			String lastNeam = this.input();
			neam = neam.replaceAll(" ", "");
			lastNeam = lastNeam.replaceAll(" ", "");
			FileWriter fileWriter;
			try {
				URL url = getClass().getResource("Database.txt");
				//(format of database) username, String password, String firstName, String lastName, int accountBalance,
				fileWriter = new FileWriter(url.getPath(), true);// use append constructor so that the file is not erased when opening
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.append(input + " "+ psw +" " + neam + " " + lastNeam + " " + 0 +" " + num +"\n");
				bufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		return check;
		}
	public int number(String message) {
		Scanner blah = new Scanner (System.in);
		int num;
		System.out.println(message);
			
		while(!(blah.hasNextInt())) {

			System.out.println("Please enter a valid integer");
			System.out.println(message);
			blah.nextLine();
		}
		num = blah.nextInt();
		return num;
	}
	
	public void loggout(int lineNumber, String data) {
		URL url = getClass().getResource("Database.txt");
	    File fileToBeModified = new File(url.getPath());
	    String oldContent = "";
	    BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));
			 String line = reader.readLine();
			    int count = 1;
			    
			    while(line != null) {
			    	if(lineNumber == count) {
			    		oldContent = oldContent + data;
			    	}
			    	else
			    		oldContent = oldContent + line + System.lineSeparator();
			    	line = reader.readLine();
			    	count += 1;
			    }
			    FileWriter writer = new FileWriter(fileToBeModified);
			    writer.write(oldContent);
			    reader.close();
			    writer.close();
			    this.setLoggedIn(false);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	}



