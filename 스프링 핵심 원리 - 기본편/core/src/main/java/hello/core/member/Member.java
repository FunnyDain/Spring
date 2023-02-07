package hello.core.member;

public class Member {

    //엔터티 필드는 Primitive보다 WrapperClass를 사용하는 것이 좋음
    //Null의 할당 여부 때문, 하이버네이트 영속성에서도 nullable권장
    private Long id;        //long대신 Long
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
