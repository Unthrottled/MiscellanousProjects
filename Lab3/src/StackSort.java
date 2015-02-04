

import java.util.Stack;

public class StackSort {

    // iterative solution to part A
    /** Task: Sorts a stack.
     *  @return a sorted stack */
    public static <T extends Comparable<T>>
                Stack<T> iterativeSortA(Stack<T> stack)
    {
        Stack<T> s1 = stack;
        Stack<T> s2 = new Stack<T>();
        Stack<T> s3 = new Stack<T>();

        //Task 1. Move the top of s1 to s2 to start it all off
        s2.add(s1.pop());

				//while s1 is not empty
		//while s1 is not empty
        while (!s1.empty())
        {
        		//Task 2.1. pop and consider the top entry of s1
            T t = s1.pop();
            while(!s2.isEmpty()&&t.compareTo(s2.peek())>0){
            	s3.add(s2.pop());
;            }
            //Task 2.2. Pop entries of stack s2 and push them onto stack s3 until you reach the correct place to put t
            s2.push(t);
            while(!s3.isEmpty()){
            	s2.add(s3.pop());
            }
            //Task 2.3. Push t onto s2
            

            //Task 2.4. Move all entries from s3 to s2
            
            
        } // end while

        return s2;
    } // end iterativeSortA

    // iterative solution to part B
    /** Task: Sorts a stack.
     *  @return a sorted stack */
    public static <T extends Comparable<T>>
                   Stack<T> iterativeSortB(Stack<T> stack)
    {
        
        		Stack<T> s1 = stack;
				Stack<T> s2 = new Stack<T>();
				Stack<T> s3 = new Stack<T>();
			
				//Task 3. Move the top of s1 to s2 to start it all off
				s2.add(s1.pop());
				
			  //while s1 is not empty
				while (!s1.empty())
				{
					 //Task 4.1. pop and consider the top entry of s1
			  		T t = s1.pop();
			
			      /* One or the other of the following two loops will move entries:
			       * Task 4.2.	Compare it to the top entries of both s2 and s3.  
			       * While it¡¯s larger than the top entry of s2, move entries from s2 to s3, 
			       * or while it¡¯s smaller than the top entry of s3, move entries from 
			       * s3 to s2 until you reach the correct place to put t. 
			      */
			
			     
			    while(!s2.isEmpty()&&t.compareTo(s2.peek())>0) //Task 4.2.1 Move smaller entries from s2 to s3
			    	  {
			    		  s3.add(s2.pop());
			    	  }
			     while(!s3.isEmpty()&&t.compareTo(s3.peek())<0) //Task 4.2.2 Move larger entries from s3 to s2
			     {
			    	 	s2.add(s3.pop());
			     }
			     s2.add(t);//Task 4.3. Push t onto s2
			      			      
			    } // end while
			
				  //Task 5. Move any remaining entries from s3 to s2
			    while(!s3.isEmpty()){
			    	s2.add(s3.pop());
			    }
			    
			
			   return s2;
		} // end iterativeSortB

}