package inheritance.livingthings;

public interface LivingCreator {
	//"وَمَا مِنْ دَابَّةٍ فِي الْأَرْضِ إِلا عَلَى اللَّهِ رِزْقُهَا"
	//القارت (الانسان) العاشب (البقرة) اللاحم (القط) 
	void eat();

	//Crawl, swim, run, fly
	//"وَاللَّهُ خَلَقَ كُلَّ دَابَّةٍ مِنْ مَاءٍ ۖ فَمِنْهُمْ مَنْ يَمْشِي عَلَىٰ بَطْنِهِ وَمِنْهُمْ مَنْ يَمْشِي عَلَىٰ رِجْلَيْنِ وَمِنْهُمْ مَنْ يَمْشِي عَلَىٰ أَرْبَعٍ ۚ يَخْلُقُ اللَّهُ مَا يَشَاءُ ۚ"
	void move();
	
	//Increase in size of individual cells or in the number of cells
	//"هُوَ الَّذِي خَلَقَكُمْ مِنْ تُرَابٍ ثُمَّ مِنْ نُطْفَةٍ ثُمَّ مِنْ عَلَقَةٍ ثُمَّ يُخْرِجُكُمْ طِفْلًا ثُمَّ لِتَبْلُغُوا أَشُدَّكُمْ ثُمَّ لِتَكُونُوا شُيُوخًا"
	void grow();
	
	//Reproduce either from egg, pollen, sperm, etc.
	//"يَا أَيُّهَا النَّاسُ اتَّقُوا رَبَّكُمُ الَّذِي خَلَقَكُمْ مِنْ نَفْسٍ وَاحِدَةٍ وَخَلَقَ مِنْهَا زَوْجَهَا وَبَثَّ مِنْهُمَا رِجَالًا كَثِيرًا وَنِسَاءً"
	void reproduce();
	
	//"كُلُّ نَفْسٍ ذَائِقَةُ الْمَوْتِ"
	//Animals and Plants die in different ways; for example, Plants do not have hearts that stop.
	void die();
}
