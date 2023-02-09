package com.techReturners.bowlingGame;

public class BowlingGameScorer {
	
	private int totalScore;
	
	private static final String SCORE_ZERO = "-";

	public int scoreCalculator(String score) {
		if(score.equals(SCORE_ZERO))
			totalScore = 0;
		
		return totalScore;
	}

}
