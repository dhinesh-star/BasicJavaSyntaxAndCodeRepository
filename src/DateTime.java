import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) throws ParseException {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDateTime localDateTime = date.atStartOfDay();
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        long epochtime = instant.getEpochSecond();
        System.out.println(epochtime);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = simpleDateFormat.parse("2024/06/28");
        System.out.println(String.valueOf(date1));
        Instant instant1 = date1.toInstant();
        long epochTime = instant1.getEpochSecond();
        System.out.println(date1);
        System.out.println(epochTime);
    }
}
