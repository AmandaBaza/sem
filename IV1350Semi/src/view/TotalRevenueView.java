package view;
import model.TotalRevenue;

/**
 * @author Amanda
 * class to be implemented to the interface TotalRevenue
 */
public class TotalRevenueView implements TotalRevenue {
    private double revenue;

    /**
     * adds the total price of a sale
     * @param payment is the total price to be added into the sum
     */
    @Override
    public void newTotal(double payment) {
        this.revenue = this.revenue + payment;
        printThisSale();
    }

    private void printThisSale() {
        System.out.println("-------Display-------");
        System.out.println("--This total revenue--");
        System.out.println(revenue);
    }

    public TotalRevenueView(){
        this.revenue = 0;
    }
}
