package uk.gov.landregistry.kinderkat.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uk.gov.landregistry.kinderkat.models.Kitty;
import uk.gov.landregistry.kinderkat.models.KittyScore;

public interface KittyRepository extends JpaRepository<Kitty, Integer> {

    @Query("SELECT new uk.gov.landregistry.kinderkat.models.KittyScore(k.imgId, SUM(k.vote) AS score) FROM Kitty k GROUP BY k.imgId ORDER BY score DESC")
    public Page<KittyScore> getTopKats(Pageable pageable);

}
