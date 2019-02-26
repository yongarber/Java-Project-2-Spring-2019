import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MessageParser{
  /**
   * Take the name of a comma-separated value (.csv) file in the local directory and parse the contents for tweets. The tweets have an expected structure of "Topic", "Sentiment", "TweetId", "TweetDate", "TweetText"
   * @param  filename the name of a comma-separated value (.csv) file in the local directory
   * @return          An array of parsed Message objects
   */
   public static void main(String[] args) throws Exception{
   String filename = "full-corpus.csv";
   System.out.println(parseMessages(filename));
}
  public static Message[] parseMessages(String filename) throws Exception {
    Message[] messages = new Message[5114];
    Scanner reader = new Scanner(new File(filename)); // read the file using scanner
    int temp = 1; // This all structure under is built to check for the sentiment as a string and return an integer.
    String S1 = "\"positive\"";
    String S2 = "\"negative\"";
    String S3 = "\"neutral\"";
    String[] strl= new String[5];
    int i =0;
    while (reader.hasNext()){
        String str = reader.nextLine();
        strl= str.split(",");
        if(strl[1].equals(S1)){
          temp=2;}
        if(strl[1].equals(S2)){
          temp=0;}
        if(strl[1].equals(S3)){
          temp=1;}
        Message msg = new Message(strl[0],temp,strl[2],strl[3],strl[4]); // here we take each string's index after the split and put it in the right place inside a message (except the integer in which I use temp).
        messages[i] = msg;// put each message in an index in the message array.
        i+=1;
    }

    return messages;

}
}
