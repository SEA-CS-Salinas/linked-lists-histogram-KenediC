/*The HistoLlist class adds and accesses HistoNode elements through three methods. addLetter(), indexOf(), and nodeAt()
are all available for use. The class contains a single, non-parameterized constructor.
@author Kenedi Carson*/

//Import needed utilities
import java.util.*;
import static java.lang.System.*;

public class HistoList{
   private HistoNode front; //Instance variable representing the front of the Linked list

    /*Non-parameterized constructor of the HistoList class. Sets the variable front to null.*/
	public HistoList(){
		front = null;
	}

	/*The addletter() method adds a new node if it does not otherwise exist. If the letter is already attached 
	to a node, then the method will update the count of the given letter.
	@param char let
	@return void*/
	public void addLetter(char let){
        int index = indexOf(let);
        HistoNode temp = front;
        
            if(index == -1){
                front = new HistoNode(let, 1, front);
            }
            else{
                for(int i = 0; i < index; i++){
                    temp = temp.getNext();
                }
                temp.setLetterCount(temp.getLetterCount() + 1);
            }
	}

	/*The indexOf() method searches through the LinkedList using a while loop. If the given letter is found, the 
	index is returned. Otherwise, -1 is returned. 
	@param char let
	@return int count*/
	public int indexOf(char let){
	    int count = 0;
	    HistoNode temp = front;
	    while(temp != null){
	        if(let == temp.getLetter()){
	            return count;
	        }
	        temp = temp.getNext();
	        count++;
	    }
		return -1;
	}

	/*The nodeAt() method takes a given index value and returns the node in that index.
	@param int spot
	@return HistoNode current*/
	private HistoNode nodeAt(int spot){
		HistoNode current=null;
        for(int i = 0; i < spot; i++){
            current = front.getNext();
        }
		return current;
	}

	/*The toString() method returns each letter in the list as well as the total count of it.
	@param none
	@return String output*/
	public String toString(){
		String output = "";
		while(front != null){
		    output += String.valueOf(front.getLetter()) + " - " + String.valueOf(front.getLetterCount()) + "    ";
		    front = front.getNext();
		}
		return output;
	}
}
