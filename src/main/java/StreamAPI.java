import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StreamAPI {
    public static void main(String[] args) throws ParseException {
        System.out.println(new Random().ints(1, 21).distinct().limit(5).sum());
        String phones = "+7(928)2572797,89282572797";
        String[] arrPhones = phones.split(",");
        var matcher = phoneNumber.matcher("+7(928)2572797");
        String opCode = null;
        if (matcher.find())
            opCode = matcher.group(1);
        System.out.println(opCode);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        Date date =  sdf.parse("12.11.2003 13:22");
        System.out.println(date);
    }

    private static Pattern phoneNumber = Pattern.compile("[+]?[7|8]?[(]?(\\d{3})[)]?\\d{7}$");
    // символ + (его может не быть); 7 или 8, их тоже может не быть; далее создаем группу из чисел длиной 3 символа
}
