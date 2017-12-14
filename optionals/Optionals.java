import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
	World world = generateWorld();

	// Displaying building tenant name:
	
	// 1) 'Old school'
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
			    String tenantName = building.getTenantName();
			    if (tenantName != null) {
				System.out.println(tenantName);
				found = true;
			    }
			}
		    }
		}
	    }
	}

	if (!found) {
	    System.out.println("No data");
	}

	// 2) Using Optional<>
	System.out.println(world.getCountry_Optional("Australia")
	    .flatMap(country -> country.getCity_Optional("Sydney"))
	    .flatMap(city -> city.getStreet_Optional("Wallaby Way"))
	    .flatMap(street -> street.getBuilding_Optional("42"))
	    .map(building -> building.getTenantName())
	    .orElse("No data")
	);
    }

    // Helper function to generate a World
    private static World generateWorld() {
	World world = new World()
	    .addCountry("Australia", new Country()
		.addCity("Sydney", new City()
		    .addStreet("Wallaby Way", new Street()
			.addBuilding("42", new Building("Nemo"))
		    )
		)
	    );
	
	return world;
    }
}
