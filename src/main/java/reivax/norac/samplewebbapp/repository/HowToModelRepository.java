package reivax.norac.samplewebbapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reivax.norac.samplewebbapp.model.HowToModel;

/**
 * Created by xavier caron on 27/01/2015.
 */
@Repository
public interface HowToModelRepository extends JpaRepository<HowToModel, Integer> {
}
