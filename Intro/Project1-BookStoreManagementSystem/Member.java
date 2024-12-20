package bookstore;

import java.util.ArrayList;
import java.util.List;

// Member class (combining Membership and Customer)
class Member {
    private String name;
    private double totalSpent;
    private String type;  // Regular or Premium
    private boolean feePaid;
    private String paymentMethod;
    private List<Product> purchasedProducts;

    public Member(String name, String type, double totalSpent, boolean feePaid, String paymentMethod) {
        this.name = name;
        this.type = type;
        this.totalSpent = totalSpent;
        this.feePaid = feePaid;
        this.paymentMethod = paymentMethod;
        this.purchasedProducts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public String getType() {
        return type;
    }

    public boolean isFeePaid() {
        return feePaid;
    }

    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void addPurchasedProduct(Product product) {
        purchasedProducts.add(product);
    }
}