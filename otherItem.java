import java.util.Calendar;

public class otherItem extends InventoryItem
{
	public String name;
	
	public String toString()
	{
		return name;
	}
	
	public otherItem(int id, String name)
	{
		super(id);
		this.name = name;
	}
	
	public void changeName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void CheckOut()
	{
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		setCheckedOut(today.getTime());
		today.add(Calendar.WEEK_OF_MONTH, +1);
		setDueDate(today.getTime());
	}
}
