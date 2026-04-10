import java.util.Scanner;

public class HandleAction {
    public void handleAction(Product product, Scanner sc) {
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    product.startSale();
                    break;
                case 2:
                    System.out.println("Увеличить цену");
                    double addPrice = sc.nextDouble();
                    product.raisePrice(addPrice);
                    break;
                case 3:
                    System.out.println("Выдача товара победителю...");
                    CodeStrategy strategy = CodeStrategyFactory.getStrategy(product.getPrice());
                    String generatedCode = strategy.generate(product.getId());
                    product.giveToTheWinner(generatedCode);

                    break;
                case 4:
                    product.withdraw();
                    break;
                case 5:
                    return;
               default:
                   System.out.println("Неверный выбор");

            }
        }
    }
    private void showMenu() {
        System.out.println("1. Выставить на аукцион");
        System.out.println("2. Поднять цену");
        System.out.println("3. Выдать победителю");
        System.out.println("4. Снять с торгов");
        System.out.println("5. Вернуться назад");
    }
}
