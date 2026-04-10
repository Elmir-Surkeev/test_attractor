public interface CodeStrategy {
    String generate(String id);
}

class GoldStrategy implements CodeStrategy {
    public String generate(String id) {
        return new CodeGenerator().makeCode("Золотой лот" + id);
    }
}

class SilverStrategy implements CodeStrategy {
    public String generate(String id) {
        return new CodeGenerator().makeCode("Серебрянный лот" + id);
    }
}

class BronzeStrategy implements CodeStrategy {
    public String generate(String id) {
        return new CodeGenerator().makeCode("Бронзовый лот" + id);
    }
}