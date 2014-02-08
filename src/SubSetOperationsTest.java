import org.junit.Test;

import junit.framework.TestCase;
/**
 * This is a test suite so that I can use a variety of test cases
 */

/**
 * @author joejones
 *
 */
public class SubSetOperationsTest extends TestCase
{

    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    /* (non-Javadoc)
     * @see junit.framework.TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }
    
    @Test
    public void testSimpleCase() 
    {
        //set up the linked list here
        //
        System.out.println("Run Simple Test with set of ints 1 2 4 3 2 6");

        SubSetOperations subOps = new SubSetOperations();
        
        boolean test = subOps.isPassedTextFileSubSetable("inSimple.txt");
        
        System.out.println(test);
        
        //subOps.checkSubSetAblity(0, maxNode.getData(), subOps.linkList.getFrontNode(), 0);
    }
    
    @Test
    public void testSimpleFalseCase() 
    {
        //set up the linked list here
        //
        System.out.println("Run Simple False Test with set of ints 1 1 3");
        
        SubSetOperations subOps = new SubSetOperations();
        
        boolean test = subOps.isPassedTextFileSubSetable("inSimpleFalseCase.txt");
        
        System.out.println(test);
    }
    
    @Test
    public void testComplexCase() 
    {
        //set up the linked list here
        //
        System.out.println("Run Complex Test with set of ints 4 5 1 4 5 1 4 12");
        
        SubSetOperations subOps = new SubSetOperations();
        
        boolean test = subOps.isPassedTextFileSubSetable("inComplexCase.txt");
        
        System.out.println(test);
    }
    
    @Test
    public void testComplexFalseCase() 
    {
        //set up the linked list here
        //
        System.out.println("Run Complex Test with set of ints 5 4 4 2");
        
        SubSetOperations subOps = new SubSetOperations();
        
        boolean test = subOps.isPassedTextFileSubSetable("inComplexFalseCase.txt");
        
        System.out.println(test);
    }
    
    @Test
    public void testOneSidedCase() 
    {
        //set up the linked list here
        //
        System.out.println("Run Complex Test with set of ints 1 6 1 6");
        
        SubSetOperations subOps = new SubSetOperations();
        
        boolean test = subOps.isPassedTextFileSubSetable("inOdd.txt");
        
        System.out.println(test);
    }
    
    @Test
    public void testBaseCase() 
    {
        //set up the linked list here
        //
        System.out.println("Run Simple Test with set of ints 1 2 4 3 2 6");

        SubSetOperations subOps = new SubSetOperations();
        
        boolean test = subOps.isPassedTextFileSubSetable("in.txt");
        
        System.out.println(test);
        
        //subOps.checkSubSetAblity(0, maxNode.getData(), subOps.linkList.getFrontNode(), 0);
    }
    
    

}
