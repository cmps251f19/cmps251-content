package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Util {
	 public static String toJson(Object object) {
		 Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 return gson.toJson(object);
	 }
}