public class Team{
  // private String[] mTeamMembers;
  private String mTeamName;
  private String mTeamGoal;
  //from other class
  private Member mMemberOfTeam;

  // constructor 1) for team information
  public Team(String name, String goal){
    mTeamName = name;
    mTeamGoal = goal;
  }
  // constructor 2) stores member information for future use
  public Team(Member member){
    mMemberOfTeam = member;
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
  
}
