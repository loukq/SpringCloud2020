import java.time.ZonedDateTime;

public class T2 {
//    利用ZonedDateTime得到准确的时区时间
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        System.out.println(zonedDateTime);
//        2020-06-13T14:02:59.187+08:00[Asia/Shanghai]
    }
}
