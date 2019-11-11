package tutorial7.surah;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class SurahRepository {
	private static List<Surah> surahs;
	
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
	
	public static List<String> getSurahTypes() {
		return List.of("All", "Meccan", "Medinan");
	}
	
	public static List<Surah> getSurahs(String surahType) {
		if (surahs == null) {
			loadSurahs();
		}
		
		// Get Surahs by surahType
		return surahs.stream().filter(s -> surahType.equals("All") || s.getType().equalsIgnoreCase(surahType))
						      .collect(Collectors.toList());
	}
}