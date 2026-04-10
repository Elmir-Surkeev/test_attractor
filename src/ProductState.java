public interface ProductState {
     void startSale(Product product);
     void raisePrice(Product product, double price);
     void withDraw(Product product);
     void giveToWinner(Product product, String honoraryCode);
    String getStatusName();
}
