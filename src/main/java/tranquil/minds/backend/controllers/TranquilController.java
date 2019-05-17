package tranquil.minds.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tranquil.minds.backend.dto.TestimonyDTO;
import tranquil.minds.backend.services.TestimonyService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class TranquilController {

    @Autowired
    private TestimonyService testimonyService;

    @GetMapping("/")
    public String helloKitty(){
        return "Hello There!";
    }

    @GetMapping("/getTestimonies")
    public ResponseEntity<List<TestimonyDTO>> getTestimonies(){
        return ResponseEntity.status(HttpStatus.OK).header("All good dawg?", "Yee")
                .body(
                        testimonyService.getTestimonies()
                        .stream()
                        .map(t -> new TestimonyDTO(
                                t.getTitle(),
                                t.getDate(),
                                t.getContent()
                        ))
                        .collect(Collectors.toList())
                );
    }
}