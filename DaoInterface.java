package example.jdbc.dao;

import java.util.Collection;

//This interface provides a basic template for the DAO Pattern 
//Its implementation class decides the actual entity type  
// and the ID type.
public interface DaoInterface<T,K>{
 Collection<T> retrieveAll();

 T retriveOne(K id);

void create(T t);

void delete(K id);

void update(T t);
}



//Customer ID: int --Integer----> Customer DAO<Customer, In
//Passport ID: String --> PassportDao<String>
