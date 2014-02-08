
public class subSetSumR
{

    boolean recSubset(Node a, int target, int i, int sumSoFar) {
      //basecases
      //we got it
        //
      if (sumSoFar == target) return true; 
      
      //we reached the end and sum is not equal to target
      //
      if (a == null) return false;
      
      //recursive case: try next element both in and out of the sum
      //
      
      a = a.getNextNode();
      
      boolean with = recSubset(a, target, i+1, sumSoFar + a.getData()); 
      boolean without = recSubset(a, target, i+1, sumSoFar);
      
      
      return (with || without);
      }
    
}
