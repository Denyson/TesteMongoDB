package principal;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class Principal {

	public static void main(String[] args) {
		try {
			// Conexão
			Mongo m = new Mongo("localhost", 27017);
			DB db = m.getDB("test");
			DBCollection coll = db.getCollection("seuColecao");
			System.out.println(coll.count());
			
			// Insert
//			BasicDBObject doc = new BasicDBObject();
//			doc.put("nome", "Breno Oliveira");
//			doc.put("site", "www.brenooliveira.com.br");
//			
//			BasicDBObject info = new BasicDBObject();
//			info.put("xpto", "zapata");
//			
//			doc.put("info", info);
//			
//			coll.insert(doc);
			
			// Select
			BasicDBObject info = new BasicDBObject();
			info.put("xpto", "zapata");
			BasicDBObject search = new BasicDBObject();
			search.put("info", info);
			
			DBCursor cur = coll.find(search);
			System.out.println(cur.count());
			while (cur.hasNext()) {
				System.out.println(cur.next());
			}
			
			m.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
