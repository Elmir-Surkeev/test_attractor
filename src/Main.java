import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        HandleAction handler = new HandleAction();
        GoodsService goodsService = new GoodsService("src/products.json");
        Product[] products = goodsService.getGoods();

        Scanner sc = new Scanner(System.in);

        while (true) {
            showProducts(products);

            System.out.println("Веберите лот по идентификатору");
            int choice = sc.nextInt();
            if(choice < 0 || choice> products.length){
                System.out.println("Entered false value");
            }

            Product choised =  products[choice-1];
            if (choised != null) {
                handler.handleAction(choised, sc);
                goodsService.saveToFile("src/products.json", products);
                System.out.println("Изменения сохранены в базу данных.");
            }
        }
    }

    private static void showProducts(Product[] products) {
        System.out.println("||==========================================");
        System.out.println("||       КАТАЛОГ АУКЦИОННЫХ ЛОТОВ           ");
        System.out.println("||==========================================");

        for (Product product : products) {
            System.out.printf("|| %-55s || ID: %-2s ||%n", product.getName(), product.getId());
        }

        System.out.println("============================================");
        System.out.print("Веберите лот по идентификатору: ");
    }
}