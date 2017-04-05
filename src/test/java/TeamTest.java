import org.junit.*;
import static org.junit.Assert.*;
import java.io.Console;

public class TeamTest{
  @Test
  public void teamInstantiatesCorrectly_True(){
    Team testTeam = new Team("Team","Goal");
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void getTeamName_teamInstantiatesWithName_String() {
    Team testTeam = new Team("Mobile App Team", "build a mobile transportation app");
    assertEquals("Mobile App Team", testTeam.getTeamName());
  }

  @Test
  public void getTeamGoal_teamInstantiatesWithName_String() {
    Team testTeam = new Team("Mobile App Team", "build a mobile transportation app");
    assertEquals( "build a mobile transportation app", testTeam.getTeamGoal());
  }

  @Test
  public void all_returnsAllInstancesOfTeam_true(){
    Team firstTeam = new Team ("Mobile App Team", "build a mobile transporation app");
    Team secondTeam = new Team ("GIF-generators", "build a GIF-suggestor app");
    assertEquals(true, Team.all().contains(firstTeam));
    assertEquals(true, Team.all().contains(secondTeam));
  }

  @Test
  public void clear_emptiesAllTeamsFromList_0(){
    Team testTeam = new Team ("Mobile App Team", "build a mobile transporation app");
    Team.clear();
    assertEquals(Team.all().size(), 0);
  }

  @Test
  public void find_returnsTeamWithSameId_secondTeam(){
    Team firstTeam = new Team ("Mobile App Team", "build a mobile transporation app");
    Team secondTeam = new Team ("GIF-generators", "build a GIF-suggestor app");
    assertEquals(Team.find(secondTeam.getId()), secondTeam);
  }

  @Test
  public void getMembers_initallyReturnsEmptyList_ArrayList(){
    Team.clear();
    Team testTeam = new Team("Mobile App Team", "build a mobile transporation app");
    assertEquals(0, testTeam.getMembers().size());
  }

  @Test
  public void addAMember_addsMemberToTeam_true(){
    Team testTeam = new Team("GIF-generators", "build a GIF-suggestor app");
    Member testMember = new Member("Jane Doe","Javascript and CSS");
    testTeam.addAMember(testMember);
    assertTrue(testTeam.getMembers().contains(testMember));
  }
}
