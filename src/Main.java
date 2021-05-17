import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	Scanner in = new Scanner(System.in);
	ArrayList<Shoe> shoe = new ArrayList<>();
	int choice;
	String name, releaseDate, category;
	int price;
	public Main() {
		while (true) {
			menu();
			if (choice == 1) {
				view();
			}
			else if (choice == 2) {
				add();
			}
			else if (choice == 3) {
				delete();
			}
			else {
				System.out.println("Thank you for using this application!");
				break;
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}
	
	public void menu() {
		System.out.println("Shoe Shop");
		System.out.println("=========");
		System.out.println("1. View Shoes");
		System.out.println("2. Add Shoe");
		System.out.println("3. Delete Shoe");
		System.out.println("4. Exit");
		while (true) {
			try {
				System.out.print(">> ");
				choice = in.nextInt();
				in.nextLine();
				if (choice >= 1 && choice <= 4) {
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Input must be a number");
				in.nextLine();
			}
		}
	}
	
	public void view() {
		if (shoe.size() == 0) {
			System.out.println("No shoes available..");
		}
		else {
			for (int i = 0; i < shoe.size(); i++) {
				System.out.printf("%d %s-%s\n", i + 1, shoe.get(i).name, shoe.get(i).ID);
				System.out.println("================");
				System.out.println("Category: " + shoe.get(i).category);
				System.out.println("Release date: " + shoe.get(i).releaseDate);
				System.out.println("Price: " + shoe.get(i).price);
				System.out.println("");
			}
		}
		System.out.println("Press enter to continue..");
		in.nextLine();
	}
	
	public void add() {
		while (true) {
			System.out.print("Input shoe's name[name ends with shoe, example: \"Fire shoe\"]: ");
			name = in.nextLine();
			if (name.endsWith("shoe")) {
				break;
			}
		}
		
		while (true) {
			System.out.print("Input shoe's category[Sneaker | Running | Boot] (case sensitive): ");
			category = in.nextLine();
			if (category.equals("Sneaker") || category.equals("Running") || category.equals("Boot")) {
				break;
			}
		}
		
		while (true) {
			System.out.print("Input shoe's release date[dd-mm-yyyy]: ");
			releaseDate = in.nextLine();
			try {
				SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
				SDF.setLenient(false);
				SDF.parse(releaseDate);
			}
			catch (ParseException pe) {
				continue;
			}
			break;
		}
		
		while (true) {
			try {
				System.out.print("Input shoe's price[more than or equals to 5000]: ");
				price = in.nextInt();
				in.nextLine();
				if (price >= 5000) {
					break;
				}
			}
			catch (Exception e) {
				System.out.println("Input be must be a number");
				in.nextLine();
			}
		}
		
		Random random = new Random();
		String ID = "SH";
		for (int i = 0; i < 3; i++) {
			ID += (random.nextInt(10) + 1);
		}
		shoe.add(new Shoe(ID, name, category, releaseDate, price));
		System.out.println("Shoe added!");
		System.out.println("Press enter to continue..");
		in.nextLine();
	}
	
	public void delete() {
		if (shoe.size() == 0) {
			System.out.println("No shoes available..");
		}
		else {
			for (int i = 0; i < shoe.size(); i++) {
				System.out.printf("%d. %s-%s\n", i + 1, shoe.get(i).name, shoe.get(i).ID);
				System.out.println("================");
				System.out.println("Category: " + shoe.get(i).category);
				System.out.println("Release date: " + shoe.get(i).releaseDate);
				System.out.println("Price: " + shoe.get(i).price);
				System.out.println("");
			}
			int delete;
			while (true) {
				try {
					System.out.printf("Choose shoe's number to delete[1..%d]: ", shoe.size());
					delete = in.nextInt();
					in.nextLine();
					if (delete >= 1 && delete <= shoe.size()) {
						break;
					}
				}
				catch (Exception e) {
					System.out.println("Input be must be a number");
					in.nextLine();
				}
			}
			shoe.remove(delete - 1);
			System.out.println("Shoe removed!");
		}
		System.out.println("Press enter to continue..");
		in.nextLine();
	}

}
