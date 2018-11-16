import java.util.*;

public class ThePasswordGenerator{
	public static void main( String[] args ){
		Scanner input = new Scanner( System.in );
		int[] userInput = new int[ 2 ];

		System.out.print( "\nHello user! How many passwords would you like?\t" );
		userInput[ 0 ] = input.nextInt();	//sets desired number of passwords to index 0

		System.out.print( "How many characters long would you like each password to be?\t" );
		userInput[ 1 ] = input.nextInt();	//sets size of password to index 1

		generatePasswords( userInput );
	}


	public static void generatePasswords( int[] passwordSpecifics ){
		Random randomBoolean = new Random();
		int generatedInteger = 0;	//place holder dont think i need
		String[] capdPasswords = new String[ passwordSpecifics[ 0 ] ];	//sets array size to number of passwords desired
		String[] alphabet = { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" , "i" , "j" , "k" ,
							  "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" , "u" , "v" ,
							  "w" , "x" , "y" , "z" , "A" , "B" , "C" , "D" , "E" , "F" , "G" ,
							  "H" , "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" ,
							  "S" , "T" , "U" , "V" , "W" , "X" , "Y" , "Z" };
		
		for( int a = 0 ; a < passwordSpecifics[ 0 ] ; a++ ){
			capdPasswords[ a ] = "";
			for( int b = 0 ; b < passwordSpecifics[ 1 ] ; b++ ){	//loop generates password String
				if( randomBoolean.nextBoolean() ){	//determines  wheter character will be number or letter
					capdPasswords[ a ] += ( int ) (Math.random() * 9 );	//generates digit 0 to 9
				}
				else{
					generatedInteger = ( int ) ( Math.random() * 51 );	//determines index of alphabet to be used
					capdPasswords[ a ] += alphabet[ generatedInteger ];	//concatenates individual password characters
				}
			}

			passwordToScreen( capdPasswords[ a ] , a );	//passes the generated password and counter a
		}
		verificationCheck( capdPasswords , passwordSpecifics[ 0 ] );
	}


	public static void passwordToScreen( String password , int counter ){
		if( counter == 2){ System.out.println( password + "\tand" ); }
		else{ System.out.println( password ); }
	}


	public static void verificationCheck( String[] passwords , int numberOfPasswords ){	//checks that user enters proper password
		Scanner captureInput = new Scanner( System.in );
		String keyboardInput;
		boolean testPassword;

		System.out.print( "Would you like to verify your new password(s)? [Y/N]\t" );
		keyboardInput = captureInput.next();

		if( keyboardInput.equalsIgnoreCase( "y" ) ){ passwordVerification( passwords , numberOfPasswords ); }
		else{ System.out.println( "Okay! Goodbye!\n" ); }
	}


	public static void passwordVerification( String[] generatedPasswords , int numberOfPasswords ){
		Scanner passwordEntry = new Scanner( System.in );
		String passwordEntered;

		for( int a = 0 ; a < numberOfPasswords ; a++ ){
			System.out.print( "Enter your password:\t" );
			passwordEntered = passwordEntry.next();

			while( !passwordEntered.equals( generatedPasswords[ a ] ) ){
				System.out.println( "You have not entered the correct password. Please try again!" );
				passwordEntered = passwordEntry.next();
			}

			System.out.println( "Great! You entered the correct password!\n" );
		}
	}
}