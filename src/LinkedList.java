/**
 * This is the linked list class for nodes
 */

/**
 * @author joejones
 *
 */
public class LinkedList
{
    
 /*Set up the variables here*/
    
    //this is the variable to hold the front value for the linked list
    //
    private Node frontNode;
    
    //this is the variable to hold a reference to the back value for the linked list
    //
    private Node backNode;

    
    /*This is where constructors and methods are*/
    
    /**
     * This is the default constructor that takes no parameter
     */
    public LinkedList()
    {
        //set both nodes to null
        //
        this.frontNode  = null;
        this.backNode   = null;
    }
    
    /**
     * This is constructor takes one node to get things going
     */
    public LinkedList(Node passedNode)
    {
        //set both nodes to passedNode
        //
        this.frontNode  = passedNode;
        this.backNode   = passedNode;
    }

 
    /**
     * This is the method that allows us to append a node to the end of the list
     * @param Node passedNode: the node to be added to the linked
     * list
     */
    public void appendNode(Node passedNode)
    {
        
        //Check if this is the first node to be added to the list
        //
        if(this.backNode == null)
        {
            //ok so this is the first node in our linked list
            // so set frontNode and backNode to this node
            //
            this.frontNode  = passedNode;
            this.backNode   = passedNode;
        }
        else
        {
            //set the current backNode to have the passedNode as its nextNode reference
            //
            this.backNode.setNextNode(passedNode);
            
            //now set the backNode to refer to the passedNode making it the new backNode
            //
            this.backNode = passedNode;
        }
    }
    
    /**
     * THis is the protected mutator for the front node
     * @param node passedNode: the node reference to use for the front node
     */
    protected void setFrontNode(Node passedNode)
    {
        this.frontNode = passedNode;
    }
    
    /**
     * THis is the protected mutator for the back node
     * @param node passedNode: the node reference to use for the back node
     */
    protected void setBackNode(Node passedNode)
    {
        this.backNode = passedNode;
    }
    
    /**
     * This method is used for getting the node reference from the frontNode
     * @return node: the data object that the node is holding
     */
    public Node getFrontNode()
    {
        //first lets check if the list is empty and if it is the return null
        //Kinda lame but if there is a better way then please tell me
        //
        if(this.isEmpty())
        {
            return null;
        }
        else
        {
            return this.frontNode;
        }
    }
    
    /**
     * This method is used for getting the reference from the backNode
     * @return node: the backNode
     */
    public Node getBackNode()
    {
        //first lets check if the list is empty and if it is the return null
        //Kinda lame but if there is a better way then please tell me
        //
        if(this.isEmpty())
        {
            return null;
        }
        else
        {
            return this.backNode;
        }
    }  
    
    /**
     * This method is used to check if a linked list is empty not sure if we need it for this assignment
     * but I am including it anyway
     * @return boolean isEmptyValue: true if the linked list is empty false if it isnt
     */
    public boolean isEmpty()
    {
        //set up the boolean to return for this method
        //
        boolean isEmptyValue = true;
        
        if(this.frontNode != null)
        {
            //ok we are not empty so return isEmptyValue to false
            //
            isEmptyValue = false;
        }
        
        return isEmptyValue;
    }
}
