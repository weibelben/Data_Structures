
/*
 * a person is a tuple
 * <String name, int SSN>
 */
public class Person
{
	private String name;
	private int SSN;
	
	public Person(String name, int SSN)
	{
		this.name = name;
		this.SSN = SSN;
	}
	
	/*
	 * returns the name
	 */
	public String get_name()
	{
		return name;
	}
	
	/*
	 * returns the ssn
	 */
	public int get_ssn()
	{
		return SSN;
	}
	
	/*
	 * compares the name and ssn
	 */
	public boolean equals(Person p)
	{
		if (p == null)
		{
			return false;
		}
		
		if (name.equals(p.get_name()) && SSN == p.get_ssn())
		{
			return true;
		}
		
		return false;
	}
	
	public void print()
	{
		System.out.println("\t" + name + ": " + SSN);
	}
}
