package hellojpa;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{

@Id@GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="TEAM_ID",insertable = false,updatable = false)
    private Team team;


    //일 대 다멤버의 있는 팀 변수명 team이라는 것에 의해 매핑이 됨, 읽기만 가능함
//    @OneToMany(mappedBy = "team")
//    private List<Member> members = new ArrayList<>();
//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

}
