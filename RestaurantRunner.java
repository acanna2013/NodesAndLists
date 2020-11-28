import java.util.*;
import static java.lang.System.*;

public class RestaurantRunner
{
	public static void main ( String[] args )
	{
		ListNode z = new ListNode("cheese",
	 			new ListNode("pepperoni",
      		new ListNode("onions",
       		new ListNode("peppers",
	 			new ListNode("bacon",
      		new ListNode("pineapple",
       		new ListNode("sausage",		       		
	 			new ListNode("garlic",null))))))));
			 			
		out.println("Worksheet LL#2 Runner\n\n");	
		
		out.println("Original list values\n");	
		out.print("\t");
		Restaurant.print(z);
		out.println("\n");
	
		
		out.println("\t num nodes = " + Restaurant.nodeCount(z));

		out.println("\nList values after call0ing nodeCount\n");	
		out.print("\t");
		Restaurant.print(z);
		out.println();	

		Restaurant.doubleFirst(z);		
		out.println("\nList values after calling doubleFirst\n");							
		out.print("\t");
		Restaurant.print(z);
		out.println();	
		
		
		Restaurant.doubleLast(z);		
		out.println("\nList values after calling doubleLast\n");							
		out.print("\t");
		Restaurant.print(z);
		out.println();		
		
//		Restaurant.skipEveryOther(z);		
//		out.println("\nList values after calling skipEveryOther\n");							
//		out.print("\t");
//		Restaurant.print(z);
//		out.println();

		Restaurant.removeXthNode(z,2);		
		out.println("\nList values after calling removeXthNode(2)\n");					
		out.print("\t");
		Restaurant.print(z);
		out.println();			
		
		Restaurant.setXthNode(z,2,"PIZZA!");		
		out.print("\t");
		out.println("\nList values after calling setXthNode(2,PIZZA!)\n");										
		out.print("\t");
		Restaurant.print(z);
		out.println();				
	}
}




/*
 * --------------------------------------------------------------
 * RUNNER FOR NONSTATIC RESTAURANT
 */
//import java.util.*;
//import static java.lang.System.*;
//
//public class RestaurantRunner
//{
//	public static void main ( String[] args )
//	{
//		ListNode z = new ListNode("cheese",
//	 			new ListNode("pepperoni",
//      		new ListNode("onions",
//       		new ListNode("peppers",
//	 			new ListNode("bacon",
//      		new ListNode("pineapple",
//       		new ListNode("sausage",		       		
//	 			new ListNode("garlic",null))))))));
//		
//		Restaurant one = new Restaurant(z);	
//		out.println("Worksheet LL#2 Runner\n\n");	
//		
//		out.println("Original list values\n");	
//		out.print("\t");
//		one.print();
//		out.println("\n");
//	
//		
//		out.println("\t num nodes = " + one.nodeCount());
//
//		out.println("\nList values after calling nodeCount\n");	
//		out.print("\t");
//		one.print();
//		out.println();	
//
//		one.doubleFirst();		
//		out.println("\nList values after calling doubleFirst\n");							
//		out.print("\t");
//		one.print();
//		out.println();	
//		
//		
//		one.doubleLast();		
//		out.println("\nList values after calling doubleLast\n");							
//		out.print("\t");
//		one.print();
//		out.println();		
//		
////		one.skipEveryOther();		
////		out.println("\nList values after calling skipEveryOther\n");							
////		out.print("\t");
////		one.print();
////		out.println();
//
//		one.removeXthNode(2);		
//		out.println("\nList values after calling removeXthNode(2)\n");					
//		out.print("\t");
//		one.print();
//		out.println();			
//		
//		one.setXthNode(2,"PIZZA!");		
//		out.print("\t");
//		out.println("\nList values after calling setXthNode(2,PIZZA!)\n");										
//		out.print("\t");
//		one.print();
//		out.println();				
//	}
//}
//
//
