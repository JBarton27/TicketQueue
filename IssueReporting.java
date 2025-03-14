/*
 * Issue reporting system that acts as simulation of a ticket system that gathers issue reports and inserts them into the Queue data structure,
 * the user can then find their position in the Queue by entering the exact description of their issue that they reported. 
 * Could be improved by enhancing the project to create a full on ticketing system but further time is needed and I am still learning data structures!
 * 
 * 
 */


import java.util.Scanner;

public class IssueReporting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue myQueue = new Queue("Welcome Ticket"); //instantiate the queue, NOTICE: this creates a ticket, keep this in mind.

        String input;
        do {
            displayMenu();
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter issue description: ");
                    String issueDescription = scanner.nextLine();
                    myQueue.createTicket(issueDescription);
                    break;
                case "2":
                    String removedNode = myQueue.removeTicket();
                    if (removedNode != null) {
                        System.out.println("Removed ticket: " + removedNode);
                    } else {
                        System.out.println("No tickets to remove.");
                    }
                    break;
                case "3":
                    myQueue.getFirstTicket();
                    break;
                case "4":
                    myQueue.getLastTicket();
                    break;
                case "5":
                    myQueue.getLength();
                    break;
                case "6":
                    System.out.print("Enter issue description to find position: ");
                    String positionDescription = scanner.nextLine();
                    myQueue.positionInQueue(positionDescription);
                    break;
                case "0":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (!input.equals("0"));

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Create Ticket");
        System.out.println("2 - Remove Ticket");
        System.out.println("3 - Get First Ticket");
        System.out.println("4 - Get Last Ticket");
        System.out.println("5 - Get Queue Length");
        System.out.println("6 - Find Position in Queue");
        System.out.println("0 - Exit");
        System.out.print("Choose an option: ");
    }
}