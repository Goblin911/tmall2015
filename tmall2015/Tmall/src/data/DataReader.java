package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.LinkedList;

public class DataReader {
	String dir = "";
	int userLine;
	int itemLine;

	public DataReader(String dir) {
		this.dir = dir;
		read();
	}

	private void read() {
		try {
			{
				BufferedReader reader = new BufferedReader(new FileReader(dir
						+ "tianchi_mobile_recommend_train_item.csv"));
				String line = reader.readLine();
				while ((line = reader.readLine()) != null) {
					TrainItemData.addItemInfo(line);
					itemLine++;
				}
				reader.close();
				System.out.println("Item Line: " + itemLine);
				System.out.println("Item Num: " + TrainItemData.map.size());

			}
			{
				BufferedReader reader = new BufferedReader(new FileReader(dir
						+ "tianchi_mobile_recommend_train_user.csv"));
				String line = reader.readLine();

				while ((line = reader.readLine()) != null) {
					UserBehavior bhv = TrainUserData.addBehavior(line);
					if (TrainItemData.checkItem(bhv.itemId))
						bhv.targetItem = true;
					userLine++;
					if (userLine % 1000000 == 0)
						System.out.println(userLine);
				}
				reader.close();
				System.out.println("User Line: " + userLine);
				TrainUserData.arrange();
				System.out.println("User Num: "
						+ TrainUserData.map.keySet().size());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void dumpSortedTrain(PrintStream printer) {
		for (UserBehavior bhv : TrainUserData.userBehaviors) {
			printer.println(bhv);
		}
	}

	public void dumpSortedFilteredTrain(PrintStream printer) {
		for (UserBehavior bhv : TrainUserData.userBehaviors) {
			if (TrainItemData.checkItem(bhv.itemId))
				printer.println(bhv);
		}
	}

}
