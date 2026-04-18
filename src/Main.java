import java.math.BigDecimal;
import java.time.LocalDate;
import com.company.accouting.entity.Record;

public class Main {

    public static void main(String[] args) {

        Record r = new Record(
                1,
                LocalDate.now(),
                "收入",
                new BigDecimal("5000"),
                "工资",
                "4月工资"
        );

        System.out.println(r);
        System.out.println(r.toFileString());
    }

}