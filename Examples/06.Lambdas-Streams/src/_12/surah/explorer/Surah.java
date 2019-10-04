package _12.surah.explorer;

import utils.JsonUtil;

public class Surah {
    private int id;
    private String name;
    private String englishName;
    private int ayaCount;
    private String type;
    
	public Surah(int id, String name, String englishName, int ayaCount, String type) {
		super();
		this.id = id;
		this.name = name;
		this.englishName = englishName;
		this.ayaCount = ayaCount;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEnglishName() {
		return englishName;
	}

	public int getAyaCount() {
		return ayaCount;
	}

	public String getType() {
		return type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public void setAyaCount(int ayaCount) {
		this.ayaCount = ayaCount;
	}

	public void setType(String type) {
		this.type = type;
	}
    
	public String toString() {
		return JsonUtil.toJson(this);
	}
}
