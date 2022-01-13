package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 회원은 상품을 주문할 수 있고
 *      등록
 *      조회
 * 여러 상품을 주문할 수 있다.
 *      등록
 *      수정
 *      조회
 * 주문
 *      상품 주문
 *      주문내역 조회
 *      주문 취소
 *  주문 상품
 *      - 주문할 때 여러 상품을 선택할 수 있고, 같은 상품도 여러번 주문될 수 있음
 *      -
 * */
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpashop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Order order = new Order();
            order.addOrderItem(new OrderItem());
        } catch (Exception e) {
            tx.rollback();
        } finally {

            em.close();
            emf.close();
        }
    }
}
