package _12.surah.explorer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SurahExplorer {
	private static List<Surah> surahs;
	
	private static String toJson(Surah surah) {
		Gson gson = new Gson();
		//Transform an instance of Surah class to a JSON string:
	    String surahJSON = gson.toJson(surah);
		return surahJSON;
	}
	
	private static void loadSurahs() {
		Gson gson = new Gson();
		String filePath = "data/surahs.json";
		try {
			// Read file content
			String fileContent = Files.readString(Paths.get(filePath));
			// System.out.println(fileContent);

			// Convert json text to an array of Surah objects
			Surah[] surahsArray = gson.fromJson(fileContent, Surah[].class);
			surahs = Arrays.asList(surahsArray);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void saveSurahs() {
		//Gson gson = new Gson(); // For pretty formatted json use the line below
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String filePath = "data/surahs2.json";
		String surahsJSON = gson.toJson(surahs);
		
		try {
			Files.writeString(Paths.get(filePath), surahsJSON);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static List<Surah> getSurahs(int ayaCount) {
		// Get Surahs having more than ayaCount
		return surahs.stream().filter(s -> s.getAyaCount() >= ayaCount)
						      .collect(Collectors.toList());
	}
	
	public static List<Surah> getSurahs(String surahType) {
		// Get Surahs by surahType
		return surahs.stream().filter(s -> s.getType().equalsIgnoreCase(surahType))
						      .collect(Collectors.toList());
	}
	
	public static Map<String, Long> getSurahCountByType() {
		// Get Surah Count by Surah type (Meccan vs. Medinan)
		 return surahs.stream()
				 	  .collect( Collectors.groupingBy(s -> s.getType(), 
				 			    Collectors.counting() 
				 			  ));
					  //.collect(Collectors.groupingBy(Surah::getType, Collectors.counting()));
	}
	
	public static Map<String, Integer> getAyaCountByType() {
		// Get Aya Count by Surah type (Meccan vs. Medinan)
		return surahs.stream()
			  .collect(Collectors.groupingBy(Surah::getType, 
				   	   Collectors.summingInt(s-> s.getAyaCount())
					  ));
	}
	
	public static Surah getLongestSurah() {
		Surah longestSurah =  
			   surahs.stream()
				     .max((s1, s2) -> s1.getAyaCount() - s2.getAyaCount())
				     .get();
		
		// Easier way - you may remove the implementation above
		longestSurah = 
				surahs.stream()
				      .max(Comparator.comparing(Surah::getAyaCount))
					  .get();
		return longestSurah;
	}
	
	public static void main(String[] args) {
		Surah surah = new Surah(1, "الفاتحة", "Al-Fatiha", 7, "Meccan");
		//Transform an instance of Surah class to a JSON string:
	    String surahJSON = toJson(surah);
		System.out.printf("surahJSON:\n %s \n\n", surahJSON);
		
		//Load surahs from surahs.json into surahs list 
		loadSurahs();

		System.out.println("*** Surahs having more than 200 Ayas ***");
		getSurahs(200).stream().forEach(System.out::println);

		System.out.println("\n*** First 5 Medinan Surahs ***");
		getSurahs("Medinan").stream().limit(5).forEach(System.out::println);
		
		System.out.println("\n*** Surah Count by Surah type (Meccan vs. Medinan) ***");
		Map<String, Long> surahCountByType = getSurahCountByType();
		System.out.println(surahCountByType);
			
		System.out.println("\n*** Aya Count by Surah type (Meccan vs. Medinan) ***");
		Map<String, Integer> ayaCountByType = getAyaCountByType();
		System.out.println(ayaCountByType);

		System.out.println("\n*** Longest Surah: ***");
		Surah longestSurah = getLongestSurah();
		System.out.println(longestSurah);
		
		saveSurahs();
	}
}
