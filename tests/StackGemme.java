

import java.util.Stack;

/**
 * StackGemme
 */
public class StackGemme {
    private Stack<String> stackGemme;
    private String[] tabGemme = {"VIOLET","VIOLET","VIOLET","VIOLET","VERT", "VERT"};
    public StackGemme() {
        stackGemme = new Stack<String>();
        this.setUpStack();
    }
    public void setUpStack(){
        for (String s : tabGemme) 
            stackGemme.push(s);
    }
    /**
     * Methode renvoyer la gemme au dessus du stack
     * @return la gemme si trouvé sinon un string vide
     */
    public String viderStack(){
        if(stackGemme.size() > 0)
            return stackGemme.pop();
        return "";
    }
    
    public Stack<String> getStack(){
        return stackGemme;
    }
  
}