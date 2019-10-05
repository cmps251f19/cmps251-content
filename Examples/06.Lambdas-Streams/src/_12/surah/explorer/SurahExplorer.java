package _12.surah.explorer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

public class SurahExplorer {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		Surah surah = new Surah(1, "الفاتحة", "Al-Fatiha", 7, "Meccan");
		//Transform an instance of Surah class to a JSON string:
	    String surahJSON = gson.toJson(surah);
		System.out.printf("surahJSON:%n %s %n%n", surahJSON);
		
		String filePath = "data/surahs.json";
		try {
			// Read file content
			String fileContent = Files.readString(Paths.get(filePath));
			// System.out.println(content);

			// Convert json text to an array of Surah objects
			Surah[] surahs = gson.fromJson(fileContent, Surah[].class);

			String surahsJSON = gson.toJson(surahs);
			Files.writeString(Paths.get(filePath), surahsJSON);

			// Get Surahs having more than 200 Ayas
			System.out.println("*** Surahs having more than 200 Ayas ***");
			Stream.of(surahs).filter(s -> s.getAyaCount() > 200)
							 .forEach(System.out::println);

			// Get Medinan Surahs
			System.out.println("\n*** Medinan Surahs ***");
			Stream.of(surahs).filter(s -> s.getType().equalsIgnoreCase("Medinan"))
							 .limit(5)
							 .forEach(System.out::println);
			
			// Get Surah Counts by Surah type (Meccan vs. Medinan)
			Map<String, Long> surahCountByType = Stream.of(surahs)
					.collect(Collectors.groupingBy(s -> s.getType(), Collectors.counting()));
					//.collect(Collectors.groupingBy(Surah::getType, Collectors.counting()));
			System.out.println(surahCountByType);
			
			// Get Aya Counts by Surah type (Meccan vs. Medinan)
			Map<String, Integer> ayaCountByType = Stream.of(surahs)
					.collect(Collectors.groupingBy(Surah::getType, 
							 Collectors.summingInt(s-> s.getAyaCount())
							));
			System.out.println(ayaCountByType);
			
			Surah longestSurah = 
					Stream.of(surahs)
					      .max((s1, s2) -> s1.getAyaCount() - s2.getAyaCount())
					      .get();
			
			System.out.println("\nLongest Surah: ");
			System.out.println(longestSurah);
			
			// Easier way
			longestSurah = 
					Stream.of(surahs)
					      .max(Comparator.comparing(Surah::getAyaCount))
						  .get();
			
			System.out.println("\n[Easier way] - Longest Surah: ");
			System.out.println(longestSurah);

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
