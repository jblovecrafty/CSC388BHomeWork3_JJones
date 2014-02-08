/**
 * This class allows us to read in a text file and then parse out the numbers as ints
 * then we read it into a linked list and scan it for the largest number
 */
import java.io.*;

/**
 * @author joejones
 *
 */
public class SubsetChecker
{
    //constant for the file name
    //
    private static final String FILE_NAME = "in.txt";
    
    /**
     * @param args
     */
    public static void main(String[] args)
    {
        
        //set up the linked list here
        //
        Node maxNode = new Node(0);
        LinkedList list = new LinkedList();
        SubSetOperations subOps = new SubSetOperations();
        boolean isSetAble = false;
        
        subOps.readFileInToLinkedList(FILE_NAME,list);
        maxNode = subOps.getLargestNodeWithInt();
        System.out.println("Max Node Number" + maxNode.getData());
        
        //subOps.checkSubSetAblity(0, maxNode.getData(), subOps.linkList.getFrontNode(), 0);
        //System.out.print(subOps.linkList.getListSize());
    }

}
