package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Fruit;


public interface FruitRepository extends CrudRepository<Fruit, Integer> {

}
