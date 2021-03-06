import java.util.Random;
/**
 * a bot that only tweets about neutral things. Child class of ChatterBot.
 */
public class PusherBot extends ChatterBot{
  private final int mod;

  /**
   * A constructor for a bot that initially only responds with neutral tweets about topics, but has a moderate positive or negative bias. As its bias increases, it begins to post positive or negative comments.
   * @param  messages Neutral messages
   * @return          [description]
   */
  public PusherBot(Message[] messages, ChatRoom room){
    super(messages, room);
    mod=0;
  }

  public void post(){
    double mod = room.getMoodMean();
    Message reply = null;
    Random input = new Random();
    int in = input.nextInt()*5115;
    while(mod > 0) {
      //search for tweet with nuetral or negative sentiment and post it using randomization until I get a neutral post
    while(messages[in].getSentiment() != 2){
      int inp = input.nextInt()*5115;
      in = inp;
    }
      mod += 0.1;
      reply = messages[in];
    }
    if(mod < 0){
      while(messages[in].getSentiment() != 0 || messages[in].getSentiment()!= 1){//search for tweet with positive sentiment and post it using randomization until I get a neutral post
        int inpu = input.nextInt()*5115;
        in = inpu;
      }
        reply = messages[in];
        mod -= 0.1;
      // search for tweet with negative and take its text to post
    }
    /*
    Here is where you will add code that chooses from one of the messages to respond with. That message will then be posted to the chatroom.
     */
    this.room.postNewMessage(reply);
  }
}
