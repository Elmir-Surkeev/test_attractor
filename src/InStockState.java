public class InStockState implements ProductState{
    @Override
    public void startSale(Product product) {
        product.setState(new ForSaleState());
        System.out.println("Успешно начаты торги, на товар " + product.getName());
    }

    @Override
    public void raisePrice(Product product, double price) {
        System.out.println("Нельзя повысить цену, данный товар еще на складе "+ product.getName());
    }

    @Override
    public void withDraw(Product product) {
        System.out.println("Нельзя снять с торгов товар сразу со склада "+ product.getName() );
    }

    @Override
    public void giveToWinner(Product product, String honoraryCode) {
        System.out.println("Нельзя отдать товар сразу со склада "+ product.getName());
    }

    @Override
    public String getStatusName() {
        return "In Stock";
    }
}
