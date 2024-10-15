import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class MobilePhone {
    private String modelPhone;
    private double pricePhone;
    private int remainingAmount;
    private String detailPhone;
    private List<Object> listAll;

    public MobilePhone(String model, double price, int amount, String details) {
        this.modelPhone = model;
        this.pricePhone = price;
        this.remainingAmount = amount;
        this.detailPhone = details;
        this.listAll = new ArrayList<>();
    }

    public List<Object> addListAll() {
        listAll.add(modelPhone);
        listAll.add(pricePhone);
        return listAll;
    }

    public void showMobileInfo() {
        System.out.println("Model Phone: " + modelPhone);
        System.out.println("Price Phone: " + pricePhone + " bath");
        System.out.println("Detail Phone: " + detailPhone);
    }

    public void updateRemainingQuantity() {
        System.out.println("Remaining Amount: " + remainingAmount + " piece");
    }
}

class Customer {
    private String fullname;
    private String phoneNumber;
    private String address;

    public Customer(String name, String phone, String address) {
        this.fullname = name;
        this.phoneNumber = phone;
        this.address = address;
    }

    public void customerDetails() {
        System.out.println("Fullname: " + fullname);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Address: " + address);
    }
}

class Cart {
    private List<Object> listAll;
    private List<Map<String, Object>> allItems;

    public Cart(List<Object> listA) {
        this.listAll = listA;
        this.allItems = new ArrayList<>();
    }

    public List<Map<String, Object>> addProductInfo() {
        String product = (String) listAll.get(0);
        double price = (double) listAll.get(1);
        Map<String, Object> item = new HashMap<>();
        item.put("product", product);
        item.put("price", price);
        allItems.add(item);
        return allItems;
    }

    public void cartProduct() {
        for (Map<String, Object> item : allItems) {
            System.out.println("Product name: \"" + item.get("product") + "\" number of " + allItems.size() + " box");
            System.out.println("Price Product: " + item.get("price") + " bath");
        }
    }
}

class Discount {
    private int priceDiscount;
    private int discount;

    public Discount(int price) {
        this.priceDiscount = price;
        this.discount = 0;
    }

    public int discountProcess() {
        if (priceDiscount >= 10000 && priceDiscount < 15000) {
            discount = 5;
        } else if (priceDiscount >= 15000 && priceDiscount < 20000) {
            discount = 10;
        } else if (priceDiscount >= 20000 && priceDiscount < 25000) {
            discount = 15;
        } else {
            discount = 20;
        }
        return discount;
    }

    public int calculateDiscount(int discount) {
        int discountPrice = Math.round(priceDiscount * discount / 100);
        return priceDiscount - discountPrice;
    }
}

class Order {
    private String orderNumber;
    private String orderDate;
    private String orderStatus;
    private String productList;
    private int priceProduct;

    public Order(String number, String date, String status, String product, int price) {
        this.orderNumber = number;
        this.orderDate = date;
        this.orderStatus = status;
        this.productList = product;
        this.priceProduct = price;
    }

    public void orderStatus() {
        System.out.println("Order number: " + orderNumber);
        System.out.println("Order date: " + orderDate);
        System.out.println("Order status: " + orderStatus);
        System.out.println("Product name: " + productList);
        System.out.println("Discounted items: " + priceProduct + " bath");
    }
}

class Payment {
    private String paymentMethod;
    private int totalAmount;
    private int amountPaid;

    public Payment(String paymentMethod, int totalAmount, int amountPaid) {
        this.paymentMethod = paymentMethod;
        this.totalAmount = totalAmount;
        this.amountPaid = amountPaid;
    }

    public void makePaymentProcess() {
        if (paymentMethod.equals("Credit Card") || paymentMethod.equals("Bank Transfer") || paymentMethod.equals("Cash")) {
            int change = amountPaid - totalAmount;
            if (amountPaid >= totalAmount) {
                System.out.println("Payment completed successfully");
                System.out.println("Amount: " + change + " bath");
            } else {
                System.out.println("Payment failed");
                System.out.println("Amount: " + change + " bath");
            }
        } else {
            System.out.println("Invalid payment method.");
        }
    }
}

class ProductHistory {
    private List<Object> orderHistory;

    public ProductHistory(List<Object> history) {
        this.orderHistory = history;
    }

    public void productOrderHistory() {
        System.out.println("Order History:");
        System.out.println("- " + orderHistory.get(0));
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // ตั้งค่า PrintStream เพื่อใช้ UTF-8
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));

        MobilePhone mobileInput = new MobilePhone("Lenovo K13 Pro", 15000, 12, "- Type: IPS LCD, 90Hz\n- Size: 6.51 inches, 102.3 cm2");
        Customer customerInput = new Customer("pongpol chaichavalitskul", "082-308-7808", "Pridi Banomyong 16");

        List<Object> allItems = mobileInput.addListAll();
        Cart cartInput = new Cart(allItems);
        List<Map<String, Object>> cartAll = cartInput.addProductInfo();

        int price = ((Double) cartAll.get(0).get("price")).intValue();
        Discount discountInput = new Discount(price);
        int discountValue = discountInput.discountProcess();
        int discountPrice = discountInput.calculateDiscount(discountValue);

        Order orderInput = new Order("TH-435345AS", "10/5/2567", "pass", mobileInput.addListAll().get(0).toString(), discountPrice);
        Payment paymentInput = new Payment("Cash", discountPrice, 14000);
        ProductHistory historyInput = new ProductHistory(allItems);

        System.out.println("\n======== รายละเอียดสินค้ามือถือ ========");
        mobileInput.showMobileInfo();
        mobileInput.updateRemainingQuantity();
        System.out.println("===============================");
        System.out.println("\n========== รายละเอียดลูกค้า ==========");
        customerInput.customerDetails();
        System.out.println("===================================");
        System.out.println("\n================== ตะกร้าสินค้า ===================");
        cartInput.cartProduct();
        System.out.println("================================================");
        System.out.println("\n================== คำสั่งซื้อ ======================");
        orderInput.orderStatus();
        System.out.println("================================================");
        System.out.println("\n================== การชำระเงิน ====================");
        paymentInput.makePaymentProcess();
        System.out.println("==================================================");
        System.out.println("\n=============== ประวัติการสั่งซื้อสินค้า ================");
        historyInput.productOrderHistory();
        System.out.println("==================================================");
    }
}