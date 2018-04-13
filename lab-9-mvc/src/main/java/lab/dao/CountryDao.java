package lab.dao;

import lab.domain.Country;

import java.util.List;

public interface CountryDao {

	public abstract void save(Country country);

	public abstract List<Country> getAllCountries();

	public abstract Country getCountryByName(String name);

}