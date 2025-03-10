package integration;

import com.epam.model.Person;
import com.epam.model.PersonRoleEnum;
import com.epam.repository.PersonDAO;
import com.epam.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonDAO personDAO;

    @Test
    public void getPerson() {
        Person actualPerson = personService.getPerson("user@gmail.com");

        Assert.assertNotNull(actualPerson);
    }

    @Test
    public void addPerson() {
        Person expectedPerson = new Person("email", "password", PersonRoleEnum.USER);

        personService.addPerson(expectedPerson);

        List<Person> persons = personDAO.getPersons();
        Assert.assertTrue(persons.stream().anyMatch(person -> person.getEmail().equals("email")));
    }

    @Test
    public void updatePassword() {
        Person expectedPerson = new Person("email2", "password2", PersonRoleEnum.USER);
        personDAO.addPerson(expectedPerson);

        personService.updatePassword("email2", "password3");

        List<Person> persons = personDAO.getPersons();
        Assert.assertTrue(persons.stream().anyMatch(person -> person.getPassword().equals("password3")));
    }

}
