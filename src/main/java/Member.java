public class Member{
  private String mName;
  private String mSkills;

  // use App input to construct Member
  public Member(String name, String skills){
    mName = name;
    mSkills = skills;
  }

  public String getMemberName(){
    return mName;
  }

  public String getMemberSkills(){
    return mSkills;
  }

}
