package destinationView;
import java.util.List;
import java.util.Scanner;

import application.CreateDestination;
import entities.Destinations;
import application.ReadDestinations;
import application.DeleteDestination;
import application.UpdateDestinations;
public class DestinationMenu {
	static Scanner in = new Scanner(System.in);
	static CreateDestination cd = new CreateDestination();
	static UpdateDestinations ud = new UpdateDestinations();
    static DeleteDestination dd = new DeleteDestination();
	static ReadDestinations rd = new ReadDestinations();


	public static void viewTheDestinations(){

	}
	public static void updateTheDestinationInterest(){
		System.out.println("Enter DestinationId to edit: ");
		int selectedId = in.nextInt();
		in.nextLine();
		Destinations toEdit = ud.UpdateDestinationInterestbyId(selectedId);
		System.out.println("Destination Interest: " + toEdit.getTravellerInterest());
		System.out.println("Enter New DestinationInterest: ");
		String newInterest = in.nextLine();
		toEdit.setTravellerInterest(newInterest);
		ud.updateInterest(toEdit);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();
	}
	public static void runMenu() {
		boolean goAgain = true;

		System.out.println("--- Welcome to our awesome shopping list! ---");
		while (goAgain) {
			System.out.println("*  Select an Destination:");
			System.out.println("*  1 -- Add an Destination");
			System.out.println("*  2 -- Delete an Destination");
			System.out.println("*  3 -- View an destinationCity,Name and Interest");
			System.out.println("*  4 -- Update the destinationInterest");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			//System.out.println(in.hasNextInt());
			int selection = in.nextInt();
			in.nextLine();
			if (selection == 1) {

				cd.CreateDestination();	  
			}
			else if (selection == 2) {
				dd.deleteDestination();
			} else if (selection == 3) {
				rd.ViewDestinations();
			}else if (selection == 4) {
				updateTheDestinationInterest();
			}else {
				cd.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}
	}

	private static void ViewDestinations(){
		List<Destinations> allDestinationlocations = cd.showAllDestinations();
		for(Destinations l: allDestinationlocations){
			System.out.println(l.toString());
		}

	}
}
