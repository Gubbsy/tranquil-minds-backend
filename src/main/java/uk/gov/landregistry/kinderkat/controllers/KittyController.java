package uk.gov.landregistry.kinderkat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gov.landregistry.kinderkat.dto.KittyScoreDTO;
import uk.gov.landregistry.kinderkat.dto.Vote;
import uk.gov.landregistry.kinderkat.models.Kitty;
import uk.gov.landregistry.kinderkat.models.KittyScore;
import uk.gov.landregistry.kinderkat.services.KittyService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class KittyController {

    @Autowired
    private KittyService kittyService;

    @GetMapping("/")
    public String helloKitty(){
        return "Hello Kitty :3";
    }

    @CrossOrigin
    @PostMapping("/thumb-kat")
    public String thumbKitty(@RequestBody Vote vote){
        Kitty transformed = new Kitty(vote.getImage_id(), vote.getVote(), vote.getKat_name());
        kittyService.saveKitty(transformed);
        return "Saved Vote - this is fake response";
    }

    @GetMapping("/top-kats")
    public ResponseEntity<List<KittyScoreDTO>> getTopKitties() {
        return ResponseEntity.status(HttpStatus.OK).header("Access-Control-Allow-Origin", "*")
            .body(
                kittyService.getTopKats(5)
                .stream()
                .map(k -> new KittyScoreDTO(
                    k.getImgId(),
                    k.getScore()
                ))
                .collect(Collectors.toList()
            )
        );
    }
}