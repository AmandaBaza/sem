package view;
import model.TotalRevenue;

public class TotalRevenueView implements TotalRevenue {
    private double revenue;

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
