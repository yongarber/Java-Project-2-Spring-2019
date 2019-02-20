import java.util.Random;
/**
 * a bot that only tweets about neutral things. Child class of ChatterBot.
 */
public class PusherBot extends ChatterBot{

  /**
   * A constructor for a bot that initially only responds with neutral tweets about topics, but has a moderate positive or negative bias. As its bias increases, it begins to post positive or negative comments.
   * @param  messages Neutral messages
   * @return          [description]
   */
  public PusherBot(Message[] messages, ChatRoom room){
    super(messages, room);
    Random rand = new Random();
    mood += 0.25*(rand.nextDouble() - 1);
  }

  public void update(Message msg){
    boolean read = false;
    int sentiment = msg.getSentiment();

    if(mood > 1 && sentiment > 1)
      read = true;
    else if(mood < 1 && sentiment < 1)
      read = true;
    else if(sentiment == 1 && mood == 1)
      read = true;

    if(read)
      read(msg);
  }

  public void read(Message msg){
    int sentiment = msg.getSentiment();
    Random rand = new Random();
    double replyChance = rand.nextDouble()*2.0;
    boolean post = false;

    if(mood > 1 && replyChance < mood)
      post = true;
    else if(mood < 1 && replyChance > mood)
      post = true;

    if(sentiment > 1)
      mood += 0.01;
    else if (sentiment < 1)
      mood -= 0.01;
    else{
      if(mood > 1)
        mood -= 0.01;
      else
        mood += 0.01;
    }

    if(post)
      post();
  }

  /**
   * While the mood of the NeutralBot is between 0.5 and 1.5,
    it will only post neutral articles. Once the mood of the NeutralBot
    dips below 0.5 (negative) or above 1.5 (positive), it should then begin posting positive or negative articles.
   */
  public void post(){
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
    while ((mood > 0.5) && (mood < 1.5)){
      //search for tweet with nuetral and take its text to post
    while(!msg[in].equals(1)){
      int inp = input.nextInt()*5115;
      in = inp;
    }
      System.out.println(msg[in].getTweetText());
    }
    if(mood < 0.5){
      while(!msg[in].equals(0)){
        int inpu = input.nextInt()*5115;
        in = inpu;
      }
        System.out.println(msg[in].getTweetText());
      // search for tweet with negative and take its text to post
    }
    if(mood > 1.5){
      while(!msg[in].equals(2)){
        int put = input.nextInt()*5115;
        in = put;
      }
        System.out.println(msg[in].getTweetText());
      // search for tweet with positive and take its text to post
    }
    /*
    Here is where you will add code that chooses from one of the messages to respond with. That message will then be posted to the chatroom.
     */
    this.room.postNewMessage(reply);
  }
}
