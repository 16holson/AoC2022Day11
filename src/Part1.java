import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Part1
{

    public static void main(String[] args) throws IOException
    {
        String line;
        String file = new File("").getAbsolutePath();
        file = file.concat("\\src\\InputData.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        ArrayList<Monkey> monkeys = new ArrayList<>();
        Monkey monkey = new Monkey();
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
                    monkey = new Monkey();
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
        MonkeyManager manager = new MonkeyManager(monkeys);
        for (int i = 0; i < 20; i++)
        {
            manager.moveMonkeyItems();
        }
        System.out.println("Monkey Business = " + manager.getMonkeyBusiness());
        bufferedReader.close();
    }
}
