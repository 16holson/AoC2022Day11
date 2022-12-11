import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class MonkeyManager
{
    private ArrayList<Monkey> monkeys;

    public MonkeyManager(ArrayList<Monkey> monkeys)
    {
        this.monkeys = monkeys;
    }

    public ArrayList<Monkey> getMonkeys()
    {
        return monkeys;
    }

    public void setMonkeys(ArrayList<Monkey> monkeys)
    {
        this.monkeys = monkeys;
    }

    public void moveMonkeyItems()
    {
        for (Monkey monkey : this.monkeys)
        {
             for(Iterator<String> it = monkey.getItems().iterator(); it.hasNext();)
             {
                 String item = it.next();
                 BigInteger newItem = monkey.inspectItem(item);
                 String monkeyName = monkey.findPass(newItem);
                 it.remove();
                 this.monkeys.get(Integer.parseInt(monkeyName)).addItem(newItem.toString());
             }
        }
    }
    public int getMonkeyBusiness()
    {
        int top = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (Monkey monkey: this.monkeys)
        {
            if(monkey.getNumInspected() > top)
            {
                second = top;
                top = monkey.getNumInspected();
            }
            else if(monkey.getNumInspected() > second)
            {
                second = monkey.getNumInspected();
            }
        }
        System.out.println("Top: " + top + " second: " + second);
        return top*second;
    }
}
