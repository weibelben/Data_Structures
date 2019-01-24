
/* 
 * Hash Buckets are small [10 element] arrays of Persons
 * <String name, int ssn>
 */
public class Hash_Bucket 
{
	static int MAX_SIZE = 10;
	Person[] people;
	
	public Hash_Bucket()
	{
		people = new Person[MAX_SIZE];
	}
	
	/*
	 * adds a person to the array
	 */
	public void add_person(Person p)
	{
		if (this.size() >= MAX_SIZE)
		{
			System.out.println("Cannot add any more people to this key.");
			return;
		}
		
		for (int i = 0; i < MAX_SIZE; i++)
		{
			if (people[i] == null)
			{
				people[i] = p;
				return;
			}
		}
		
		System.out.println("Could not add " + p.get_name());
	}
	
	/*
	 * removes the person that matches the given name and SSN
	 */
	public Person remove_person(Person p)
	{
		for (int i = 0; i < MAX_SIZE; i++)
		{
			if (people[i] != null)
			{
				if (p.equals(people[i]))
				{
					people[i] = null;
					return p;
				}
			}
		}
		
		System.out.println("No person matched the provided name and SSN.");
		return null;
	}
	
	/*
	 * returns true if the person exists in the bucket
	 */
	public boolean contains(Person p)
	{
		for (int i = 0; i < MAX_SIZE; i++)
		{
			if (people[i] != null)
			{
				if (people[i].equals(p))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	/*
	 * returns the number of items in the array
	 */
	public int size()
	{
		int count = 0;
		
		for (int i = 0; i < MAX_SIZE; i++)
		{
			if (people[i] != null)
			{
				count++;
			}
		}
		
		return count;
	}
	
	/*
	 * prints the bucket
	 */
	public void print()
	{
		for (int i = 0; i < MAX_SIZE; i++)
		{
			if (people[i] != null)
			{
				people[i].print();
			}
			else
			{
				System.out.println("\t---");
			}
		}
	}
}
