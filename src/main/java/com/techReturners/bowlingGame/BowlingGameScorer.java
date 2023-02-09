package com.techReturners.bowlingGame;

public class BowlingGameScorer {
			
	private static final String ZERO = "-";
	private static final String STRIKE = "X";
	private static final String SPARE = "/";
	
	public int scoreCalculator(String scoreBoard) {
		int score = 0;
		String[] frames = scoreBoard.split(" ");
		for (int frame =0; frame<frames.length; frame++) {
			if(frameScoreZero(frames[frame])) {
				score += 0;
			} else if (frames[frame].startsWith(STRIKE)) {
				score += 10;
			} else if (frames[frame].endsWith(SPARE)) {
				score += 10;
			} else {
				String[] rolls = frames[frame].split("");
				score += Integer.valueOf(rolls[0]) + Integer.valueOf(rolls[1]);
			}
		}
		return score;
	}

	private boolean frameScoreZero(String frameScore) {
		return frameScore.startsWith(ZERO) && frameScore.endsWith(ZERO);
	}

}
