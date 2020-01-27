/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.*;
class FastIO
{
    private InputStream stream;
    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    public FastIO(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new RuntimeException();
        if (curChar >= numChars) {
            curChar = 0;
            try
            {
                numChars = stream.read(buf);
            }
            catch (IOException e)
            {
                throw new RuntimeException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public String readString() {
        final StringBuilder stringBuilder = new StringBuilder();
        int c = read();
        while (isSpaceChar(c))
            c = read();
        do
        {
            stringBuilder.append(c);
            c = read();
        } while (!isSpaceChar(c));
        return stringBuilder.toString();
    }

    public int readInt()
    {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-')
        {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do
        {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public boolean isSpaceChar(int c)
    {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}
class TestClass {

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        FastIO s = new FastIO(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        int N = s.readInt();                 // Reading input from STDIN
        int Q = s.readInt();                 // Reading input from STDIN
        int type, index;
        TreeSet<Integer> tree = new TreeSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < Q; i++){
            type = s.readInt();
            index = s.readInt();
            if (type == 1 && !set.contains(index)){
                set.add(index);
                tree.add(index);
            }else if (type == 2){
                Integer greater;
                if (set.contains(index)){
                    greater = index;
                }else{
                    greater = tree.higher(index);
                }
                if (greater == null){
                    greater = -1;
                }
                stringBuilder.append(greater).append("\n");
            }
        }
        System.out.print(stringBuilder);

        // Write your code he
    }

}
