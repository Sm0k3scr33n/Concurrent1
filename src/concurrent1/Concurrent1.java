/*
This program represents concurrency.
in this program we set up an atomic integer value for the count variable and this
can be modified by all of the threads concurrently so that every thread knows
what the count value is and can access and incriment it.


 */
package concurrent1;

import java.lang.Thread.*;
import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author Michael Gabbard
 */

class SimpleThreadCounter extends Concurrent1 implements Runnable{
    public void atomic(){   
        //we use the atomic count variable to get() our value until it is 100 
        while (count.get() < 1000) 
        {
            try{
                Thread.sleep(100);
                
                } catch (InterruptedException ex)
                {}catch (ConcurrentModificationException ex){}
               System.out.println(Thread.currentThread().getName() +" "+count);
               count.getAndIncrement();
        }
    }
      
   public void run()
    {   
         //using the run() method of the class to call the atomic(); method 
       atomic();                           
    }   
}

 class Concurrent1  {
   
    public AtomicInteger count = new AtomicInteger(0);
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        
            // TODO code application logic here
            SimpleThreadCounter funwiththreads = new SimpleThreadCounter();
            Thread one = new Thread(funwiththreads);
            Thread two = new Thread(funwiththreads);
            
            one.setName("Thread_1");
            two.setName("Thread_2");
            
            one.start();
            two.start();
            
       
        
       
    
   
    }
    
}
