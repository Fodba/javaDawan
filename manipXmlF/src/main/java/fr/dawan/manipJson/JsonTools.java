package fr.dawan.manipJson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.stream.JsonGenerator;

import fr.dawan.manipXmlF.Produit;

public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}

//	public static void toJson(String filePath, Produit p) {
////		JsonArray jsonArrayPhones = Json.createArrayBuilder().add("011111111").add("022222222").build();
//		JsonObject jsonObject = Json.createObjectBuilder().add("id", p.getId()).add("description", p.getDescription())
//				.add("prix", p.getPrix()).build();
//		System.out.println(jsonObject.toString());
//		try (BufferedWriter bufferedWritter = new BufferedWriter(new FileWriter(filePath))) {
//			Map<String, Boolean> config = new HashMap<>();
//			config.put(JsonGenerator.PRETTY_PRINTING, true);
//			JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(pw);
//			jsonWriter.writeObject(jsonObject);
//			jsonWriter.close();
//		}
//	}

	public static void toJson(String filePath, Produit p) throws Exception {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("id", p.getId());
		builder.add("description", p.getDescription());
		builder.add("prix", p.getPrix());

		JsonObject jsonObject = builder.build();
//String jsonStr = jsonObject.toString();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			Map<String, Boolean> config = new HashMap<>();
			config.put(JsonGenerator.PRETTY_PRINTING, true);
			JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(writer);
			jsonWriter.writeObject(jsonObject);
			jsonWriter.close();
		}
	}

	public static <T> void genericToJson(String filePath, T p) throws Exception {
		JsonObjectBuilder builder = Json.createObjectBuilder();

		Field[] fields = p.getClass().getDeclaredFields();

		for (Field field : fields) {
//			System.out.println(field);
			field.setAccessible(true);
			builder.add(field.getName().toString(), field.get(p).toString());
		}

//		builder.add("id", p.getId());
//		builder.add("description", p.getDescription());
//		builder.add("prix", p.getPrix());
//
		JsonObject jsonObject = builder.build();
//String jsonStr = jsonObject.toString();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			Map<String, Boolean> config = new HashMap<>();
			config.put(JsonGenerator.PRETTY_PRINTING, true);
			JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(writer);
			jsonWriter.writeObject(jsonObject);
			jsonWriter.close();
		}
	}

	public static Produit fromJson(String filePath) throws IOException {
		JsonReader reader = null;
		Produit p = null;
		try (BufferedReader jsonReader = new BufferedReader(new FileReader(filePath))) {
			reader = Json.createReader(jsonReader);
			JsonObject obj = reader.readObject();
			p = new Produit();
			p.setId(obj.getJsonNumber("id").longValue());
			p.setDescription(obj.getString("description"));
			p.setPrix(obj.getJsonNumber("prix").doubleValue());
		}
		return p;
	}

	public static <T> T fromJsonGeneric(String filePath, Class<T> cl) throws IOException {
		JsonReader reader = null;
		T p = null;
		try (BufferedReader jsonReader = new BufferedReader(new FileReader(filePath))) {
			reader = Json.createReader(jsonReader);
			JsonObject obj = reader.readObject();

			p = cl.newInstance();

			Field[] fields = p.getClass().getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);

				f.set(p, f.get(p));
				Class<?> clf = f.getType();
				if (clf.equals(Integer.class) || clf.getName().equals("int"))
					f.set(p, f.getInt(p));
				else if (clf.equals(Long.class) || clf.getName().equals("long"))
					f.set(p, f.getLong(p));
				else if (clf.equals(Double.class) || clf.getName().equals("double"))
					f.set(p, f.getDouble(p));
				else
					f.set(p, f.get(p).toString());
			}

//			p.setId(Long.parseLong(obj.getJsonNumber("id")));
//			p.setDescription(obj.getString("description"));
//			p.setPrix(Double.parseDouble(obj.getString("prix")));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public static <T> T fromJsonGen(String filePath, Class<T> cl) throws Exception {
		JsonReader reader = null;
		T p = null;
		try (BufferedReader is = new BufferedReader(new FileReader(filePath))) {
			reader = Json.createReader(is);
			JsonObject obj = reader.readObject();

			p = cl.newInstance();
			Field[] fields = cl.getDeclaredFields();
			for (Field f : fields) {
				f.setAccessible(true);
				Class<?> clF = f.getType();
				if (clF.equals(Integer.class) || clF.getName().equals("int"))
					f.setInt(p, obj.getJsonNumber(f.getName()).intValue());
				else if (clF.equals(Long.class) || clF.getName().equals("long"))
					f.setLong(p, obj.getJsonNumber(f.getName()).longValue());
				else if (clF.equals(Double.class) || clF.getName().equals("double"))
					f.setDouble(p, obj.getJsonNumber(f.getName()).doubleValue());
				else
					f.set(p, obj.getString(f.getName()));
				// TODO traiter les autres types
			}

		}
		return p;
	}

	public static <T> void toJsonGen(String filePath, T p) throws Exception {
		JsonObjectBuilder builder = Json.createObjectBuilder();

		// import java.lang.Reflect.Field;
		Field[] fields = p.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);

			Class<?> cl = f.getType();
			if (cl.equals(Integer.class) || cl.getName().equals("int"))
				builder.add(f.getName(), f.getInt(p));
			else if (cl.equals(Long.class) || cl.getName().equals("long"))
				builder.add(f.getName(), f.getLong(p));
			else if (cl.equals(Double.class) || cl.getName().equals("double"))
				builder.add(f.getName(), f.getDouble(p));
			else
				builder.add(f.getName(), f.get(p).toString());
			// TODO traiter les autres types
//			builder.add(f.getName().toString(), f.get(p).toString());
		}

		JsonObject jsonObject = builder.build();
		// String jsonStr = jsonObject.toString();
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			Map<String, Boolean> config = new HashMap<>();
			config.put(JsonGenerator.PRETTY_PRINTING, true);
			JsonWriter jsonWriter = Json.createWriterFactory(config).createWriter(writer);
			jsonWriter.writeObject(jsonObject);
			jsonWriter.close();
		}
	}

	public static void main(String[] args) {
		try {
			Produit p = JsonTools.fromJson("test.json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Erreur lors de la lecture :\n" + e.getMessage());
		}
		Produit p = new Produit();
		p.setId(1);
		p.setDescription("Sac à dos");
		p.setPrix(30);
		try {
			JsonTools.genericToJson("test.json", p);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erreur lors de l'écriture :\n" + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
