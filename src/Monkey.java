import java.math.BigInteger;
import java.util.ArrayList;

public class Monkey
{
    private String name;
    private ArrayList<String> items;
    private String operation;
    private int test;
    private String trueMonkey;
    private String falseMonkey;
    private int numInspected;

    public Monkey()
    {
        items = new ArrayList<>();
        numInspected = 0;
    }
    public Monkey(String name, ArrayList<String> items, String operation, int test, String trueMonkey, String falseMonkey, int numInspected)
    {
        this.name = name;
        this.items = items;
        this.operation = operation;
        this.test = test;
        this.trueMonkey = trueMonkey;
        this.falseMonkey = falseMonkey;
        this.numInspected = numInspected;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public ArrayList<String> getItems()
    {
        return items;
    }

    public void setItems(ArrayList<String> items)
    {
        this.items = items;
    }
    public void addItem(String item)
    {
        this.items.add(item);
    }
    public String getOperation()
    {
        return operation;
    }

    public void setOperation(String operation)
    {
        this.operation = operation;
    }

    public int getTest()
    {
        return test;
    }

    public void setTest(int test)
    {
        this.test = test;
    }

    public String getTrueMonkey()
    {
        return trueMonkey;
    }

    public void setTrueMonkey(String trueMonkey)
    {
        this.trueMonkey = trueMonkey;
    }

    public String getFalseMonkey()
    {
        return falseMonkey;
    }

    public void setFalseMonkey(String falseMonkey)
    {
        this.falseMonkey = falseMonkey;
    }

    public int getNumInspected()
    {
        return numInspected;
    }

    public void setNumInspected(int numInspected)
    {
        this.numInspected = numInspected;
    }
    public void incrementNumInspected()
    {
        this.numInspected += 1;
    }
    public BigInteger inspectItem(String item)
    {
        String[] split = this.operation.split(" ");
        int first = Integer.parseInt(item);
        int second = 0;
        BigInteger newItem;
        if(Character.isDigit(split[2].charAt(0)))
        {
            second = Integer.parseInt(split[2]);
        }
        else
        {
            second = Integer.parseInt(item);
        }
        this.incrementNumInspected();
        return switch (split[1])
                {
                    case "+" -> newItem = new BigInteger(String.valueOf((first + second)/3));
                    case "*" -> newItem = new BigInteger(String.valueOf((first * second)/3));
                    default -> newItem = new BigInteger("-999999");
                };

    }
    public String findPass(BigInteger item)
    {
        if(item.mod(new BigInteger(String.valueOf(test))).equals(new BigInteger("0")))
        {
            return trueMonkey;
        }
        else
        {
            return falseMonkey;
        }
    }

    @Override
    public String toString()
    {
        return "Monkey{" +
                "name='" + name + '\'' +
                ", items=" + items +
                ", operation='" + operation + '\'' +
                ", test=" + test +
                ", trueMonkey='" + trueMonkey + '\'' +
                ", falseMonkey='" + falseMonkey + '\'' +
                ", numInspected=" + numInspected +
                '}';
    }
}
