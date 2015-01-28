package reivax.norac.samplewebbapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reivax.norac.samplewebbapp.model.StepModel;

/**
 * Created by xavier caron on 27/01/2015.
 */
@Repository
public interface StepModelRepository extends JpaRepository<StepModel, Integer> {
}
