package QTEAutomation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class aaa { 
	String st1="Ankit";
	String st2="Shridhar";
	StringBuffer sb;
	
	
	@Test(priority=-1)

	public void listTest()
	{
	
	List<String> l1=new ArrayList<String>();
	l1.add(1,"Ankit");
	l1.add(2, "Shridhar");
	l1.add(3, "Ashish");
	
	System.out.println(l1.size());
	System.out.println(l1.get(2));
	l1.remove(2);
	System.out.println(l1.get(1)+""+ l1.get(0));
	
	Set<String> s1=new HashSet<String>();
	s1.add("Ankit");
	Iterator<String> i1=s1.iterator();
	while(i1.hasNext())
	{
		i1.next();
	}
	
	
	}
	
	public void stringTest()
	{
		st1.charAt(1);
		st1.concat(" Sharma");
		boolean b1=st1.contains("i");
		System.out.println(b1);
		st1.toUpperCase();
		st1.toLowerCase();
		sb=new StringBuffer("Ankit");
		boolean b2=st1.equals(sb);
		System.out.println(st1==st2);//both object must be of same type, like String to String or StringBuffer to StringBuffer
	}
	
	
	
	public static void main(String...a)
	{
		aaa a1=new aaa();
		a1.listTest();
	}

}
