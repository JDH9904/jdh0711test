package com.korea.book;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Optional;

import java.util.List;
@SpringBootTest
class BookApplicationTests {



	// 서점 두개를 만들어주세요.

// 서점은 각각 이름과 보유서적으로 구성됩니다.

// 각각 코리아서점, 아이티문고

	@Autowired
	private bookstoreRepository bookstoreRepository;

	@Autowired
	private bookRepository bookRepository;

	@Test

	void t2() {
		bookstore b1 = new bookstore();
		b1.setStore("코리아서점");
		this.bookstoreRepository.save(b1);
		bookstore b2 = new bookstore();
		b2.setStore("아이티문고");
		this.bookstoreRepository.save(b2);// 첫번째 질문 저장
		System.out.println(b1.getStore());
		System.out.println(b2.getStore());
// 구현 및 테스트
	}



// 모든 서점 정보 조회

// 출력 : 코리아서점, 아이티문고

	@Test

	void t3() {
		List<bookstore> all = this.bookstoreRepository.findAll();

		for (int i=0; i < all.size();i++){
			bookstore q = all.get(i);
			System.out.println(all.get(i).getStore());
			System.out.println(all.get(i).getId());
		}


// 구현 및 테스트

	}





// 아이티문고의 이름을 IT문고로 변경해주세요.

// 변경 후엔 t3() 메서드를 실행해 확인해주세요.

// 출력 : 코리아서점, IT문고

	@Test

	void t4() {
		Optional<bookstore> oq = this.bookstoreRepository.findById(2);
		assertTrue(oq.isPresent());
		bookstore q = oq.get();
		q.setStore("IT문고");
		this.bookstoreRepository.save(q);
		System.out.println(q.getStore());



// 구현 및 테스트

	}



// 책 5권을 만들어주세요.

// 책은 제목과 저자, 보유 서점으로 구성됩니다.

// 책은 각각

// 어린왕자, 생떽쥐페리, 코리아서점

// 해리포터, 조앤 롤링, 코리아서점

// 죄와벌, 도스토예프스키, 코리아서점

// 점프 투 스프링부트, 박응용, 아이티문고

// 수학의 정석, 홍성대, 아이티문고

// 로 만들어주세요.



	@Test

	void t5() {
		Optional<bookstore> oq = this.bookstoreRepository.findById(1);
		assertTrue(oq.isPresent());
		bookstore q = oq.get();

		book a = new book();
		a.setTitle("어린왕자");
		a.setAuthor("생떽쥐페리");
		a.setBookstore(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		this.bookRepository.save(a);
		book a2 = new book();
		a2.setTitle("해리포터");
		a2.setAuthor("조앤 롤링");
		a2.setBookstore(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		this.bookRepository.save(a2);
		book a3 = new book();
		a3.setTitle("죄와벌");
		a3.setAuthor("도스토예프스키");
		a3.setBookstore(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		this.bookRepository.save(a3);

		Optional<bookstore> oq2 = this.bookstoreRepository.findById(2);
		assertTrue(oq2.isPresent());
		bookstore q2 = oq2.get();

		book c = new book();
		c.setTitle("점프 투 스프링부트");
		c.setAuthor("박응용");
		c.setBookstore(q2);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		this.bookRepository.save(c);
		book c2 = new book();
		c2.setTitle("수학의 정석");
		c2.setAuthor("홍성대");
		c2.setBookstore(q2);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		this.bookRepository.save(c2);



// 구현 및 테스트

	}



// 모든 책의 제목을 출력해주세요.

	@Test

	void t6() {

		List<book> oa = this.bookRepository.findAll();
		for (int i=0; i < oa.size();i++){
			book q = oa.get(i);
			System.out.println(oa.get(i).getTitle());
			System.out.println(oa.get(i).getId());
		}




// 구현 및 테스트

	}



// 코리아서점에서 판매하는 책의 제목을 출력해주세요.

	@Test
	@Transactional
	void t7() {

		Optional<bookstore> oq = this.bookstoreRepository.findById(1);
		assertTrue(oq.isPresent());
		bookstore q = oq.get();

// bookList 필드를 프록시 초기화
		q.getBookList().size();

		List<book> bookList = q.getBookList();

		assertTrue(oq.isPresent());
		for (int i = 0; i < bookList.size(); i++){
			System.out.println(bookList.get(i).getTitle());
		}


// 구현 및 테스트

	}



// 박응용이 쓴 책을 삭제해주세요.

// 삭제 후 t5 메서드를 이용해 확인해주세요.

	@Test

	void t8() {
		book oq = this.bookRepository.findByAuthor("박응용");
		this.bookRepository.delete(oq);

// 구현 및 테스트

	}
}
