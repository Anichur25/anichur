public class Part2
{
    public String findSimpleGene(String dna)
    {
        String result = "";
        
        int startIndex = dna.indexOf("ATG");
        int stopIndex = dna.indexOf("TAA" , startIndex + 3);
        
        while(stopIndex!=-1)
        {
            if((stopIndex - startIndex ) % 3 == 0)
            {
                return dna.substring(startIndex , stopIndex + 3);
            }
            else
            {
                stopIndex = dna.indexOf("TAA" , stopIndex + 1);
            }
        }
        return result;
        
    }
    
    public void testgene()
    {
        String dna = "ATGCCTAAATGTAAATTAA";
        String gene = findSimpleGene(dna);
        System.out.println("DNA Strand: " + dna + "\nGene: " + gene );
        
    }
}
