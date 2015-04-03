package main;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

import data.DataReader;
import data.TrainUserData;
import data.UserBehavior;

public class Query {
	public static void main(String[] args) throws Exception {
		DataReader reader = new DataReader("data\\");

		Scanner s = new Scanner(System.in); 
        System.out.println("Input Query:"); 
        while (true) { 
            String line = s.nextLine(); 
            if (line.equals("exit")) break; 
            if (line.startsWith("user")){
            	String[] arr = line.split(" ");
            	if (arr.length == 2){
            		int userId = Integer.parseInt(arr[1]);
            		LinkedList<UserBehavior> bhvs = TrainUserData.queryUser(userId);
            		if (bhvs==null) System.out.println("No records found!");
            		else {
            			PrintStream printer = new PrintStream("result.txt");
            			for(UserBehavior bhv: bhvs) printer.print(bhv);
            			printer.close();
            			System.out.println("Result has been output to 'result.txt'!");
            		}
            	}
            }
        } 
	}
}
