package usermanagement.dao;

import java.util.List;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import usermanagement.model.User;

public abstract class DaoMethode {

	public abstract boolean create(User user);

	public abstract User getItem(String id);

	public abstract UpdateResult update(String id, User user);

	public abstract DeleteResult delete(String id);

	public abstract List<User> getAll();

}
