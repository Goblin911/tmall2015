package main;

import java.io.PrintStream;

import model.Model;
import data.DataReader;
import data.TrainUserData;
import evaluation.F1Evaluation;
import evaluation.Result;

public class Main {

	public static void main(String[] args) throws Exception {
		Configration.setConfigs(args);
		new DataReader("data\\");

		String trainEnd = "2014-12-19 00";
		if (Configration.debug) 
			trainEnd = "2014-12-18 00";
		
		TrainUserData.setTrainEndTime(trainEnd);
		
		Model model = (Model) Class.forName("model.RuleBased").newInstance();
		Result result = model.getResult();
		
		if (Configration.debug) {
			F1Evaluation eval = F1Evaluation.getInstance();
			double F1Score = eval.getF1Score(result);
			System.out.println("F1: "+F1Score+" precision: "+eval.getPrecision()+" recall: "+eval.getRecall());
		}
		PrintStream printer = new PrintStream("result.csv");
		result.dump(printer);
		printer.close();
	}
}
