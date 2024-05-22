package org.pompage;

import java.util.ArrayList;
import java.util.List;



public class aaa {
	
	public void test1()
	{
	
	List<String> l1=new ArrayList<String>();
	l1.add(1,"Ankit");
	l1.add(2, "Shridhar");
	l1.add(3, "Ashish");
	
	System.out.println(l1.size());
	System.out.println(l1.get(2));
	l1.remove(2);
	System.out.println(l1.get(2)+""+ l1.get(0));
	
	
	}
	
	public static void main(String...a)
	{
		aaa a1=new aaa();
		a1.test1();
	}


}
