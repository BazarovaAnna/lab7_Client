package manage;

public class JasonException extends Exception{
    JasonException(String msg){
        super(msg);
    }
}

class CountEx extends Exception{
    public void coun_err(){
        System.out.println((char) 27 + "[31mERROR!!! Unknown command " + (char)27 + "[0m");
    }
}