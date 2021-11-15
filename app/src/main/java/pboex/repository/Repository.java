package pboex.repository;

import java.util.List;

import pboex.model.Model;

public interface Repository<T extends Model> {
  public T save(T t) throws Exception;

  public T getById(Integer id) throws Exception;

  public List<T> getAll() throws Exception;

  public T update(T t) throws Exception;

  public void deleteTodoTask(Integer id) throws Exception;
}