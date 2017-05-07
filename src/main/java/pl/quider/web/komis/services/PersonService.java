package pl.quider.web.komis.services;

import org.modelmapper.ModelMapper;
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
     * @param carDto
     * @return
     */
    public Person add(NewCarFormDto carDto) {
        Person byPesel = personRepository.findByPesel(carDto.getPesel());
        Person person = null;
        if (byPesel == null) {
            person = new Person();
            person.setName(carDto.getName());
            person.setSurname(carDto.getSurname());
            person.setAddress(carDto.getAddress());
            person.setPesel(carDto.getPesel());
            person = personRepository.save(person);

        } else {
            person = byPesel;
        }

        return person;
    }

    /**
     * @return
     */
    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream().map(this::mapPersons).collect(Collectors.toList());
    }

    /**
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

    /**
     *
     * @param id
     * @return
     */
    public PersonDto getPerson(Integer id) {
        if(id == null || id <= 0){
            throw new IllegalArgumentException("id musi być liczbą całkowitą dodatnią");
        }
        Person one = personRepository.findOne(id);
        ModelMapper modelMapper = new ModelMapper();
        PersonDto map = modelMapper.map(one, PersonDto.class);
        return map;
    }
}
