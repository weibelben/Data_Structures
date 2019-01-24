import java.util.ArrayList;
import java.util.List;

/*
 * This hash map sorts people. There will be 26 hashable locations.
 * One for each letter of the English alphabet. When a person is added or 
 * looked up, the first letter of their name will indicate which bucket 
 * that person should reside in.
 */
public class Hash_Map 
{
	private static int NUM_BUCKETS = 26;
	private List<Hash_Bucket> map;
	private int num_items;	
	
	public Hash_Map()
	{
		map = new ArrayList<Hash_Bucket>(NUM_BUCKETS);
		
		for (int i = 0; i < NUM_BUCKETS; i++)
		{
			map.add(new Hash_Bucket());
		}
		
		num_items = 0;
	}	
	
	/*
	 * adds a person to the hash map
	 */
	public void add_person(Person p)
	{
		int index = hash_to_index(p.get_name());		
		Hash_Bucket bucket = map.get(index);
		bucket.add_person(p);
		num_items++;
	}
	
	/*
	 * removes a person from the hash map
	 */
	public Person remove_person(Person p)
	{
		int index = hash_to_index(p.get_name());	
		num_items--;
		return map.get(index).remove_person(p);		
	}
	
	/*
	 * returns true if the specified person exists in the map
	 */
	public boolean contains(Person p)
	{
		int index = hash_to_index(p.get_name());
		return map.get(index).contains(p);
	}
	
	/*
	 * returns the index [0 to 25] of the name specified
	 */
	private int hash_to_index(String name)
	{
		char c = name.toUpperCase().toCharArray()[0];
		switch(c)
		{
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		case 'D':
			return 3;
		case 'E':
			return 4;
		case 'F':
			return 5;
		case 'G':
			return 6;
		case 'H':
			return 7;
		case 'I':
			return 8;
		case 'J':
			return 9;
		case 'K':
			return 10;
		case 'L':
			return 11;
		case 'M':
			return 12;
		case 'N':
			return 13;
		case 'O':
			return 14;
		case 'P':
			return 15;
		case 'Q':
			return 16;
		case 'R':
			return 17;
		case 'S':
			return 18;
		case 'T':
			return 19;
		case 'U':
			return 20;
		case 'V':
			return 21;
		case 'W':
			return 22;
		case 'X':
			return 23;
		case 'Y':
			return 24;
		case 'Z':
			return 25;
		default:
			System.out.println(name + " does not begin with a letter.");
			System.exit(1);
		}
		
		return -1;
	}
	
	/*
	 * returns the number of items in the hash map
	 */
	public int size()
	{
		return num_items;
	}
	
	/*
	 * prints the hash map
	 */
	public void print()
	{
		for (int i = 0; i < NUM_BUCKETS; i++)
		{
			Hash_Bucket bucket = map.get(i);
			if (bucket.size() > 0)
			{
				bucket.print();
			}
			else
			{
				// the bucket is empty
				System.out.println("---");
			}
		}
	}
}
