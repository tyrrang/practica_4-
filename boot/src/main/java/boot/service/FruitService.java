package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.FruitRepository;
import boot.model.Fruit;

@Service @Transactional
public class FruitService {

	private final FruitRepository fruitRepository;
	
	public FruitService(FruitRepository fruitRepository) {
		super();
		this.fruitRepository = fruitRepository;
	}
	
	public List<Fruit> findAll(){
		List<Fruit> fruits = new ArrayList<Fruit>();
		for (Fruit fruit : fruitRepository.findAll()) {
			fruits.add(fruit);
		}
		return fruits;
	}
	
	public void save(Fruit fruit){
		fruitRepository.save(fruit);
	}
	
	public void delete(int id_fruit){
		fruitRepository.delete(id_fruit);
	}
	
	public Fruit findFruit(int id_fruit){
		return fruitRepository.findOne(id_fruit);
	}
	
}
