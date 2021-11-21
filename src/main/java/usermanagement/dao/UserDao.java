package usermanagement.dao;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import usermanagement.model.User;

public class UserDao extends DaoMethode {

	public MongoCollection<Document> getCollectionDb() {
		MongoCollection<Document> col = null;
		try {

			MongoDatabase dbMongo = MongoClients.create("mongodb://localhost:27017").getDatabase("user_db_java_test");

			col = dbMongo.getCollection("user");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return col;
	}

	@Override
	public boolean create(User user) {

		Document doc = new Document("name", user.getName()).append("email", user.getEmail()).append("country",
				user.getCountry());

		getCollectionDb().insertOne(doc);

		return false;
	}

	@Override
	public User getItem(String id) {

		User user = new User();

		Document row = getCollectionDb().find(new Document("_id", new ObjectId(id))).first();

		user.setId(row.get("_id").toString());
		user.setName(row.get("name").toString());
		user.setEmail(row.get("email").toString());
		user.setCountry(row.get("country").toString());

		return user;
	}

	@Override
	public UpdateResult update(String id, User user) {

		Bson filter = eq("_id", new ObjectId(id));

		Bson name = com.mongodb.client.model.Updates.set("name", user.getName());
		Bson email = com.mongodb.client.model.Updates.set("email", user.getEmail());
		Bson country = com.mongodb.client.model.Updates.set("country", user.getCountry());
		Bson updates = com.mongodb.client.model.Updates.combine(name, email, country);

		UpdateResult rs = getCollectionDb().updateMany(filter, updates);

		return rs;
	}

	@Override
	public DeleteResult delete(String id) {

		Bson filter = eq("_id", new ObjectId(id));

		DeleteResult rs = getCollectionDb().deleteOne(filter);

		return rs;
	}

	@Override
	public List<User> getAll() {

		List<User> rs = new ArrayList<>();

		FindIterable<Document> allUser = getCollectionDb().find();

		for (Document row : allUser) {

			User user = new User();
			user.setId(row.get("_id").toString());
			user.setName(row.get("name").toString());
			user.setEmail(row.get("email").toString());
			user.setCountry(row.get("country").toString());
			rs.add(user);

		}

		return rs;
	}

}
