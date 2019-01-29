import javax.swing.*;

public class Cryptography {
    public static void main(String[] args) {
        String plaintext = " ";

        // Get input string.
        //plaintext = JOptionPane.showInputDialog("Please enter the string");

        //int numColumns = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of columns"));

        System.out.println(encrypt("THIS IS A SECRET MESSAGE",5));
        System.out.println(decrypt(encrypt("THIS IS A SECRET MESSAGE",5),5));
    }

    public static String encrypt(String in, int numColumns)
    {
        // Initialise output string
        String plaintext = "";

        // Remove the spaces
        for (int i = 0; i < in.length(); i++)
        {
            if (in.charAt(i) != ' '){
                plaintext += in.charAt(i);
                //System.out.println(plaintext);
            }
        }

        //System.out.println(plaintext);
        // Add X's as needed to pad the rows
        while (plaintext.length()%numColumns != 0){
            plaintext += "X";
            //System.out.println("x added");
        }

        //System.out.println(plaintext);
        //Record the number of rows
        int numRows = in.length()/numColumns;
        //System.out.println(numRows);

        String cipherText = "";
        //Rearrange the columns
        for (int col = 0; col < numColumns; col++){
            int index = col;
            for (int row = 0; row < numRows; row++){
                cipherText = cipherText + plaintext.charAt(index);
                index += numColumns;
            }
            //cipherText = cipherText + " ";
        }
        return cipherText;
    }

    public static String decrypt(String plaintext, int numColumns){
        String cipherText = "";
        for (int i = 0; i < plaintext.length(); i++)
        {
            if (plaintext.charAt(i) != ' '){
                cipherText += plaintext.charAt(i);
                //System.out.println(plaintext);
            }
        }
        int numRows = cipherText.length()/numColumns;

        String decryptedText= " ";
        for (int row = 0; row < numRows; row++){
            int index = row;
            for (int col = 0; col < numColumns; col++){
                decryptedText = decryptedText + cipherText.charAt(index);
                index += numRows;
            }
            //cipherText = cipherText + " ";
        }


        return decryptedText;
    }
}
