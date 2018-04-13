package lab.dao.jpa;

import lab.dao.CountryDao;
import lab.domain.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager em = emf.createEntityManager();
		if (em != null) {
			em.getTransaction().begin();
			em.persist(country);
			em.getTransaction().commit();

			em.close();
		}
	}

	@Override
	public List<Country> getAllCountries() {
        EntityManager em = emf.createEntityManager();
        if (em != null) {
            List<Country> countryList = em.createQuery("FROM Country", Country.class).getResultList();
            em.close();
            return countryList;
        }
        return null;
	}

	@Override
	public Country getCountryByName(String name) {
        EntityManager em = emf.createEntityManager();
		if (em != null) {
			Country country = em.createQuery("SELECT c FROM Country c WHERE c.name LIKE :name", Country.class)
					.setParameter("name", name)
					.getSingleResult();
			em.close();
			return country;
		}
		return null;
	}


}