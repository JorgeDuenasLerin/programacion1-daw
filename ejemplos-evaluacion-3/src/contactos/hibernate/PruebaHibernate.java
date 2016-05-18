package contactos.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import contactos.jdbc.DatoDeContacto;
import contactos.swing.Contacto;

public class PruebaHibernate {

	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejemplo-mysql");
		EntityManager em = emf.createEntityManager();
		
		//ejemploCreacion(em);
		ejemploConsulta(em);

	}

	private static void ejemploConsulta(EntityManager em) {
		TypedQuery<Contacto> query = em.createQuery("from Contacto", Contacto.class);
		List<Contacto> list = query.getResultList();
		System.out.println(list);
	}

	private static void ejemploCreacion(EntityManager em) {
		Contacto c = new Contacto();
		c.setApellidos("hibernate");
		c.setNombre("Hibernate");
		c.setImagen("un string a bytes".getBytes());
		
		DatoDeContacto dc1 = new DatoDeContacto("t", "a", "v");
		dc1.contacto = c;
		c.addDato(dc1);
		
		DatoDeContacto dc2 = new DatoDeContacto("t2", "a2", "v2");
		dc2.contacto = c;
		c.addDato(dc2);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		System.out.println("Antes de grabar:" + c );
		em.persist(c);
		em.persist(dc1);
		em.persist(dc2);
		System.out.println("Después de grabar:" + c );
		
		tx.commit();
	}
}
