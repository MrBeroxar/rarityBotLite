package rarityBot.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import rarityBot.businessObjects.KongData;

public class KongzCSVReader {
	
	private String[] files = {"/kongz1_link.csv","/kongz2_link.csv","/kongz3_link.csv","/kong_legendary.csv"};
	private List<String[]> allData = new ArrayList<>();

	public void readAll() {
		for(int i=0;i<4;i++) {
			CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(files[i])))).build();
			try {
				allData.addAll(csvReader.readAll());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public KongData searchByTokenId(long l) {
		
		KongData kongData = new KongData();
		for (String[] row : allData) {
			
			if(row[0].equals("#"+l)) {
				
				kongData.parseTokenId(row[0]);
				kongData.parseRank(row[1]);
				try {
					kongData.setImgLink(row[11]);
				}catch(ArrayIndexOutOfBoundsException e) {
					kongData.setImgLink(row[1]);
				}
			}
		}
		return kongData;
	}
}
	