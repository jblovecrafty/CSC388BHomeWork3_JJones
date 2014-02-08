/**
 * This is the node class for our linked list
 * I would make an abstract class called node and then have the node class that can
 * handle ints be subclassed but I didnt know how much you wanted focus on that or the
 * assignment
 */

/**
 * @author joejones
 *
 */
public class Node 
{
 /*Set up variables here*/
    
    
    //this is the variable used to hold the reference to the next node in the linked list
    //
    private Node nextNode;
    
    //this is the var used to hold the data in the node
    //
    private int data;
    
    /*Set up methods here*/
    
    /**
     * This is the parameter-less constructor for this class
     * everything defaults to null/0
     */
    public Node()
    {
        this.data           = 0;
        this.nextNode       = null;
    }
    
    /**
     * This is the constructor where we pass in an int to be held by the node
     * @param int passedInt: an int
     */
    public Node(int passedInt)
    {
        this.data           = passedInt;
        this.nextNode       = null;
    }
    
    /**
     * This is the mutator for the nextNode value
     * @param node passedNode: a reference to the node that is next to this one
     */
    public void setNextNode(Node passedNode)
    {
        this.nextNode = passedNode;
    }
    
    /**
     * THis is the accessor for the next node reference
     * @return node NextNode: reference to the next node (in relation to this one)
     */
    public Node getNextNode()
    {
        return this.nextNode;
    }
    
    /**
     * This is the mutator for the int that is being held by this node
     * @param int passedInt: the int
     */
    public void setData(int passedInt)
    {
        this.data = passedInt;
    }
    
    /**
     * This is the accessor for the data int being held by this node
     * @return int
     */
    public int getData()
    {
        return this.data;
    }
    
}
