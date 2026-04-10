public class Sold_State implements ProductState {
    @Override
    public void startSale(Product product) { System.out.println("Ошибка: Товар уже продан."); }

    @Override
    public void raisePrice(Product product, double amount) { System.out.println("Ошибка: Товар уже продан."); }

    @Override
    public void withDraw(Product product) {
        System.out.println("Ошибка: Товар уже продан.");
    }

    @Override
    public void giveToWinner(Product product, String honoraryCode) {
        System.out.println("Ошибка: Товар уже выдан покупателю.");
    }
    @Override
    public String getStatusName() { return "sold"; }
}