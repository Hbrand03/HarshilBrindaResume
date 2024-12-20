package bookstore;

import java.util.Scanner;

public class BookstoreMain {
    public static void main(String[] args) {
        Bookstore bookstore = initializeBookstore();

        // Test Harness
        simulateUserInteractions(bookstore);
    }

    private static Bookstore initializeBookstore() {
        Bookstore bookstore = new Bookstore();

        // Initialize the bookstore, add products, etc.
        Book book1 = new Book("The Great Gatsby", 10.99, 20, "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", 12.99, 15, "Harper Lee");
        CD cd1 = new CD("Abbey Road", 14.99, 30, "The Beatles");
        DVD dvd1 = new DVD("Inception", 19.99, 25, "Christopher Nolan");

        bookstore.addProduct(book1);
        bookstore.addProduct(book2);
        bookstore.addProduct(cd1);
        bookstore.addProduct(dvd1);

        return bookstore;
    }

    private static void simulateUserInteractions(Bookstore bookstore) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Bookstore!");
            System.out.println("1. Complete a purchase");
            System.out.println("2. Register a new premium member");
            System.out.println("3. Display store inventory");
            System.out.println("4. Register a new regular member");
            System.out.println("5. Display member information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Simulate a member completing a purchase
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();

                    Member member = findMember(bookstore, memberName);

                    if (member != null) {
                        bookstore.completePurchase(member);
                        System.out.println("Purchase completed. Total spent: $" + member.getTotalSpent());
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 2:
                    // Implement register a new premium member functionality
                    System.out.print("Enter member name: ");
                    String premiumMemberName = scanner.nextLine();

                    Member premiumMember = new Member(premiumMemberName, "Premium", 0.0, true, "");

                    // Set payment method for premium member
                    System.out.print("Enter payment method for premium member: ");
                    String paymentMethod = scanner.nextLine();
                    premiumMember.setPaymentMethod(paymentMethod);

                    bookstore.addMember(premiumMember);
                    System.out.println("Premium member " + premiumMemberName + " registered.");
                    break;

                case 3:
                    // Display store inventory
                    System.out.println("Store Inventory:");
                    for (Product product : bookstore.getInventory()) {
                        System.out.println(product.getName() + " - $" + product.getPrice() + " - Quantity: " + product.getQuantity());
                    }
                    break;

                case 4:
                    // Register a new regular member
                    System.out.print("Enter member name: ");
                    String regularMemberName = scanner.nextLine();

                    Member regularMember = new Member(regularMemberName, "Regular", 0.0, false, "");
                    bookstore.addMember(regularMember);
                    System.out.println("Regular member " + regularMemberName + " registered.");
                    break;

                case 5:
                    // Display member information
                    System.out.print("Enter member name: ");
                    String memberToDisplay = scanner.nextLine();

                    Member selectedMember = findMember(bookstore, memberToDisplay);

                    if (selectedMember != null) {
                        System.out.println("Member Information:");
                        System.out.println("Name: " + selectedMember.getName());
                        System.out.println("Membership Type: " + selectedMember.getType());
                        System.out.println("Total Amount Spent: $" + selectedMember.getTotalSpent());

                        System.out.println("Purchased Products:");
                        for (Product product : selectedMember.getPurchasedProducts()) {
                            System.out.println(product.getName() + " - $" + product.getPrice());
                        }
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Thank you for using the Bookstore system. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Member findMember(Bookstore bookstore, String memberName) {
        for (Member member : bookstore.getMembers()) {
            if (member.getName().equalsIgnoreCase(memberName)) {
                return member;
            }
        }
        return null;
    }
}
