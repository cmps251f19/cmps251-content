package _9.mvapp.surah;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SurahRepository {
	private static List<Surah> surahs;
	
	private static void loadSurahs() {
		ObjectMapper jsonMapper = new ObjectMapper();
		String filePath = "data/surahs.json";
		try {
			Surah[] surahsArray = jsonMapper.readValue(new File(filePath), Surah[].class);
			List<Surah> surahs = Arrays.asList(surahsArray);
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