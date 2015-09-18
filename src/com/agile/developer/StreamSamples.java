package com.agile.developer;

import java.util.Arrays;
import java.util.List;

public class StreamSamples {
	
	public static void main(String[] args) {
		List<Words> newWords = Arrays.asList(new Words("a",2),new Words("b",3),new Words("z",1));
		//Sort by id
		/*Collections.sort(newWords, new Comparator<Words>() {
			@Override
			public int compare(Words o1, Words o2) {
				return o1.getId().compareTo(o2.getId()) ;
			}
		});*/
		//Sort by words
		/*Collections.sort(newWords, new Comparator<Words>() {
			@Override
			public int compare(Words o1, Words o2) {
				return o1.getWord().compareTo(o2.getWord()) ;
			}
		});*/
		
		//java 8 lambdas expressions
		//newWords.sort((o1,o2) -> o1.getId().compareTo(o2.getId()));
		//newWords.sort((o1,o2) -> o1.getWord().compareTo(o2.getWord()));
		//java 8 lambdas statements
		//newWords.sort((o1,o2) -> {return o1.getId().compareTo(o2.getId());});
		//newWords.sort((o1,o2) -> {return o1.getWord().compareTo(o2.getWord());});
		//Java 8 Method references
		//newWords.sort(StreamSamples::comparingByID);
		//newWords.sort(StreamSamples::comparingByWords);
		//newWords.stream().forEach(word -> System.out.println(word.getWord()));
	}
	
	public static int comparingByID(Words a,Words b){
		return a.getId().compareTo(b.getId()) ;
	}
	
	public static int comparingByWords(Words a,Words b){
		return b.getWord().compareTo(a.getWord()) ;
	}

}



class Words{
	private String word;
	private Integer id;
	
	public Words(String word, int id) {
		this.word = word;
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
