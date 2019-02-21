import java.util.ArrayList;
public class ChatRoom {
  private final ChatterBot[] bots;
  private double mood, moodVariance;
  private ArrayList<Message> posts;

  public ChatRoom(ChatterBot[] bots){
    this.bots = bots;
    this.posts = new ArrayList<Message>();
  }

  /**
   * What is the mean (average) mood of all the bots in this room?
   * @return mean (average) mood of all the bots in this room
   */
  public static double getMoodMean(){
    return 0;
  }

  /**
   * What is the variance of the moods of all the bots in this room?
   * @return the variance of the moods of all the bots in this room
   */
  public double getMoodVariance(){
    return 0;
  }

  /**
   * Accept a new message for posting in the next round of updates
   * @param msg The message to be posted.
   */
  public void postNewMessage(Message msg){

  }

  /**
   * Update all the bots with messages that have been posted since the last round of updates.
   */
  public void updateBots(){
  }

  /**
   * Were messages posted during the last round of updates?
   * @return If new messages were posted during the last round of updates, return true, otherwise, false.
   */
  public boolean hasNewMessages(){
    return false;
  }

}
