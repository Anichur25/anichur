
public class Part3
{
    public boolean twoOccurrences(String stringa,String stringb)
    {
        int Index = stringb.indexOf(stringa);
        
        boolean result = true;
        
        if(Index!= -1){
            
            Index = stringb.indexOf(stringa , Index + stringa.length() + 1 );
            
            if(Index == -1){
                
                result =  false;
            }
        }
        
        else{
            
            result = false;
        }
        
        return result;
    }
    
    public void testing()
    {
        String a = "bby";
        String b = "A story by Abby Long";
        System.out.println( twoOccurrences(a,b) );
        
        a = "by";
        b = "A story by Abby Long";
        System.out.println( twoOccurrences(a,b) );
        
        
    }
}
