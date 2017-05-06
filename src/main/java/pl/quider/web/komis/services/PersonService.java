package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.NewCarFormDto;
import pl.quider.web.komis.dtos.PersonDto;
import pl.quider.web.komis.models.Person;
import pl.quider.web.komis.repositories.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by adrian on 06.05.17.
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    /**
     *
     * @param carDto
     * @return
     */
    public Person add(NewCarFormDto carDto) {
        Person person = new Person();
        person.setName(carDto.getName());
        person.setSurname(carDto.getSurname());
        person.setAddress(carDto.getAddress());
        person.setPesel(carDto.getPesel());

        Person save = personRepository.save(person);
        return save;
    }

    /**
     *
     * @return
     */
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream().map(this::mapPersons).collect(Collectors.toList());
    }

    /**
     *
     * @param person
     * @return
     */
    private PersonDto mapPersons(Person person) {
        PersonDto personDto = new PersonDto(
                person.getSurname(),
                person.getName(),
                person.getPesel(),
                person.getId()
        );
        return personDto;
    }
}
