import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class JacobShoppingComplex {


    public static void main(String[] args) throws Exception {
        customerDetails();
    }

    static Scanner input = new Scanner(System.in);
    static String customerName;
   


    static ArrayList<Integer> items = new ArrayList<>();

    public JacobShoppingComplex() {
    }

    static ArrayList<Integer> itemsQuantity = new ArrayList<>();

    static ArrayList<String> itemName = new ArrayList<>();
    static ArrayList<Integer> qta = new ArrayList<>();
    static ArrayList<Integer> amountCustomerPaid = new ArrayList<>();

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SS");
    static String nameOfCashier;

    static int total = 0;
    static int index;
    static int subtotal;
    static double vat;

    static double discount;
    static double payment;

    static String scanner() {
        String name = input.nextLine();
        return name;
    }

    static int scannerInt() {
        return input.nextInt();
    }

    public static void customerDetails() throws Exception {
        System.out.printf("%s%n", "Customer Name: ");
        customerName = input.nextLine();

        System.out.printf("%s%n", "What did customer buy?: ");
        itemName.add(scanner());

        itemsBought();
    }

    static void liner() {
        System.out.printf("================================ %n");
    }

    public static void itemsBought() throws Exception {
        System.out.printf("%s%n", "Customer Name: ");
        customerName = input.nextLine();


        System.out.printf("%s%n", "How many quantity?: ");
        itemsQuantity.add(scannerInt());

        System.out.printf("%s%n", "How much per quantity?: ");
        qta.add(scannerInt());

        System.out.printf("%s%n", "Amount customer paid: ");
        amountCustomerPaid.add(scannerInt());

        keepBuying();

    }

    static void keepBuying() throws Exception {
        System.out.printf("%s%n", "Add more items to cart?: ");
        scanner();
        switch (scanner()) {
            case "yes" -> customerDetails();
            case "no" -> nameOfCashier();
        }
    }

    private static void nameOfCashier() throws Exception {
        System.out.printf("%s%n", "Cashier name:");
        nameOfCashier = scanner();

        System.out.printf("%s%n", "discount amount:");
        discount = scannerInt();
        new JacobShoppingComplex().generatePaymentSlip();
    }

    private static double billTotal() {
        return subtotal;
    }

    private static double getVat() {
        return vat;
    }
    private static double getDiscount() {
        return discount;
    }

    public static void generateReceipt() {
        System.out.printf("%s%s%s%n", "EneDigital Complex", "Main Branch", "Location: Sabo Yaba: Tel:+2347012345678:");

        Date date = new Date();
        System.out.printf("Date: " + simpleDateFormat.format(date));
        System.out.printf("Cashier's Name: %n%s", customerName);

        System.out.println("=================================================================================================================== %n");
        System.out.printf("%30s%10s%10s%15s%n", "Item", "Quantity", "Price", "Total ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------- %n");


        for (index = 0; index < items.size(); index++) {
            total = qta.get(index) * items.get(index);
            System.out.printf("%30s%10s%10d%10d%n", itemName, qta.get(index), amountCustomerPaid.get(index), total);
            discount = total - amountCustomerPaid.get(index);

            vat = vat * 17.50 / 100;
            subtotal += total;
        }
    }

    public void generatePaymentSlip() throws Exception{
        System.out.printf("%s%n", "EneDigital Complex\nMain Branch\nLocation: Sabo Yaba:\nTel:+2347012345678");

        Date date = new Date();
        System.out.printf("Date: " + simpleDateFormat.format(date));
        System.out.printf("%n%s%s", "Cashier's Name: ", nameOfCashier);
        System.out.printf("%n%s%s%n%n", "Customer Name: ", customerName);

        System.out.println("========================================================================================");
        System.out.printf("%30s%10s%10s%15s%n",  "Item",  "QTY", "Price",   "Total(NGN) ");
        System.out.println(" ---------------------------------------------------------------------------------------");

        for (index = 0; index < items.size(); index++) {
            payment = items.get(index) * amountCustomerPaid.get(index);
            discount = discount/100 * subtotal;

            vat = 17.50/100 * subtotal;

            total = qta.get(index) * items.get(index);
            System.out.printf("%30s%10s%10d%10d%n", itemName, items.get(index), qta.get(index), total);

            subtotal += total;

        }

        System.out.printf("======================================================================================= %n");
        System.out.printf("%40s%15d%n", "SubTotal", subtotal);
        System.out.printf("%40s%15.2f%n", "Discount", getDiscount());
        System.out.printf("%40s%15.2f%n", "VAT", getVat());
        System.out.printf("======================================================================================= %n");

        System.out.printf("%40s%15.2f%n", "Bill Total", billTotal());
        System.out.printf("======================================================================================= %n");

        System.out.printf("======================================================================================= %n");
        System.out.printf("%40s%n",                                 "Thanks for your patronage");
        System.out.printf("======================================================================================= %n");

        new JacobShoppingComplex().generatePaymentSlip();
    }
}