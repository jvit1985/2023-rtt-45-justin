package jpa.entitymodels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import jpa.entitymodels.Course;
import jpa.entitymodels.CourseDAO;

public class CourseDAOTest {
		
		private static CourseDAO courseDao;
		
		@BeforeAll
		public static void setUp() {
			courseDao = new CourseDAO();
		}

		@Test
		public void findByIdTest() {
			
			//given
			Course expected = new Course();
			expected.setCName("English");
			expected.setCInstructorName("Anderea Scamaden");
			
			//when
			Course actual = courseDao.findById(1);
			
			Assertions.assertEquals(expected.getCName(), actual.getCName());
			Assertions.assertEquals(expected.getCInstructorName(), actual.getCInstructorName());
		}
		
		@ParameterizedTest
		@CsvSource({
			"1,English,Anderea Scamaden",
			"2,Mathematics,Eustace Niemetz"
			})
		public void findByIdParamaterizedTest(ArgumentsAccessor args) {
			
			//given
			Course expected = new Course();
			expected.setCName(args.getString(1));
			expected.setCInstructorName(args.getString(2));
			
			//when
			Course actual = courseDao.findById(args.getInteger(0));
			
			Assertions.assertEquals(expected.getCName(), actual.getCName());
			Assertions.assertEquals(expected.getCInstructorName(), actual.getCInstructorName());
			
		}
	}

