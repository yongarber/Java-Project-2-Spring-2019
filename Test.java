public class Test{

public static void main(String[] args) throws Exception{
  try{
      Message[] msg = MessageParser.parseMessages("full-corpus.csv");
      ChatterBot[] GameBot = new ChatterBot[100];
      ChatRoom RoomBot = new ChatRoom (GameBot);                          
     for (int i=0; i<100; i++){
         //update bots
     }
  }catch (Exception e) {System.out.println(e); }
}
}
