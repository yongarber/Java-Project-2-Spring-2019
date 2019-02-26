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
  public double getMoodMean(){
    double x =0;
    int count = 0;
    for(ChatterBot bot : bots){// I get the mood from each bot using each-loop, adds them all up and take the average.
      x+=bot.getMood();
      count+=1;
    }
    double avg =(x/count);
    return avg;
  }

public double Size(){
return posts.size();
}
  /**
   * What is the variance of the moods of all the bots in this room?
   * @return the variance of the moods of all the bots in this room
   */
  public double getMoodVariance(){// I use the getMoodMean function to get the mean and then I gust followed the formula to calculate the variance.
    double y = getMoodMean();
    double x = 0;
    int count = 0;
    for(ChatterBot bot : bots){
      x+=Math.pow(y-bot.getMood(), 2);
      count+=1;
    }
    double var = (x/count);
    return var;
  }

  /**
   * Accept a new message for posting in the next round of updates
   * @param msg The message to be posted.
   */
  public void postNewMessage(Message msg){// just adds a new msg to the list array of posts.
  posts.add(msg);
  }

  /**
   * Update all the bots with messages that have been posted since the last round of updates.
   */
  public void updateBots(){
  	int count=0;
  	for(ChatterBot bot:bots){ // gives each bot in the chatterBot all the posts-updates the bots
  		for(int i =0; i < posts.size();i++){
  		bot.update(posts.get(i));
  	}
  		count+=1;
  	}

  }

  /**
   * Were messages posted during the last round of updates?
   * @return If new messages were posted during the last round of updates, return true, otherwise, false.
   */
  public boolean hasNewMessages(){// hasNewMessages comes after updateBots to check if something was updated
    //so I check if the posts array is empty and if it is not I know that there were new posting because I remove the posts after each check. 
  	if(posts.isEmpty()){
  		return false;
  	}
   	for(int i =0; i <= posts.size();i++){
		posts.remove(i);
  	}
  	return true;

}
}
