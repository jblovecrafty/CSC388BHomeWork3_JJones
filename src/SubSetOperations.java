import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * This is the class to hold all of our operations on the linked list and subset
 */

/**
 * @author joejones
 *
 */
public class SubSetOperations
{

    /*Set up vars and constants*/
    
    //reference to the linked list
    //
    private LinkedList linkList;
    
    //hold the references to the various parts of the linked list
    //
    private Node nNode;
    private Node startNode;
        
    /*Set up methods here*/
    
    /**
     * this method reads a file into a linked list and parses the ints in the files
     * @param String: passedFile name of the file
     * @param LinkedList: passedList the list of ints
     */
    public void readFileInToLinkedList(String passedFile, LinkedList passedList)
    {
        //string to hold read in line
        //
        String lineOfText = "";
        
        //wrapping in try catch for safety
        //
        try 
        {
            //set up our file reader
            //
            FileReader fileReader = new FileReader(passedFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //read in the text and process it
            //
            while((lineOfText = bufferedReader.readLine()) != null) 
            {
                //ok now to parse out each int in the line
                //
                StringTokenizer stringToBeWorkedOn = new StringTokenizer(lineOfText);
                
                while (stringToBeWorkedOn.hasMoreElements()) 
                {  
                    //parse out the ints
                    //
                    int number = Integer.parseInt(stringToBeWorkedOn.nextElement().toString());
                    
                    //create node and add number to it
                    //
                    Node newNode = new Node(number);
                    
                    //add items to linked list
                    //
                    passedList.appendNode(newNode);
                }
                
                //set the linked list to the internal linked list
                //
                this.setLinkList(passedList);
            }   

            bufferedReader.close();         
        }
        //in case bad things happen
        //
        catch(IOException ex)
        {
            ex.printStackTrace();                  
        }
    }
    
    
    /**
     * getLargestNodeWithInt: gets the node with the largest value and returns 
     * it. This method also sets this classes internal nNode with it
     * @return Node with largest data value
     */
    public Node getLargestNodeWithInt()
    {
        //ok set up the nodes to hold the current max node reference
        //and the currentNode
        //
        Node currentMax = this.getLinkList().getFrontNode();
        Node currentNode  = this.getLinkList().getFrontNode();
        
        while(currentNode != null)
        {
            Node nodeToTest = currentNode;
            
            if(nodeToTest.getData() > currentMax.getData())
            {
                currentMax = nodeToTest;
            }
            
            currentNode = currentNode.getNextNode();
        }
        
        this.setnNode(currentMax);
        return currentMax;       
    }
    
    /**
     * This calculates if we can even attempt to find two subsets that equal to N
     * @return boolean: true if we can subset this linked list of numbers and false if we can't
     */
    public boolean isInitiallySubSetAble()
    {
        int total = 0;
        int resultOfTotal = 0;
        boolean isSubSetAble = false;
        
        this.setnNode(this.getLargestNodeWithInt());
        
        Node startNode  = this.getLinkList().getFrontNode();
        
        //ok loop thru the linked list and add up all of the non max node
        //ints
        //
        while(startNode != null)
        {
            Node nodeToTest = startNode;
            
            //loop thru but skip over nNode
            //
            if(!nodeToTest.equals(this.getnNode()))
            {
                total += nodeToTest.getData();
            }
            
            startNode = startNode.getNextNode();
        }
        
        //ok now divide by two and see if it equals largest int
        //
        resultOfTotal = (total/2);
        
        if(resultOfTotal == this.getnNode().getData())
        {
            isSubSetAble = true;
        }
        
        return isSubSetAble;
    }
    
    /**
     * This is the work horse method that recurses thru the linked list and finds out if there is
     * at least one set of numbers that add up to the max number
     * @param Node: passedNode node to check
     * @param int: passedMaxNumber the number we are trying to find
     * @param int: passedTotalSoFar the total so far
     * @return true if this set contains a grouping that adds to the max and false if it doesnt
     */
    boolean doesThisSetContainAGroupingThatAddsToMax(Node passedNode, int passedMaxNumber, int passedTotalSoFar) 
    {
        //ok we have found the number we want so lets return true
        //
        if (passedTotalSoFar == passedMaxNumber)
        {
            return true; 
        }
        
        //we are at the end of the linked list so lets leave
        //
        if (passedNode == null || passedTotalSoFar > passedMaxNumber)
        {
            return false;
        }
        
        //Ok, so we want to try a call with the current passed Node data and without so lets do that
        //put this nodes number into a temp var and if the node isnt the maxNode then lets
        //plop the number in the temp node otherwise just add 0 to it
        //
        int tempSum = 0;
        if(passedNode != this.getnNode())
        {
            tempSum = passedNode.getData();
        }
        
        //move us on to the next link in the chain
        //
        passedNode = passedNode.getNextNode();
    
        //call this method recursively with the item in the total and out of the total
        //
        boolean with = doesThisSetContainAGroupingThatAddsToMax(passedNode, passedMaxNumber,  passedTotalSoFar + tempSum); 
        boolean without = doesThisSetContainAGroupingThatAddsToMax(passedNode, passedMaxNumber, passedTotalSoFar);
        
        //neat little trick I picked up whilst researching how to solve this problem
        //
        return (with || without);
       
    }
    

    /**
     * This method returns a boolean true if we can subset the passed in text file so that
     * there are two subsets equal to the largest number N otherwise we return false
     */
    public boolean isPassedTextFileSubSetable(String passedFileName)
    {
        boolean isSubsetAble = false;
        
        //do some set up so we can get checking
        //
        LinkedList list = new LinkedList();
        
        this.readFileInToLinkedList(passedFileName,list);
        this.setnNode(this.getLargestNodeWithInt());
        this.setStartNode(this.linkList.getFrontNode());
        
        //ok now check the easy cases where we dont have a obvious subset to N
        //
        if(this.isInitiallySubSetAble())
        {
            isSubsetAble = this.doesThisSetContainAGroupingThatAddsToMax(startNode, this.nNode.getData(), 0);
        }
        
        return isSubsetAble;

    }


    /**
     * @return the linkList
     */
    public LinkedList getLinkList()
    {
        return linkList;
    }


    /**
     * @param linkList the linkList to set
     */
    public void setLinkList(LinkedList linkList)
    {
        this.linkList = linkList;
    }


    /**
     * @return the nNode
     */
    public Node getnNode()
    {
        return nNode;
    }


    /**
     * @param nNode the nNode to set
     */
    public void setnNode(Node nNode)
    {
        this.nNode = nNode;
    }


    /**
     * @return the startNode
     */
    public Node getStartNode()
    {
        return startNode;
    }


    /**
     * @param startNode the startNode to set
     */
    public void setStartNode(Node startNode)
    {
        this.startNode = startNode;
    }
}
