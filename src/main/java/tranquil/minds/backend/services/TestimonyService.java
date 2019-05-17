package tranquil.minds.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tranquil.minds.backend.models.Testimony;
import tranquil.minds.backend.repositories.TestimonyRepository;

import java.util.List;

@Service
public class TestimonyService {

    @Autowired
    private TestimonyRepository testimonyRepository;

    public List<Testimony> getTestimonies(){
        return  testimonyRepository.getTestimonies();
    }
}
