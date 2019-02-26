import java.util.Random;
/**
 * a bot that only tweets about neutral things. Child class of ChatterBot.
 */
public class NeutralBot extends ChatterBot{

  /**
   * A constructor for a bot that initially only responds with neutral tweets about topics, but has a moderate positive or negative bias. As its bias increases, it begins to post positive or negative comments.
   * @param  messages Neutral messages
   * @return          [description]
   */
  public NeutralBot(Message[] messages, ChatRoom room){
    super(messages, room);
    Random rand = new Random();
    mood += 0.25*(rand.nextDouble() - 1);
  }

  public void update(Message msg){
    boolean read = false;
    int sentiment = msg.getSentiment();
    if(mood > 1 && sentiment > 1)
      read = true;
    else if(mood < 1 && sentiment < 1) // I think those values should be changed to <= and >= but this is what Godwin did. because it doesnt go into the read part.
    //and if I do change it I go into infinity loop inside the NeutralBot class and the post method (in the while loop section).
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
    int in = (int)(input.nextDouble()*5115);// in order to post I want to have positive, negative, and neutral posts- so what I did was
    // to keep randomize until I get neutral, positive, or negative bot for each while loop- another option was to make a list array with the positive, neutral, negative, and all the messages in the MessageParser class.
    while ((mood > 0.5) && (mood < 1.5)){
    while(messages[in].getSentiment() != 1){ // it checks if the sentiment is not neutral- if it is not so it randomize the msg until we get neutral msg.
      int inp = (int)(input.nextDouble()*5115);//search for tweet with nuetral and post it
      in = inp;
    }
    reply = messages[in];
  }
    while(mood < 0.5){
      while((messages[in].getSentiment() != 0)){// the smae process happens here for the Negative posts (check if negative and if not it randomize)
        int inpu = (int)(input.nextDouble()*5115);
        in = inpu;
      }
      reply = messages[in];
      // search for tweet with negative and take its text to post
    }
    while(mood > 1.5){
      while(messages[in].getSentiment() != 2){
        int put = (int)(input.nextDouble()*5115);// the same process as above.
        in = put;
      }
        reply = messages[in];
      // search for tweet with positive and take its text to post
    }
    /*
    Here is where you will add code that chooses from one of the messages to respond with. That message will then be posted to the chatroom.
     */
    this.room.postNewMessage(reply);
  }
}
