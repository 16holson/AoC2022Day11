import java.math.BigInteger;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;

public class Monkey2
{
    private String name;
    private ArrayList<String> items;
    private String operation;
    private int test;
    private String trueMonkey;
    private String falseMonkey;
    private int numInspected;

    public Monkey2()
    {
        items = new ArrayList<>();
        numInspected = 0;
    }
    public Monkey2(String name, ArrayList<String> items, String operation, int test, String trueMonkey, String falseMonkey, int numInspected)
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
                    case "+" -> newItem = new BigInteger(String.valueOf((first + second)));
                    case "*" -> newItem = new BigInteger(String.valueOf((first * second)));
                    default -> newItem = new BigInteger("-999999");
                };

    }
    public ArrayList<BigInteger> findPass(BigInteger item)
    {
        ArrayList<BigInteger> list = new ArrayList<>();
        item = item.mod(new BigInteger("9699690"));
        list.add(item);
        list.add(item.mod(new BigInteger(String.valueOf(this.test))).equals(new BigInteger("0")) ? new BigInteger(trueMonkey) : new BigInteger(falseMonkey));
        return list;
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

