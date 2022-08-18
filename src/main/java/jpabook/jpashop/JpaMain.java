package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            tx.commit(); //정상적이면 commit, DB에 저장되는 시점
        } catch (Exception e) {
            tx.rollback(); //예외 발생시 롤백
        } finally {
            em.close(); //작업이 끝나면 EntityManager 종료 -> 내부적으로 DB connection 반환
        }
        emf.close(); //자원 반환
    }
}
