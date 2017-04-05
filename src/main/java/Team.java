import java.util.List;
import java.util.ArrayList;

public class Team{
  private String mTeamName;
  private String mTeamGoal;
  // private String[] mTeamMembers;
  private static ArrayList<Team> instances = new ArrayList<Team>();
  private int mId;
  //from other class
  private List<Member> mMembers;

  // constructor 1) for team information
  public Team(String name, String goal){
    mTeamName = name;
    mTeamGoal = goal;
    instances.add(this);
    mId = instances.size();
    mMembers = new ArrayList<Member>();
  }

  // getters

  public String getTeamName(){
    return mTeamName;
  }
  public String getTeamGoal(){
    return mTeamGoal;
  }

  public static ArrayList<Team> all() {
    return instances;
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

  public List<Member> getMembers(){
    return mMembers;
  }

  public void addAMember(Member newMember){
    mMembers.add(newMember);
  }
}
