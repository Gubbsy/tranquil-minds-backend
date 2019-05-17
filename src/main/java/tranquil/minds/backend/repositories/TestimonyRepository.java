package tranquil.minds.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tranquil.minds.backend.models.Testimony;

import java.util.List;

public interface TestimonyRepository extends JpaRepository<Testimony, Integer> {

    @Query("SELECT new tranquil.minds.backend.models.Testimony(t.title, t.date, t.content) FROM Testimony t")
    public List<Testimony> getTestimonies();
}
