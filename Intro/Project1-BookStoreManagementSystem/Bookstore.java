package bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Bookstore {
    private List<Product> inventory;
    private List<Member> members;

    public Bookstore() {
        this.inventory = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public List<Product> getInventory() {
        return inventory;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addProduct(Product product) {
        inventory.add(product);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void completePurchase(Member member) {
        Scanner scanner = new Scanner(System.in);

        // Display inventory and let the user choose products
        System.out.println("Available products:");
        for (Product product : inventory) {
            System.out.println(product.getName() + " - $" + product.getPrice() + " - Quantity: " + product.getQuantity());
        }

        System.out.print("Enter product name to purchase (or 'done' to finish): ");
        String productName = scanner.nextLine();

        while (!productName.equalsIgnoreCase("done")) {
            Product selectedProduct = findProduct(productName);
            if (selectedProduct != null && selectedProduct.getQuantity() > 0) {
                // Deduct item from inventory
                selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);

                // Add purchased product to member's list
                member.addPurchasedProduct(selectedProduct);

                // Update total spent by the member
                member.setTotalSpent(member.getTotalSpent() + selectedProduct.getPrice());

                System.out.println("Added " + selectedProduct.getName() + " to your purchase.");
            } else {
                System.out.println("Invalid product or out of stock.");
            }

            System.out.print("Enter another product name to purchase (or 'done' to finish): ");
            productName = scanner.nextLine();
        }
    }

    private Product findProduct(String productName) {
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}
