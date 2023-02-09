package com.techReturners.bowlingGame;

public class BowlingGameScorer {
	
	private int totalScore;
	
	private static final String SCORE_ZERO = "-";
	private static final String SCORE_STRIKE = "X";

	public int scoreCalculator(String score) {
		if(score.equals(SCORE_ZERO))
			totalScore += 0;
		else if (score.contains(SCORE_STRIKE)) {
			totalScore += 10;
		}
		
		return totalScore;
	}

}
