import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodeGenerator {
    public String makeCode(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            return convertToString(md.digest(input.getBytes()));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            System.out.println("No such algorithm");
        }return "";
    }
    private String convertToString(byte[] bytes){
        return IntStream.range(0, bytes.length/4)
                .map(i->bytes[i])
                .map(i -> (i<0) ? 127: i)
                .mapToObj(Integer::toHexString)
                .collect(Collectors.joining());
    }

}
