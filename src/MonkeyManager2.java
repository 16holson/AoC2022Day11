import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class MonkeyManager2
{
    private ArrayList<Monkey2> monkeys;

    public MonkeyManager2(ArrayList<Monkey2> monkeys)
    {
        this.monkeys = monkeys;
    }

    public ArrayList<Monkey2> getMonkeys()
    {
        return monkeys;
    }

    public void setMonkeys(ArrayList<Monkey2> monkeys)
    {
        this.monkeys = monkeys;
    }

    public void moveMonkeyItems()
    {
        for (Monkey2 monkey : this.monkeys)
        {
            for(Iterator<String> it = monkey.getItems().iterator(); it.hasNext();)
            {
                String item = it.next();
                BigInteger newItem = monkey.inspectItem(item);
                ArrayList<BigInteger> monkeyInfo = monkey.findPass(newItem);
                it.remove();
                this.monkeys.get(Integer.parseInt(monkeyInfo.get(1).toString())).addItem(monkeyInfo.get(0).toString());
            }
        }
    }
    public BigInteger getMonkeyBusiness()
    {
        BigInteger top = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger second = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        for (Monkey2 monkey: this.monkeys)
        {
            if(new BigInteger(String.valueOf(monkey.getNumInspected())).compareTo(top) > 0)
            {
                second = top;
                top = new BigInteger(String.valueOf(monkey.getNumInspected()));
            }
            else if(new BigInteger(String.valueOf(monkey.getNumInspected())).compareTo(second) > 0)
            {
                second = new BigInteger(String.valueOf(monkey.getNumInspected()));
            }
        }
        System.out.println("Top: " + top + " second: " + second);
        return top.multiply(second);
    }

}
