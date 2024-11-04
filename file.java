import java.io.*;

public class file {

    public static void main(String[] args) {

        File f = new File("name.txt");

        try {
            f.createNewFile();
            FileWriter fw = new FileWriter("name.txt");
            fw.write("my name is mathew");
            fw.close();
            int c;
            String s = "";
            System.out.println("enter the name of the file:");
            while ((c = System.in.read()) != '0') {
                s = s + (char) (c);
            }
            System.out.println(s);
            FileReader fg = new FileReader(s);
            BufferedReader bf = new BufferedReader(fg);
            while ((c = bf.read()) != -1) {
                System.out.print((char) c);
            }
            bf.close();
        } catch (IOException ae) {
            System.out.println("caught exception");
        }

    }

}
