import java.util.Random;
/**
 * a bot that only tweets about neutral things. Child class of ChatterBot.
 */
public class PusherBot{
  private final int mod;

  /**
   * A constructor for a bot that initially only responds with neutral tweets about topics, but has a moderate positive or negative bias. As its bias increases, it begins to post positive or negative comments.
   * @param  messages Neutral messages
   * @return          [description]
   */
  public PusherBot(ChatRoom room){
    super(room);
    mod=0;
  }
public PusherBot(int mod){
    this.mod = mod;
    
  }
  public void post(){
    double mod = ChatRoom.getMoodMean();
    Message reply = null;
    Random input = new Random();
    int in = input.nextInt()*5115;
    Message[] msg = new Message[5114];
    try{
      msg = MessageParser.parseMessages("full-corpus.csv");
    }
    catch(Exception e){
      System.out.println("ERROR");
    }
  // I dont know if the try and catch work here or not!!!!!
    while(mod > 0) {
      //search for tweet with nuetral and take its text to post
    while(msg[in].getSentiment() != 2){
      int inp = input.nextInt()*5115;
      in = inp;
    }
      mod += 0.1;
      reply = msg[in];
    }
    if(mod < 0){
      while(msg[in].getSentiment() != 0 || msg[in].getSentiment()!= 1){
        int inpu = input.nextInt()*5115;
        in = inpu;
      }
        reply = msg[in];
        mod -= 0.1;
      // search for tweet with negative and take its text to post
    }
    /*
    Here is where you will add code that chooses from one of the messages to respond with. That message will then be posted to the chatroom.
     */
    this.room.postNewMessage(reply);
  }
}
