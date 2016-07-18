
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
  String[][] UserInfoNestedArr = new String[2][4]; //2 profiles, 4 user details

  public void Start(){	  	
	  LoadProfile();
	  int option;
	  System.out.println("main called");

	  System.out.println("----- UserProfile -----");
	  System.out.println("    1) View Current");
	  System.out.println("    2) Add Profile");
	  System.out.println("    3) Update");
	  System.out.println("    4) Delete");
	  System.out.println("    5) Exit Profile");
	  
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
	  				case 5:
	  					System.out.println("Exit");
	  					return;
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
		  //if (new File("C:/data/datafile.txt").exists())
          FileReader reader = new FileReader("UserInfoID1.txt");
          BufferedReader bufferedReader = new BufferedReader(reader);
          List<String> AllUserInfo = new ArrayList<String>();
          String[] separatedUserInfo = new String[4];
          String line;
          //int numbOfLine = 0;
          while ((line = bufferedReader.readLine()) != null) {
        	  AllUserInfo.add(line);
        	  //numbOfLine++;
              System.out.println(line);
          }
          reader.close();
          // If you want to convert to a String[]
          String[] Profiles  = AllUserInfo.toArray(new String[AllUserInfo.size()]);
          
          for (int i=0; i < Profiles.length; i++){ 
    		  separatedUserInfo = Profiles[i].toString().split("\\,", -1);
			  for(int j=0; j<separatedUserInfo.length; j++) {
				  UserInfoNestedArr[i][j] = separatedUserInfo[j].toString();
				  if ((CurrentProfID==0) && (j==0) && (separatedUserInfo[j].equals("1"))){
					  setCurrentProfileID(Integer.valueOf(separatedUserInfo[1].toString()));
				  }
    		  }
	      }
          return;
	  }catch (IOException e) {
		  //create one
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
  
  public void setCurrentProfileID(int ProfID){
	  CurrentProfID = ProfID;
  }
  
  public int getCurrentProfileID(){
	  return CurrentProfID;
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
		
		//create current profile
		//setCurrentProfile(fileP);
		if (Option == 1) //add new one
			Files.write(fileP, lines, utf8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
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