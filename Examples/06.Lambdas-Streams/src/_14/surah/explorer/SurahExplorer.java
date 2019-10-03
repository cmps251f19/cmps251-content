package _14.surah.explorer;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

public class SurahExplorer {

	public static void main(String[] args) {
		Gson gson = new Gson();
		String filePath = "data/surah.json";
		try {
			// Read file content
			String content = Files.readString(Paths.get(filePath));
			// System.out.println(content);

			// Convert json text to an array of Surah objects
			Surah[] surahs = gson.fromJson(content, Surah[].class);

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

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
