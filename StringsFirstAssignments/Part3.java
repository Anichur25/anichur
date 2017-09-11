
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
    
    public String lastPart(String stringa,String stringb)
    {
        int first_string_len = stringa.length();
        int second_string_len = stringb.length();
        
        String answer = stringb;
        
        int firstOccurance = stringb.indexOf(stringa);
        
        if(firstOccurance != -1){
           answer = stringb.substring(firstOccurance + first_string_len , second_string_len);
        }
        
        return answer;
    }
    
    public void testing()
    {
        String a = "bby";
        String b = "A story by Abby Long";
        System.out.println( twoOccurrences(a,b) );
        
        a = "by";
        b = "A story by Abby Long";
        System.out.println( twoOccurrences(a,b) );
        
        a = "an";
        b = "banana";
        
        System.out.println(lastPart(a,b));
        
        a = "zoo";
        b = "forest";
        
        System.out.println(lastPart(a,b));
        
        a = "anis";
        b = "anisur";
        
        System.out.println(lastPart(a,b));
        
        
    }
}
