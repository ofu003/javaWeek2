import java.util.ArrayList;
import java.util.List;

public class Team{
  // private String[] mTeamMembers;
  private String mTeamName;
  private String mTeamGoal;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  //from other class
  public static List<Member> allMembers = new ArrayList<Member>();
  private Member mMemberOfTeam;

  // constructor 1) for team information
  public Team(String name, String goal){
    mTeamName = name;
    mTeamGoal = goal;
    instances.add(this);
    mId = instances.size();
  }
  
  // getters
  public Member getMember(){
    return mMemberOfTeam;
  }
  public String getTeamName(){
    return mTeamName;
  }
  public String getTeamGoal(){
    return mTeamGoal;
  }

  public static void clear(){
    instances.clear();
  }

  public int getId(){
    return mId;
  }

  public static Team find(int mId){
    return instances.get(mId-1);
    }

}
