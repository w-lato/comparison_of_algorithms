package mem;

// Following program is a Java implementation
// of Rabin Karp Algorithm given in the CLRS book

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class RabinKarp
{
    // d is the number of characters in input alphabet
    public final static int d = 256;


    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    public static ArrayList<Integer> search(String pat, String txt, int q)
    {
        ArrayList<Integer> indexes = new ArrayList<>();
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M-1; i++)
            h = (h*d)%q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++)
        {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if ( p == t )
            {
                /* Check for characters one by one */
                for (j = 0; j < M; j++)
                {
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    indexes.add(i);
                    //System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if ( i < N-M )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }

        return indexes;
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
//        String txt = "abcdefghijklmnoprestuwjklmn";;
//        String pat = "jklmn";

        String txt = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sodales pretium lorem, nec imperdiet neque sodales ac. Nam id molestie dui. Nulla aliquet mi nec elit maximus, ut aliquam felis gravida. Interdum et malesuada fames ac ante ipsum primis in faucibus. Morbi et tellus eu odio elementum suscipit volutpat quis sem. Duis venenatis dignissim augue pellentesque commodo. Nam iaculis accumsan orci, vel tempor lectus maximus sit amet. Quisque pretium arcu sit amet elementum iaculis. Nulla feugiat arcu non tempor scelerisque. Vivamus suscipit lacus sit amet imperdiet vestibulum. Praesent ornare augue posuere gravida porta. Aenean ac pharetra elit. Duis non ornare tortor. Suspendisse tellus tortor, feugiat nec sem ac, vulputate suscipit orci.\n" +
                "\n" +
                "Vestibulum nec auctor magna, vitae vestibulum purus. Sed sollicitudin tortor ut pretium rhoncus. Pellentesque vel erat non lacus pretium aliquet dapibus sed sem. Nullam eget ornare neque. Pellentesque molestie ex eget risus porta bibendum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Morbi et tellus eu odio elementum suscipit. Integer accumsan metus vitae massa auctor, vel lobortis augue condimentum. Quisque nec orci eget ex viverra ornare. In hac habitasse platea dictumst. Praesent mattis in ipsum eget eleifend. Nullam a vehicula libero. Integer tincidunt rutrum orci, non commodo tellus semper non. Praesent eros mauris, tempor at imperdiet et, feugiat id est. Mauris eu lobortis mauris.\n" +
                "\n" +
                "Vestibulum vitae est id mi scelerisque volutpat. Etiam consectetur vestibulum magna, a bibendum sapien commodo sit amet. Morbi et tellus eu odio elementum suscipit. Nullam tristique vulputate neque non aliquet. Sed porta metus ac quam fermentum placerat. Cras non aliquet ipsum, non condimentum orci. Nullam non dictum ligula. Ut sed cursus felis, et auctor augue.";;
        String pat = "Morbi et tellus eu odio elementum suscipit";


        try {
            String s = IOUtils.toString(new FileInputStream(new File("C:\\Users\\wlato\\Desktop\\praca_inzynierska\\potop.txt")), "UTF-8");
            String pattern = "wolność";
            long x = System.currentTimeMillis();
            search(pattern, s, 101);
            System.out.println(System.currentTimeMillis() - x);
        } catch(Exception ex) {
            ex.printStackTrace();
        }



//        System.out.println(txt);

        int q = 101; // A prime number
        //search(pat, txt, q);

    }
}

// This code is contributed by nuclode