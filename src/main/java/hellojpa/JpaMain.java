package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        //<persistence-unit name="hello">
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            //create
            Member member1 = new Member();
            member1.setId(1L);
            member1.setUsername("HelloA");
            em.persist(member1);
//            Member member2 = new Member();
//            member2.setId(2L);
//            member2.setUsername("HelloB");
//            em.persist(member2);
            //read
            Member findMember = em.find(Member.class, 1L);
            System.out.println(memb);
            List<Member> result = em.createQuery("select m from Member as m",Member.class).setFirstResult(1).setMaxResults(10).getResultList();

            for (Member member :
                    result) {
                System.out.println("member.getname = " + member.getName());
            }
            System.out.println("findMember = " + findMember.getId());
            System.out.println("findMember = " + findMember.getName());


            Address a = findMember.getHomeAddress();
            findMember.setHomeAddress(new Address("new city",a.getStreet(),a.getZipcode()));

            findMember.getAddressesHistory().remove(new AddressEntity("old1", "street","10000"));
            findMember.getAddressesHistory().add(new AddressEntity("newcity", "street","10000"));


            tx.commit();


        }catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }


        emf.close();

    }


}
