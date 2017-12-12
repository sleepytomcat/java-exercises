import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
	World world = generateWorld();

	boolean found = false;
	if (world != null) {
	    Country country = world.getCountry("Australia");
	    if (country != null) {
		City city = country.getCity("Sydney");
		if (city != null) {
		    Street street = city.getStreet("Wallaby Way");
		    if (street != null) {
			Building building = street.getBuilding("42");
			if (building != null) {
			    System.out.println(building.getTenantName());
			    found = true;
			}
		    }
		}
	    }
	}

	if (!found) {
	    System.out.println("No data");
	}

	////////////////////////////////////////////////////////////////

	world.getCountry_Optional("Australia")
	    .flatMap(country -> country.getCity_Optional("Sydney"))
	    .flatMap(city -> city.getStreet_Optional("Wallaby Way"))
	    .flatMap(street -> street.getBuilding_Optional("42"))
	    .flatMap(building -> building.getTenantName())
	    .orElse("No data")
	    .ifPresent(System.out::println);
    }

    private static World generateWorld() {
	Building building = new Building("Nemo");
	Street street = new Street();
	street.addBuilding("42", building);
	City city = new City();
	city.addStreet("Wallaby Way", street);
	Country country = new Country();
	country.addCity("Sydney", city);
	World world = new World();
	world.addCountry("Australia", country);
	return world;
    }
}
