package rarityBot.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import rarityBot.businessObjects.MonkeData;

public class MonkeCSVReader {
	
	private String[] files = {"/monkeez.csv","/monke_legend.csv"};
	private List<String[]> allData = new ArrayList<>();
	
	public void readAll() {
		for(int i=0;i<2;i++) {
			CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(files[i])))).build();
			try {
				allData.addAll(csvReader.readAll());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public MonkeData searchByTokenId(long l) {
		
		MonkeData monkeData = new MonkeData();

		for (String[] row : allData) {
			if(Long.parseLong(row[0])==l) {
				monkeData.setTokenId(l);
				try {
					monkeData.parseRank(row[12]);
					monkeData.setImgLink(row[14]);
				}catch(ArrayIndexOutOfBoundsException e) {
					monkeData.setRank(1);
					monkeData.setImgLink(row[1]);
				}
			}
		}
		return monkeData;
		
	}
	

}
