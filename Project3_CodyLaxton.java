import java.util.Scanner;

public class Project3_CodyLaxton {

	public static void main(String[] args) {

		int patientAge[] = new int[5];
		int count = 0;
		int averageAge = 0;
		String userLastInput = "";
		String exitCommand = "x";
		String influenzaType[] = new String[5];
		
		Scanner sc=new Scanner(System.in);
		
		//initialize int array elements to 0
		for(int i = 0; i < patientAge.length; i++) {
			
			patientAge[i] = 0;
			
		}
		//initialize String array elements to a random character "z"
		for(int i = 0; i < influenzaType.length; i++) {
			
			influenzaType[i] = "";
			
		}
		
		System.out.println("Welcome to the Flu Tracker!");
		System.out.println("Type the name of the Influenza Type. (x to exit)");
		
		influenzaType[count] = sc.next();
		userLastInput = influenzaType[count];
		
		if(!userLastInput.equals(exitCommand)) {
			System.out.println("What is the age of the patient?");
			patientAge[count] = sc.nextInt();
		}
		
		//while the users last input is not equal to "x" continue collecting data
		while(!userLastInput.equals(exitCommand)) {
			
			count++;
			
			//check if array needs resizing
			if(count == influenzaType.length) {
				
				influenzaType = stringArrayResize(influenzaType);
				patientAge = intArrayResize(patientAge);
				
				//***FOR DEBUG PURPOSES***
				//System.out.println("Adjusting array size to:" + "\t" + patientAge.length);
				
			}
			
			System.out.println("Next Patient");
			System.out.println("Type the name of the Influenza Type. (x to exit)");
			
			influenzaType[count] = sc.next();
			userLastInput = influenzaType[count];
			
			//checks if user entered "x" so it can skip the following question if true
			if(!userLastInput.equals(exitCommand)) {
				
				System.out.println("What is the age of the patient?");
				patientAge[count] = sc.nextInt();
				
			}	//if(userLastInput...	
			
		}	//while(userLastInput...
		
		if(influenzaType[0].equals(exitCommand)) {

			System.out.println("Summary information:");
			System.out.println("There were: 0 cases of the Flu to summarize");
			
		}	//if(userLastInput...
		
		//Print out summary if the exit command is entered
		else if(userLastInput.equals(exitCommand)){
			
			averageAge = averageAge(patientAge, count);
			
			System.out.println("Summary information:");
			
			for(int i = 0; i < count; i++) {
				
				System.out.println("Type: " + influenzaType[i] + "\t Age: " + patientAge[i]);
				
			}
			
			System.out.println("There were: " + count + " cases of influenza with an average age of " + averageAge);
			
		}
		
		sc.close();
	}	//public static void main...
	
	
	
	
	public static int averageAge(int patientAge[], int count) {
		
		double ageSum = 0;
		
		for (int i = 0; i < patientAge.length; i++) {
			
			ageSum += patientAge[i];
			
		}
				
		return (int) Math.round(ageSum / count);
		
	}	//public static int averageAge...
	
	
	public static int[] intArrayResize(int patientAge[]) {
		
		int[] temp = new int[2 * patientAge.length];
		
		for(int i = 0; i < patientAge.length; i++) {
			
			temp[i] = 0;
			
		}
		
		for(int i = 0; i < patientAge.length; i++) {
			
			temp[i] = patientAge[i];
			
		}
		
		return temp;
		
	}	//public static int[]...
	
	
	public static String[] stringArrayResize( String influenzaType[]) {
		
		String[] temp2 = new String[2 * influenzaType.length];
		
		for(int i = 0; i < influenzaType.length; i++) {
			
			temp2[i] = "";
			
		}
		
		for(int i = 0; i < influenzaType.length; i++) {
			
			temp2[i] = influenzaType[i];
			
		}
		
		return temp2;
		
	}	//public static String[]...
	
}	//public class
