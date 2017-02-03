package by.tc.analyzer.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.analyzer.dao.AnalyzerDAO;

public class AnalyzerDAOImpl implements AnalyzerDAO {
	
	public ArrayList<String> getTokens(String fileName){
		ArrayList<String> tokensArray = new ArrayList<String>();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			//Пропускаю первую строку
			bufferedReader.readLine();
			try {
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					Matcher token = getMatcher("((<|>|)(([^<|^>]|\n)*([^<|^>]|\n))(>|))", line);
					while (token.find()) {
                    tokensArray.add(token.group());
					}
				}
			} finally {
				bufferedReader.close();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
        return tokensArray;
	}

	private Matcher getMatcher(String regexp, String path){
		Pattern regexpn = Pattern.compile(regexp);
		Matcher m = regexpn.matcher(path);
		return m;
	}

}
