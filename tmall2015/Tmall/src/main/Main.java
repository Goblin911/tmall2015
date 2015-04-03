package main;

import model.Model;
import data.DataReader;
import evaluation.Result;

public class Main {
	public static String trainEnd = "2014-12-18";
	public static void main(String[] args) throws Exception {
		DataReader reader = new DataReader("data\\");
		
		
		Model model = (Model) Class.forName("model.RuleBased").newInstance();
		Result result = model.getResult();
		
	}
}
