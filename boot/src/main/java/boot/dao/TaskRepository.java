package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer>{

}
