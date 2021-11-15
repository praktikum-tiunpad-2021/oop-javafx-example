package pboex.repository;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Vector;

import pboex.model.TodoTaskModel;

public class TodoTaskMemoryRepository implements Repository<TodoTaskModel> {
  private static Vector<TodoTaskModel> store = new Vector<>(5);

  @Override
  public TodoTaskModel save(TodoTaskModel t) throws Exception {
    boolean exists = store.stream().filter(st -> st.getId() == t.getId()).findFirst().isPresent();
    if (exists) {
      throw new RuntimeException("task already exists");
    }
    t.setId(new Random().nextInt());
    store.add(t);
    return t;
  }

  @Override
  public TodoTaskModel getById(Integer id) throws Exception {
    Optional<TodoTaskModel> t = store.stream().filter(st -> st.getId() == id).findFirst();
    if (!t.isPresent()) {
      throw new RuntimeException("task does not exists");
    }
    return t.get();
  }

  @Override
  public List<TodoTaskModel> getAll() throws Exception {
    return new Vector<>(store);
  }

  @Override
  public TodoTaskModel update(TodoTaskModel t) throws Exception {
    if (store.removeIf(st -> st.getId() == t.getId())) {
      store.add(t);
      return t;
    }
    throw new RuntimeException("task does not exists");
  }

  @Override
  public void deleteTodoTask(Integer id) throws Exception {
    store.removeIf(st -> st.getId() == id);
  }
}
