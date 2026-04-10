import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GoodsService {
    private Product[] products;

    public GoodsService(String fileName) {
        products = readFromFile(fileName);
    }

    private Product[] readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new Product[0];
        }

        String content = sb.toString();
        int count = 0;
        int index = 0;
        while ((index = content.indexOf("\"id\"", index)) != -1) {
            count++;
            index++;
        }

        Product[] result = new Product[count];
        int start = 0;
        int productIndex = 0;

        while (true) {
            int open = content.indexOf("{", start);
            int close = content.indexOf("}", open);
            if (open == -1 || close == -1) break;

            String block = content.substring(open, close + 1);

            String id = extractValue(block, "id");
            String name = extractValue(block, "name");
            double price = Double.parseDouble(extractValue(block, "price"));

            result[productIndex] = new Product(id, name, price);
            productIndex++;
            start = close + 1;
        }

        return result;
    }

    private String extractValue(String block, String key) {
        String search = "\"" + key + "\"";
        int keyIndex = block.indexOf(search);
        if (keyIndex == -1) return "";

        int colon = block.indexOf(":", keyIndex);
        int valueStart = colon + 1;

        while (valueStart < block.length() &&
                block.charAt(valueStart) == ' ') {
            valueStart++;
        }

        if (block.charAt(valueStart) == '"') {
            int end = block.indexOf("\"", valueStart + 1);
            return block.substring(valueStart + 1, end);
        }

        int end = valueStart;
        while (end < block.length() &&
                block.charAt(end) != ',' &&
                block.charAt(end) != '}') {
            end++;
        }
        return block.substring(valueStart, end).trim();
    }

    public Product[] getGoods() {
        return products;
    }
    public void saveToFile(String fileName, Product[] products) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        for (int i = 0; i < products.length; i++) {
            Product p = products[i];
            sb.append("  {\n");
            sb.append("    \"id\": \"").append(p.getId()).append("\",\n");
            sb.append("    \"name\": \"").append(p.getName()).append("\",\n");
            sb.append("    \"price\": ").append(p.getPrice()).append(",\n");
            sb.append("    \"honorary_code\": \"").append(p.getHonoraryCode()).append("\",\n");
            sb.append("    \"state\": \"").append(p.getStatusName()).append("\"\n");
            sb.append("  }");

            if (i < products.length - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("]");

        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(sb.toString());
        } catch (java.io.IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}