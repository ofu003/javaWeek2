import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class MemberTest {

  @Test
  public void Member_instantiatesCorrectly_true() {
    Member myMember = new Member("Anna Alessandro", "PHP & Drupal");
    assertEquals(true, myMember instanceof Member);
  }

  @Test
  public void Member_instantiatesWithName_String() {
    Member myMember = new Member("Anna Alessandro", "PHP & Drupal");
    assertEquals("Anna Alessandro", myMember.getMemberName());
  }

  @Test
  public void Member_instantiatesWithSkills_String() {
    Member myMember = new Member("Anna Alessandro", "PHP & Drupal");
    assertEquals("PHP & Drupal", myMember.getMemberSkills());
  }

  @Test
  public void all_returnsAllInstancesOfMember_true() {
    Member firstMember = new Member("Anna Alessandro", "PHP & Drupal");
    Member secondMember = new Member("Brad Bird", "Animation & Algorithms");
    assertEquals(true, Member.all().contains(firstMember));
    assertEquals(true, Member.all().contains(secondMember));
  }

  @Test
  public void clear_emptiesAllMembersFromArrayList_0() {
    Member myMember = new Member("Anna Alessandro", "PHP & Drupal");
    Member.clear();
    assertEquals(Member.all().size(), 0);
  }

  @Test
  public void getId_membersInstantiateWithAnID_1() {
    Member.clear();
    Member myMember = new Member("Anna Alessandro", "PHP & Drupal");
    assertEquals(1, myMember.getId());
  }

  @Test
  public void find_returnsMemberWithSameId_secondMember() {
    Member firstMember = new Member("Anna Alessandro", "PHP & Drupal");
    Member secondMember = new Member("Brad Bird", "Animation & Algorithms");
    assertEquals(Member.find(secondMember.getId()), secondMember);
  }

}
