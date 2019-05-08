package uk.gov.landregistry.kinderkat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uk.gov.landregistry.kinderkat.models.Kitty;
import uk.gov.landregistry.kinderkat.models.KittyScore;
import uk.gov.landregistry.kinderkat.repositories.KittyRepository;

import java.util.List;

@Service
public class KittyService{

    @Autowired
    private KittyRepository kittyRepository;

    public Kitty saveKitty(Kitty kitty) {return kittyRepository.save(kitty);}

    public List<KittyScore> getTopKats(int count) {
        return kittyRepository.getTopKats(PageRequest.of(0, count)).getContent();
    }
}
