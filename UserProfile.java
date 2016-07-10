package tester1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserProfile {

  int CurrentProfID = 0;
  HashMap<Integer, User> UserProfCache = new HashMap<Integer, User>();
  List<String> UserInfo = new ArrayList<String>();
  String[][] UserInfoArr; 

  public void Start(){	  	
	  LoadProfile();
	  int option;
	  System.out.println("main called");

	  System.out.println("----- UserProfile -----");
	  System.out.println("    1) View Current");
	  System.out.println("    2) Add Profile");
	  System.out.println("    3) Update");
	  System.out.println("    4) Delete");
	  
	  do{
  			//clearScreen();
  			Scanner input = new Scanner(System.in);
	  		option = input.nextInt();
	  		
	  		switch(option){
  					case 1:
  						//GetCurrentProf();
  						break;
	  				case 2:
	  					System.out.println("Type in: ID, Income, TaxRate");
	  					AddUser(1, 500.00, 0.5f);
	  					break;
	  				case 3:
	  					System.out.println("Update");
	  					break;
	  				case 4:
	  					System.out.println("Delete");
	  					break;
	  				case 0:
	  					break;
	  			}
  		}while(option != 0);
  }
	  
  public static void clearScreen() {
	  for (int i = 0; i < 50; ++i) System.out.println();
  }

  public void LoadProfile() {
	  
	  try {
          FileReader reader = new FileReader("UserInfoID1.txt");
          BufferedReader bufferedReader = new BufferedReader(reader);

          String line;

          while ((line = bufferedReader.readLine()) != null) {
        	  UserInfo.add(line);
              System.out.println(line);
          }
          reader.close();
          
          for (int i=0; i < UserInfoArr.length;i++){ 
    		  String[] array = UserInfoArr[i].toString().split("\\,", -1);

    		  for(int j=0; j<UserInfoArr[i].length; j++) {
    			  for(int k=0; k<array[i].length(); k++) {
    			  UserInfoArr[i][j] = array;
    		  }
    			  
          }
         
          int test = 1;
          
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  public void AddUser(int vID, double vIncome, float vTaxRate) {
	  User User = new User();
	  User.ID = vID;
	  User.Income = vIncome;
	  User.TaxRate = vTaxRate;

      writeToFile(User.getID(), User.getIncome(), User.getTaxRate(), "Current" , 1);

  }

  public void setCurrentProfile( Path from) throws IOException {
	  File file = new File("UserInfoIDCurrent.txt");
		String currentDirectory = file.getAbsolutePath();
		Path to = Paths.get(currentDirectory);
		
	    Files.copy( from, to );
  }
  
  public void cleanCurrentProfStatus(){
	  for (int i=0; i < UserInfoArr.length;i++){ 
		  for(int j=0; j<UserInfoArr[i].length; j++) {
			  String[] array = UserInfoArr[i].toString().split("\\,", -1);
		  }
	  } 
  }
  
  public void getCurrentProfID(){
	  for (int i=0; i < UserInfoArr.length;i++){ 
		  String[] array = UserInfoArr[i].toString().split("\\,", -1);
		  if (array[i].toString().)
		  for(int j=0; j<UserInfoArr[i].length; j++) {
			  
		  }
	  }
  }
  
  public void writeToFile(int vID, double vIncome, float vTaxRate, String status, int Option ){
	  Charset utf8 = StandardCharsets.UTF_8;
	  List<String> lines = Arrays.asList(status + Integer.toString(vID) + "," + Double.toString(vIncome) + "," + Float.toString(vTaxRate));

	  String currentDirectory;
	  File file = new File("UserInfoID" +  Integer.toString(vID) + ".txt");
	  currentDirectory = file.getAbsolutePath();
	  System.out.println("Current working directory : "+currentDirectory);
	  
	  Path fileP = Paths.get(currentDirectory);
	  try {
		if (Option == 0) //replace current
			Files.write(fileP, lines, utf8);
		if (Option == 1) //add new one
			Files.write(Paths.get("UserInfo2.txt"), lines, utf8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public void Update(int ID, double vIncome, float vTaxRate) {
 
  }
  
  public void Delete(int ID) {

  }
  
}
