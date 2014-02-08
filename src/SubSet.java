/**
 *Main Class of this CSC388B Homework 3 
 */

/**
 * @author joejones
 *
 */
public class SubSet
{
    //constant for the file name
    //
    private static final String FILE_NAME = "in.txt";
    
    //constants for true and false sets
    //
    private static final String FILE_SUBSET_TRUE    = "Yes";
    private static final String FILE_SUBSET_FALSE   = "No";

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        //ok lets check if the passed in file is able to have some N and then to find two subsets within the
        //remaining numbers
        //
        boolean isSubSetAble = false;
        
        SubSetOperations subOps = new SubSetOperations();
        
        isSubSetAble = subOps.isPassedTextFileSubSetable(FILE_NAME);
        
        //now lets print out the results
        //
        if(isSubSetAble)
        {
            System.out.println(FILE_SUBSET_TRUE);
        }
        else
        {
            System.out.println(FILE_SUBSET_FALSE);
        }
        
        

    }

}
