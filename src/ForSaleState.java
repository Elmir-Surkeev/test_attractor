public class ForSaleState implements ProductState{
    @Override
    public void startSale(Product product) {
        System.out.println("Товар уже выставлен на аукцион!");
    }

    @Override
    public void raisePrice(Product product, double price) {
        product.setPrice(product.getPrice() + price);
        product.setBidded(true);
        System.out.println("Цена увеличена на " + price );
        System.out.println("Цена после увелеичения " + product.getPrice());
    }

    @Override
    public void withDraw(Product product) {
        if(!product.isBidded()){
            product.setState(new InStockState());
            System.out.println("Товар уже на аукционе ");
        }
    }

    @Override
    public void giveToWinner(Product product, String honoraryCode) {
        if(product.isBidded()){
            product.setState(new Sold_State());
            product.setHonoraryCode(honoraryCode);
            System.out.println("Товар успешно продан");

        }else {
            System.out.println("Товар не на аукционе. Сначала измените состояние товара");
        }
    }

    @Override
    public String getStatusName() {
        return "For Sale state";
    }
}
