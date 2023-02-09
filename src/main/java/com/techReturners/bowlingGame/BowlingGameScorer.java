package com.techReturners.bowlingGame;

public class BowlingGameScorer {
	
	private static final String SCORE_ZERO = "-";
	private static final String SCORE_STRIKE = "X";
	private static final String SCORE_SPARE = "/";

	
	
	public int scoreCalculator(String frameScore) {
		int score = 0;
		if(frameScoreZero(frameScore)) {
			score = 0;
		} else if (frameScore.contains(SCORE_STRIKE)) {
			score = 10;
		} else if (frameScore.contains(SCORE_SPARE)) {
			score = 10;
		}
		return score;
	}

	private boolean frameScoreZero(String frameScore) {
		return frameScore.startsWith(SCORE_ZERO) && frameScore.endsWith(SCORE_ZERO);
	}

}
