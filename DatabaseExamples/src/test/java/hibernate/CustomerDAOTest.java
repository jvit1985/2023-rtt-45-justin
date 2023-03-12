package hibernate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;


public class CustomerDAOTest {
	
	private static CustomerDAO customerDao;
	
	@BeforeAll
	public static void setUp() {
		customerDao = new CustomerDAO();
	}

	@Test
	public void findByIdTest() {
		
		//given
		Customer expected = new Customer();
		expected.setCustomerName("Atelier graphique");
		expected.setContactLastName("Schmitt");
		expected.setContactFirstName("Carine");
		
		//when
		Customer actual = customerDao.findById(103);
		
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactLastName(), actual.getContactLastName());
		Assertions.assertEquals(expected.getContactFirstName(), actual.getContactFirstName());
	}
	
	@ParameterizedTest
	@CsvSource({
		"103,Atelier graphique,Schmitt,Carine",
		"112,Signal Gift Stores,King,Jean"
		})
	public void findByIdParamaterizedTest(ArgumentsAccessor args) {
		
		//given
		Customer expected = new Customer();
		expected.setCustomerName(args.getString(1));
		expected.setContactLastName(args.getString(2));
		expected.setContactFirstName(args.getString(3));
		
		//when
		Customer actual = customerDao.findById(args.getInteger(0));
		
		Assertions.assertEquals(expected.getCustomerName(), actual.getCustomerName());
		Assertions.assertEquals(expected.getContactLastName(), actual.getContactLastName());
		Assertions.assertEquals(expected.getContactFirstName(), actual.getContactFirstName());
	}
}
