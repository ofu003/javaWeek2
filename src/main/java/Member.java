import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Member{
  private String mName;
  private String mSkills;
  private static List<Member> instances = new ArrayList<Member>();
  private int mId;

  public Member(String name, String skills){
    mName = name;
    mSkills = skills;
    instances.add(this);
    mId = instances.size();
  }

  public String getMemberName(){
    return mName;
  }

  public String getMemberSkills(){
    return mSkills;
  }

  public static List<Member> all() {
   return instances;
  }

  public static void clear() {
    instances.clear();
  }

    public int getId() {
   return mId;
  }

  public static Member find(int id) {
    return instances.get(id - 1);
  }

}
