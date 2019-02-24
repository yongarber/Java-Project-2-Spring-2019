import java.util.Random;


public class Test{

public static void main(String[] args) throws Exception{
  try{
      Message[] msg = MessageParser.parseMessages("full-corpus.csv");
      ChatterBot[] GameBot = new ChatterBot[100];
      ChatRoom RoomBot = new ChatRoom (GameBot);
      for (int i=0; i<90; i++){
      GameBot[i] = new NeutralBot(msg, RoomBot);
      }
      for (int i=90; i<100; i++){
      GameBot[i] = new PusherBot(msg, RoomBot);
      }
      Random rand = new Random();
      int number =(int)(rand.nextDouble()*5114);
      if(msg[number].getSentiment() == -1){
        int num =(int)(rand.nextDouble()*5114);
        number=num;
      }
      RoomBot.postNewMessage(msg[number]); // randomly pick message and put it in the chatroom.
      //make a while loop-
      int count = 0;
      while((RoomBot.getMoodMean() < 0.1) || (RoomBot.getMoodMean() > 1.9) || count <1000){
        count+=1;
        RoomBot.updateBots();
      }
     System.out.println(RoomBot.Size());
     System.out.println(count);
     System.out.println(RoomBot.getMoodMean());
     System.out.println(RoomBot.getMoodVariance());
  }catch (Exception e) {System.out.println(e); }
}
}
