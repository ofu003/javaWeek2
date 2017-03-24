public class Team{
  private String[] mTeamMembers;
  private String mTeamName;
  private String mTeamGoal;
  //from other class
  private Member mMemberOfTeam;

  public Team(Member member)
    mMemberOfTeam = member;
  }

  public Team getMember(){
    return mMemberOfTeam;
  }

  public Team getmTeamMembers(){
    return mTeamMembers;
  }

  public Team getmTeamName(){
    return mTeamName;
  }

  public Team getmTeamGoal(){
    return mTeamGoal;
  }

  // public return values of member or add to array
}
