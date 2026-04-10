public class CodeStrategyFactory {
    public static CodeStrategy getStrategy(double price) {
        if (price >= 200000000.0) {
            return new GoldStrategy();
        } else if (price >= 50_000_000.0) {
            return new SilverStrategy();
        } else {
            return new BronzeStrategy();
        }
    }
}