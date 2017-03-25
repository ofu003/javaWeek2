import java.util.ArrayList;
import java.util.List;

public class Team{
  // private String[] mTeamMembers;
  private String mTeamName;
  private String mTeamGoal;
  private static List<Team> allTeams = new ArrayList<Team>();
  private int mId;
  //from other class
  public static List<Member> allMembers = new ArrayList<Member>();
  private Member mMemberOfTeam;

  // constructor 1) for team information
  public Team(String name, String goal){
    mTeamName = name;
    mTeamGoal = goal;
    allTeams.add(this);
    mId = allTeams.size();
  }
  // constructor 2) stores member information for future use
  public Team(Member member){
    return mMemberOfTeam;
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
    allTeams.clear();
  }

  public int getId(){
    return mId;
  }

  public static Team find(int mId){
    return allTeams.get(mId-1);
    }

}
