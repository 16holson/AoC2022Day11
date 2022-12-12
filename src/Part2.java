import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Part2
{
    public static void main(String[] args) throws IOException
    {
        String line;
        String file = new File("").getAbsolutePath();
        file = file.concat("\\src\\InputData.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList<Monkey2> monkeys = new ArrayList<>();
        Monkey2 monkey = new Monkey2();
        while (true)
        {
            line = bufferedReader.readLine();
            if(line == null)
            {
                break;
            }
            else
            {
                if(line.equals(""))
                {
                    monkey = new Monkey2();
                }
                else
                {
                    //Name
                    String[] split = line.strip().split(" ");
                    monkey.setName(split[1].replace(":", ""));
                    //Starting items
                    line = bufferedReader.readLine();
                    line = line.replace("  Starting items: ", "").strip();
                    split = line.split(", ");
                    for (String item: split)
                    {
                        monkey.addItem(item);
                    }
                    //Operation
                    line = bufferedReader.readLine();
                    line = line.replace("  Operation: new = ", "");
                    monkey.setOperation(line.strip());
                    //Test
                    line = bufferedReader.readLine();
                    line = line.replace("  Test: divisible by ", "").strip();
                    monkey.setTest(Integer.parseInt(line));
                    //If true
                    line = bufferedReader.readLine();
                    line = line.replace("    If true: throw to monkey ", "").strip();
                    monkey.setTrueMonkey(line);
                    //If false
                    line = bufferedReader.readLine();
                    line = line.replace("    If false: throw to monkey ", "").strip();
                    monkey.setFalseMonkey(line);
                    monkeys.add(monkey);
                }
            }
        }
        MonkeyManager2 manager = new MonkeyManager2(monkeys);
        for (int i = 0; i < 10000; i++)
        {
            manager.moveMonkeyItems();
        }
        System.out.println("Monkey Business = " + manager.getMonkeyBusiness());
        bufferedReader.close();
    }
}
