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
    //Message[] positive = new Message[519];
    //Message[] negative = new Message[572];
    Scanner reader = new Scanner(new File(filename));
    int temp = 1;
    String S1 = "\"positive\"";
    String S2 = "\"negative\"";
    String S3 = "\"neutral\"";
    String[] strl= new String[5];
    int i =0;
    while (reader.hasNext()){
      //int posit = 0;
      //int negat = 0;
        String str = reader.nextLine();
        //str.replaceAll("\"", "");
        strl= str.split(",");
        if(strl[1].equals(S1)){
          temp=2;}
        if(strl[1].equals(S2)){
          temp=0;}
        if(strl[1].equals(S3)){
          temp=1;}
        Message msg = new Message(strl[0],temp,strl[2],strl[3],strl[4]);
        messages[i] = msg;
        // if(temp==0){
        //   positive[posit]=msg;
        //   posit+=1;}
        // if(temp==0){
        //   negative[negat]=msg;
        //   negat+=1;}
        //mess[i]=(reader.nextLine()); //We have issue with converting string to Message!
        i+=1;
    }
    /*
    Insert your code to read the file here. All of the classes that you may need are imported already, though you may take other approaches.
     */

    return messages;

}
}
