package Controllers;

import java.util.ArrayList;
import java.util.Random;

public class ArrayController {

    Random random = new Random();
    public ArrayList<Long> hundredNumbers = new ArrayList<>();
    public ArrayList<Long> thousandNumbers = new ArrayList<>();
    public ArrayList<Long> tenThousandNumbers = new ArrayList<>();
    public ArrayList<Long> hundredThousandNumbers = new ArrayList<>();

    public void fillHundredNumbers(){
        while (hundredNumbers.size() <= 100){
            hundredNumbers.add(random.nextLong());
        }
    }
    public void fillThousandNumbers(){
        while (thousandNumbers.size() <= 1000) {
            thousandNumbers.add(random.nextLong());
        }
    }
    public void fillTenThousandNumbers(){
        while (tenThousandNumbers.size() <= 10000) {
            tenThousandNumbers.add(random.nextLong());
        }
    }
    public void fillHundredThousandNumbers(){
        while (hundredThousandNumbers.size() <= 100000) {
            hundredThousandNumbers.add(random.nextLong());
        }
    }

    public void run() {
        fillHundredNumbers();
        fillThousandNumbers();
        fillTenThousandNumbers();
        fillHundredThousandNumbers();
    }
}
