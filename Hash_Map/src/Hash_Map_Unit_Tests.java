import static org.junit.Assert.*;

import org.junit.Test;

public class Hash_Map_Unit_Tests 
{
	/*
	 * ************************************************************************
	 * Person Tests
	 */
	@Test
	public void Person_Constructor_Test()
	{
		Person p = new Person("Dave", 1234567);
		
		if (!p.get_name().equals("Dave"))
		{
			fail();
		}
		
		if (p.get_ssn() != 1234567)
		{
			fail();
		}
	}
	
	/*
	 * ************************************************************************
	 * Hash Bucket Tests
	 */
	
	@Test
	public void Hash_Bucket_Constructor_Test()
	{
		Hash_Bucket bucket = new Hash_Bucket();
		
		if (bucket.size() != 0)
		{
			fail();
		}
	}	
	
	@Test
	public void Hash_Bucket_Add_Person_Test()
	{
		Hash_Bucket bucket = new Hash_Bucket();
		
		bucket.add_person(new Person("Dave", 1234));
		bucket.add_person(new Person("Samantha", 12345));
		
		if (bucket.size() != 2)
		{
			fail();
		}
	}	
	
	@Test
	public void Hash_Bucket_Contains_Person_Test()
	{
		Hash_Bucket bucket = new Hash_Bucket();
		
		bucket.add_person(new Person("Dave", 1234));
		bucket.add_person(new Person("Samantha", 12345));
		
		if (!bucket.contains(new Person("Dave", 1234)))
		{
			fail();
		}
		
		if (bucket.contains(new Person("Isabel", 1122)))
		{
			fail();
		}
	}	
	
	@Test
	public void Hash_Bucket_Remove_Person_Test()
	{
		Hash_Bucket bucket = new Hash_Bucket();
		
		bucket.add_person(new Person("Dave", 1234));
		bucket.add_person(new Person("Samantha", 12345));
		bucket.add_person(new Person("Isabel", 13457));
		
		if (bucket.size() != 3)
		{
			fail();
		}
		
		bucket.remove_person(new Person("Dave", 1234));
		bucket.remove_person(new Person("Samantha", 12345));
		
		if (bucket.size() != 1)
		{
			fail();
		}
	}
	
	@Test
	public void Hash_Bucket_Remove_And_Add_Test()
	{
		Hash_Bucket bucket = new Hash_Bucket();
		
		bucket.add_person(new Person("Dave", 1234));
		bucket.add_person(new Person("Samantha", 12345));
		bucket.add_person(new Person("Isabel", 13457));
		
		if (bucket.size() != 3)
		{
			fail();
		}
		
		bucket.remove_person(new Person("Samantha", 12345));
		bucket.add_person(new Person("Ellis", 3452345));
		
		if (bucket.size() != 3)
		{
			fail();
		}
	}
	
	/*
	 * ************************************************************************
	 * Hash Table Tests
	 */
	
	@Test
	public void Hash_Map_Constructor_Test()
	{		
		Hash_Map map = new Hash_Map();
		
		if (map.size() != 0)
		{
			fail();
		}
	}
	
	@Test
	public void Hash_Map_Add_People_Test()
	{		
		Hash_Map map = new Hash_Map();
		
		map.add_person(new Person("Dave", 1234));
		map.add_person(new Person("Samantha", 12345));
		map.add_person(new Person("Isabel", 13457));
		
		if (map.size() != 3)
		{
			fail();
		}
		
		map.add_person(new Person("Davie", 12341));
		map.add_person(new Person("Samanthu", 123415));
		map.add_person(new Person("Isabella", 134571));
		
		if (map.size() != 6)
		{
			fail();
		}
	}
	
	@Test
	public void Hash_Map_Contains_Test()
	{		
		Hash_Map map = new Hash_Map();
		
		map.add_person(new Person("Dave", 1234));
		map.add_person(new Person("Samantha", 12345));
		map.add_person(new Person("Isabel", 13457));
		
		if (!map.contains(new Person("Dave", 1234)))
			fail();
		if (!map.contains(new Person("Samantha", 12345)))
			fail();
		if (!map.contains(new Person("Isabel", 13457)))
			fail();
		
		if (map.contains(new Person("Joe", 66545545)))
			fail();		
	}	
	
	@Test
	public void Hash_Map_Remove_People_Test()
	{		
		Hash_Map map = new Hash_Map();
		
		map.add_person(new Person("Dave", 1234));
		map.add_person(new Person("Samantha", 12345));
		map.add_person(new Person("Isabel", 13457));
		
		map.remove_person(new Person("Dave", 1234));
		if (map.size() != 2)
			fail();
			
		map.remove_person(new Person("Samantha", 12345));
		if (map.size() != 1)
			fail();
		
		map.remove_person(new Person("Isabel", 13457));
		if (map.size() != 0)
			fail();
	}
}
