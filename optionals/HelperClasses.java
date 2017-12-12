import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

class World {
    Country getCountry(String countryName) {
	return countries.get(countryName);
    }

    Optional<Country> getCountry_Optional(String countryName) {
	return Optional.ofNullable(countries.get(countryName));
    }
    
    void addCountry(String countryName, Country country) {
	countries.put(countryName, country);
    }

    private Map<String, Country> countries = new HashMap<>();
}

class Country {
    City getCity(String cityName) {
	return cities.get(cityName);
    }

    Optional<City> getCity_Optional(String cityName) {
	return Optional.ofNullable(cities.get(cityName));
    }
    
    void addCity(String cityName, City city) {
	cities.put(cityName, city);
    }

    private Map<String, City> cities = new HashMap<>();
}

class City {
    Street getStreet(String streetName) {
	return streets.get(streetName);
    }
    
    Optional<Street> getStreet_Optional(String streetName) {
	return Optional.ofNullable(streets.get(streetName));
    }

    void addStreet(String streetName, Street street) {
	streets.put(streetName, street);
    }

    private Map<String, Street> streets = new HashMap<>();
}

class Street {
    Building getBuilding(String buildingNumber) {
	return buildings.get(buildingNumber);
    }
    
    Optional<Building> getBuilding_Optional(String buildingNumber) {
	return Optional.ofNullable(buildings.get(buildingNumber));
    }

    void addBuilding(String buildingNumber, Building building) {
	buildings.put(buildingNumber, building);
    }

    private Map<String, Building> buildings = new HashMap<>();
}

class Building {
    Building(String tenantName) {
	this.tenantName = tenantName;
    }

    String getTenantName() {
	return tenantName;
    }
    
    private String tenantName;
}
