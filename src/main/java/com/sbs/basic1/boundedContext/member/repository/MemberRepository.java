package com.sbs.basic1.boundedContext.member.repository;

import com.sbs.basic1.boundedContext.member.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository // 컴포넌트랑 똑같음
public class MemberRepository {
  private List<Member> members;

  public MemberRepository() {
    members = new ArrayList<>();

    members.add(new Member("user1", "1234"));
    members.add(new Member("abc", "12345"));
    members.add(new Member("test", "12346"));
    members.add(new Member("love", "12347"));
    members.add(new Member("like", "12348"));
    members.add(new Member("giving", "12349"));
    members.add(new Member("thanks", "123410"));
    members.add(new Member("good", "123412"));
    members.add(new Member("peace", "123413"));
  }

  public Member findByUserName(String username) {
    return members.stream()
        .filter(member -> member.getUsername().equals(username))
        .findFirst()
        .orElse(null);
  }
}
