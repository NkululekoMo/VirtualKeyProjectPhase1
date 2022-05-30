package org.example.virtualkey.screens;

import org.example.virtualkey.services.DirectoryService;
import org.example.virtualkey.services.ScreenService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeScreen implements Screen {
	
	private String star = "*********************************************";
    private String welcome = "WELCOME TO VIRTUAL KEY REPOSITORIES!";
    private String developer = "Developer: Nkululeko Mokoena";
    private String company = "Company: SimpliLearn";
    private String country = "Country: South Africa";

    private ArrayList<String> options = new ArrayList<>();


    public WelcomeScreen() {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");

    }
    
    public void Welcome() {
    	System.out.println(star);    
    	System.out.println(welcome);
        System.out.println(developer);
        System.out.println(company);
        System.out.println(country);
        System.out.println("*********************************************");
        Show();
    }
    
    
    
    @Override
    public void Show() {
    	System.out.println("MAIN MENU");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: 
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: 
            	ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Wrong Option");
                break;
        }
        
    }

    public void ShowFiles() {

        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task

        System.out.println("LIST OF FILES: ");
    	DirectoryService.PrintFiles();

    }
    
    private int getOption() {
        Scanner scan = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = scan.nextInt();
        }
        catch (InputMismatchException exe) {

        }
        return returnOption;

    }
}
