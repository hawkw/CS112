import com.clarkware.Profiler;

import java.util.Random;
import java.io.*;

public class SortingExperiment
{
  
  private static int NUM_EXPERIMENTS = 5;
  private static int EXPERIMENT_SIZE = 10;
  private static boolean verbose = false;
  
  /** This method calls all of the different experiments and uses the 
   * Profiler tool in order to collect profiling information */
  public static void main(String[] args)
  {
    
      for (String arg : args) {
          
            if(arg.equals("verbose"))
            {
                
                verbose = true;
                      
            } else {
                EXPERIMENT_SIZE = Integer.parseInt(arg);
            }
      }

    
    experimentBubbleSort(EXPERIMENT_SIZE);
    experimentSelectionSort(EXPERIMENT_SIZE);
    experimentInsertionSort(EXPERIMENT_SIZE);
    experimentMergeSort(EXPERIMENT_SIZE);
    experimentQuickSort(EXPERIMENT_SIZE);
    
    Profiler.print(new PrintWriter(System.out));
    
  }
  
  /** This method is responsible for generating an array of a specified size 
   * that contains completely random ints inside of it.  This method can be 
   * used in each of the methods that actually conduct the experiments */
  public static int[] createInput(int size)
  {
   
    int[] values = new int[size];
    
    //Random generator = new Random((long)1.0);
    Random generator = new Random();
    
    for(int i = 0; i < size; i++)
    {
      
      int next_value = generator.nextInt();
      values[i] = next_value;
      
    }
    
    return values;
    
  }
  
  /** This method is responsible for producing a String representation of our 
   * array so that we can easily print out the values.  This is useful when we 
   * want to demonstrate that our sorting algorithm worked properly */
  public static String arrayString(int[] values, int size)
  {
    
    StringBuffer value_buffer = new StringBuffer();
    for(int i = 0; i < size; i++)
    {
      
      value_buffer.append(values[i]);
      
      if(i < size)
      {
        
        value_buffer.append("\n");
        
      }
      
    }
    
    return value_buffer.toString();
    
  }
  
  /** This method conducts an experiment with the BubbleSort sorting algorithm */
  public static void experimentBubbleSort(int size)
  {
    
    for(int i = 0; i < NUM_EXPERIMENTS; i++)
    {
      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);
    
      if( verbose )
        System.out.println("Initial values: " + arrayString(values,size));   
    
      Profiler.begin("Bubble Sort");
      BubbleSort.bubbleSort(values, size);
      Profiler.end("Bubble Sort");
    
      if( verbose )
        System.out.println("Final values: " + arrayString(values,size));
    
    }
      
  }
  
  /** This method conducts an experiment with the SelectionSort sorting algorithm */
  public static void experimentSelectionSort(int size)
  {
    
    for(int i = 0; i < NUM_EXPERIMENTS; i++)
    {
     
      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);
    
      if( verbose )
        System.out.println("Initial values: " + arrayString(values,size));   
    
      Profiler.begin("Selection Sort");
      SelectionSort.selectionSort(values, size);
      Profiler.end("Selection Sort");
    
      if( verbose )
        System.out.println("Final values: " + arrayString(values,size));
    
    }
      
  }
  
  /** This method conducts an experiment with the Insertion Sort algorithm */
  public static void experimentInsertionSort(int size)
  {
    
    for(int i = 0; i < NUM_EXPERIMENTS; i++)
    {
     
      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);
    
      if( verbose )
        System.out.println("Initial values: " + arrayString(values,size));   
    
      Profiler.begin("Insertion Sort");
      InsertionSort.insertionSort(values, size);
      Profiler.end("Insertion Sort");
    
      if( verbose )
        System.out.println("Final values: " + arrayString(values,size));
    
    }
    
  }
  
  /** This method conducts an experiment with the Merge Sort algorithm */
  public static void experimentMergeSort(int size)
  {
    
    for(int i = 0; i < NUM_EXPERIMENTS; i++)
    {
     
      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);
    
      if( verbose )
        System.out.println("Initial values: " + arrayString(values,size));   
    
      Profiler.begin("Merge Sort");
      MergeSort.mergeSort(values, size);
      Profiler.end("Merge Sort");
    
      if( verbose )
        System.out.println("Final values: " + arrayString(values,size));
    
    }
    
  }
  
  public static void experimentQuickSort(int size)
  {
    
    for(int i = 0; i < NUM_EXPERIMENTS; i++)
    {
     
      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);
    
      if( verbose )
        System.out.println("Initial values: " + arrayString(values,size));   
    
      Profiler.begin("Quick Sort");
      QuickSort.quickSort(values, size);
      Profiler.end("Quick Sort");
    
      if( verbose )
        System.out.println("Final values: " + arrayString(values,size));
    
    }
    
  }
  
}
