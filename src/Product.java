public class Product {
    private String id;
    private String name;
    private double price;
    private String honoraryCode;
    private boolean isBidded = false;
    private ProductState state;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.honoraryCode = "NOT_ASSIGNED";
        this.state = new InStockState();
    }
    public void startSale() { state.startSale(this); }
    public void raisePrice(double amount) { state.raisePrice(this, amount); }
    public void withdraw() { state.withDraw(this); }
    public void giveToTheWinner(String code) { state.giveToWinner(this, code); }

    public void setState(ProductState state) { this.state = state; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getId() { return id; }
    public void setPrice(double price) { this.price = price; }
    public boolean isBidded() { return isBidded; }
    public void setBidded(boolean bidded) { isBidded = bidded; }
    public void setHonoraryCode(String code) { this.honoraryCode = code; }
    public String getHonoraryCode() {
        return honoraryCode;
    }

    public String getStatusName() {
        return state.getStatusName();
    }
    @Override
    public String toString() {
        return String.format("[%s] %s | Цена: %.2f | Статус: %s | Код: %s",
                id, name, price, state.getStatusName(), honoraryCode);
    }
}