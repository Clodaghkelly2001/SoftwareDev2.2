public class demo {

    public static String swap (String s, int i, int j)
    {
        char [] ca = s.toCharArray();
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;

        return "" + new String(ca);
    }

    public static void jumble (String s)
    {
        char firstLetter = s.charAt(0);
        char lastLetter = s.charAt(s.length()-1);

        String toRandomise = s.substring( 1, s.length()-1);

        for(int i =0; i <toRandomise.length()/2; i++)
        {
            toRandomise = swap(toRandomise, i, (toRandomise.length()-1 -i));
        }

        String rebuilt = firstLetter + toRandomise + lastLetter;

        System.out.println(rebuilt);

    }

    public static void main(String[] args) {
        jumble("computer");
    }

}
