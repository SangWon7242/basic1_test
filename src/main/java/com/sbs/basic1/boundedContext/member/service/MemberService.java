package com.sbs.basic1.boundedContext.member.service;

import com.sbs.basic1.base.rsData.RsData;
import com.sbs.basic1.boundedContext.member.entity.Member;
import com.sbs.basic1.boundedContext.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// @Component : 아래 클래스의 객체는 Ioc 컨테이너에 의해 생사소멸이 관리된다.
// @Service : @Component 와 같은 의미, 가독성 떄문에 이렇게 표기
@AllArgsConstructor
@Service
public class MemberService {
  private final MemberRepository memberRepository;

  // 롬복으로 생성가능
//    this.memberRepository = memberRepository;
//  public MemberService(MemberRepository memberRepository) {
//  }

  public RsData tryLogin(String username, String password) {
    Member member = memberRepository.findByUserName(username);

    if(member == null) {
      return RsData.of("F-2", "%s(은)는 존재하지 않는 회원입니다.".formatted(username));
    }

    if(!member.getPassword().equals(password)) {
      return RsData.of("F-1", "비밀번호가 일치하지 않습니다.");
    }


    return RsData.of("S-1", "%s 님 환영합니다.".formatted(username), member.getId());
  }

  public Member findByUserName(String username) {
    return memberRepository.findByUserName(username);
  }

  public Member findById(long id) {
    return memberRepository.findById(id);
  }
}


