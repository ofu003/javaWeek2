import java.util.ArrayList;
import java.util.List;

public class Team{
  // private String[] mTeamMembers;
  private String mTeamName;
  private String mTeamGoal;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  //from other class
  private ArrayList<Member> mMemberOfTeam;

  // constructor 1) for team information
  public Team(String name, String goal){
    mTeamName = name;
    mTeamGoal = goal;
    instances.add(this);
    mId = instances.size();
    mMemberOfTeam = new ArrayList<Member>();
  }

  // getters

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

  public static List<Team> returnInstances(){
    return instances;
  }

  public static Team find(int mId){
    return instances.get(mId-1);
    }

  public void addAMember(Member newMember){
    mMemberOfTeam.add(newMember);
  }

  public ArrayList<Member> getMembers(){
    return mMemberOfTeam;
  }

}
