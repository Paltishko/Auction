package repository;

import domain.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tretiak Anton on 23.11.2016.
 */
@Repository
public interface LotRepository extends CrudRepository<Lot, Long> {
}
