package pl.quider.web.komis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.quider.web.komis.dtos.NewCarFormDto;
import pl.quider.web.komis.models.Person;
import pl.quider.web.komis.repositories.PersonRepository;

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
}
