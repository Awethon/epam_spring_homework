package lab.service;

import java.util.List;

import lab.dao.CountryDao;
import lab.dao.UserDao;
import lab.domain.Country;
import lab.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {

    private CountryDao countryDao;

    @Transactional(readOnly=true, propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<Country> loadAllUsers() {
        return countryDao.getAllCountries();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void saveUser(Country country) {
        countryDao.save(country);
    }

    public CountryDao getUserDao() {
        return countryDao;
    }

    @Autowired
    @Required
    public void setUserDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }
}
