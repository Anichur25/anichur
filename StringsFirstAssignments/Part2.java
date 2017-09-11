public class Part2
{
    public String findSimpleGene(String dna , String startCodon, String stopCodon)
    {
        String result = "";
        
        int startIndex = dna.indexOf(startCodon);
        int stopIndex = dna.indexOf(stopCodon , startIndex + 3);
        
        while(stopIndex!=-1)
        {
            if((stopIndex - startIndex ) % 3 == 0)
            {
                return dna.substring(startIndex , stopIndex + 3);
            }
            else
            {
                stopIndex = dna.indexOf(stopCodon , stopIndex + 1);
            }
        }
        return result;
        
    }
    
    public void testgene()
    {
        String dna = "ATGCCTAAATGTAAATTAA";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("DNA Strand: " + dna + "\nGene: " + gene );
        dna = "ATGTAA";
        gene = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println("DNA Strand: " + dna + "\nGene: " + gene );
        
    }
}
