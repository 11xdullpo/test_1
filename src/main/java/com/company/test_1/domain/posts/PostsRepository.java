package com.company.test_1.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity클래스, PK타입> 상속 시 기본 CRUD 메소드가 자동으로 생성
// 또한 Entity클래스와 Entity Repository는 같은 패키지 내에 위치해야함.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
