package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;
// Member 은 dto 에서 구현해서 불러올수있
public class MemoryMemberRepository  implements MemberRepository{
    private  static Map<Long,Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
    store.put(member.getId(), member);
    }

    @Override
    public Member findByID(Long memberId) {
        return store.get(memberId);
    }
}
