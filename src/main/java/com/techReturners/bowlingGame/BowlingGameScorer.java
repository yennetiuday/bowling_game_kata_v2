package com.techReturners.bowlingGame;

public class BowlingGameScorer {
	
	private static final String ZERO = "-";
	private static final String STRIKE = "X";
	private static final String SPARE = "/";

	
	
	public int scoreCalculator(String scoreBoard) {
		int score = 0;
		String[] frames = scoreBoard.split(" ");
		
		for (String frame : frames) {
			if(frameScoreZero(frame)) {
				score += 0;
			} else if (frame.startsWith(STRIKE)) {
				score += 10;
			} else if (frame.endsWith(SPARE)) {
				score += 10;
			}
		}
		return score;
	}

	private boolean frameScoreZero(String frameScore) {
		return frameScore.startsWith(ZERO) && frameScore.endsWith(ZERO);
	}

}
