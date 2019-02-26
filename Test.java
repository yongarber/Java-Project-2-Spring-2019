import java.util.Random;


public class Test{

public static void main(String[] args) throws Exception{
  try{
      Message[] msg = MessageParser.parseMessages("full-corpus.csv");// initiate messages using the MessageParser
      ChatterBot[] GameBot = new ChatterBot[100];// create the chatterBot
      ChatRoom RoomBot = new ChatRoom (GameBot);//create the ChatRoom
      for (int i=0; i<90; i++){
      GameBot[i] = new NeutralBot(msg, RoomBot);// initiate 90 Neutralbots
      }
      for (int i=90; i<100; i++){
      GameBot[i] = new PusherBot(msg, RoomBot);// initiate 10 Pusherbots
      }
      Random rand = new Random();
      int number =(int)(rand.nextDouble()*5114);
      if(msg[number].getSentiment() == -1){ // just making sure that the posts are relevant and if it not I pick another one with a sentiment of neutral, positive, or negative.
        int num =(int)(rand.nextDouble()*5114);
        number=num;
      }
      RoomBot.postNewMessage(msg[number]); // randomly pick message and put it in the chatroom.
      int count = 0;
      while((RoomBot.getMoodMean() < 0.1) || (RoomBot.getMoodMean() > 1.9) || count <1000){
        count+=1;
        RoomBot.updateBots();// this updateBots method should push the mood to one of the edges.
      }
     System.out.println(RoomBot.Size());// print all the things that were written int he assignment
     System.out.println(count);
     System.out.println(RoomBot.getMoodMean());
     System.out.println(RoomBot.getMoodVariance());
  }catch (Exception e) {System.out.println(e); }
}
}
