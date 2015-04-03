package main;

public class Configration {
	public static boolean debug;
	public static void setConfigs(String[] args){
		for(String arg: args){
			if (arg.equals("-debug"))
				debug = true;
			
		}
	}
}
