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
   String filename = "full-corpus.csv"; // I dont know if this is needed
   System.out.println(parseMessages(filename));
}
  public static Message[] parseMessages(String filename) throws Exception {
    Message[] messages = new Message[5114];
    Scanner reader = new Scanner(new File(filename));
    while (reader.hasNext()){
        int i =0;
        String str = reader.nextLine();
        System.out.println(str);
        messages[i]=(reader.nextLine());
        i+=1;
    }
    /*
    Insert your code to read the file here. All of the classes that you may need are imported already, though you may take other approaches.
     */

    return messages;
  }
}
