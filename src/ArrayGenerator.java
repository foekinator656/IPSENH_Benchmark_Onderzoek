import java.util.ArrayList;
import java.util.Random;

public class ArrayGenerator {
    public ArrayGenerator(){
        fillNumberList();
        fillHundredNumbersLongList();
        fillThousandNumbersLongList();
        fillTenThousandNumbersLongList();
        fillHundredThousandNumbersLongList();
    }

    Random random = new Random();

    ArrayList<Integer> numberList = new ArrayList<>();

    ArrayList<Long> hundredNumbersLongList = new ArrayList<>();
    ArrayList<Long> thousandNumbersLongList = new ArrayList<>();
    ArrayList<Long> tenThousandNumbersLongList = new ArrayList<>();
    ArrayList<Long> hundredThousandNumbersLongList = new ArrayList<>();

    public void fillNumberList(){
        numberList.add(100);
        numberList.add(1000);
        numberList.add(10000);
        numberList.add(100000);
    }

    public void fillHundredNumbersLongList(){
        while (hundredNumbersLongList.size() <= numberList.get(0)){
            hundredNumbersLongList.add(random.nextLong());
        }
    }
    public void fillThousandNumbersLongList(){
        while (thousandNumbersLongList.size() <= numberList.get(1)) {
            thousandNumbersLongList.add(random.nextLong());
        }
    }
    public void fillTenThousandNumbersLongList(){
        while (tenThousandNumbersLongList.size() <= numberList.get(2)) {
            tenThousandNumbersLongList.add(random.nextLong());
        }
    }
    public void fillHundredThousandNumbersLongList(){
        while (hundredThousandNumbersLongList.size() <= numberList.get(3)) {
            hundredThousandNumbersLongList.add(random.nextLong());
        }
    }
}
