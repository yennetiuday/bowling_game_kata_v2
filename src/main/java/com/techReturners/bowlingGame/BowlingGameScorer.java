package com.techReturners.bowlingGame;

public class BowlingGameScorer {
	
	private int roll;
	private int[] rolls = new int[21]; 
			
	private static final String ZERO = "-";
	private static final String STRIKE = "X";
	private static final String SPARE = "/";
	
	public int scoreCalculator(String scoreBoard) {
		scoreBoardConverter(scoreBoard);
		int score = 0;
		int currentRoll = 0;
		for(int currentFrame = 0; currentFrame<10; currentFrame++) {
			if (isStrike(currentRoll)) {
				score += getStrikeScore(currentRoll);
				currentRoll++;
			} else if (isSpare(currentRoll)) {
				score += getSpareScore(currentRoll);
				currentRoll += 2;
			} else {
				score += getStandardScore(currentRoll);
				currentRoll += 2;
			}
		}
		return score;
	}
	
	private void scoreBoardConverter(String scoreBoard) {
		String[] frames = scoreBoard.split(" ");
		for (int frame =0; frame<frames.length; frame++) {
			if(frameScoreZero(frames[frame])) {
				addScoreToRolls(0);
				addScoreToRolls(0);
			} else if (frames[frame].contains("-")) {
				String[] frameRolls = frames[frame].split("");
				for (String score : frameRolls) {
					addScoreToRolls(score.equals(ZERO)? 0: Integer.valueOf(score));
				}
			} else if (frames[frame].startsWith(STRIKE)) {
				addScoreToRolls(10);
			} else if (frames[frame].endsWith(SPARE)) {
				String[] frameRolls = frames[frame].split("");
				addScoreToRolls(Integer.valueOf(frameRolls[0]));
				addScoreToRolls(10 - Integer.valueOf(frameRolls[0]));
			} else {
				String[] frameRolls = frames[frame].split("");
				for (String score : frameRolls) {
					addScoreToRolls(Integer.valueOf(score));
				}
			}
		}
	}

	private void addScoreToRolls(int score) {
		rolls[roll++] = score;
	}
	
	private boolean isStrike(int currentRoll) {
		return rolls[currentRoll] == 10;
	}

	private int getStrikeScore(int currentRoll) {
		return 10 + rolls[currentRoll+1] + rolls[currentRoll+2];
	}

	private boolean frameScoreZero(String frameScore) {
		return frameScore.startsWith(ZERO) && frameScore.endsWith(ZERO);
	}
	
	private boolean isSpare(int currentRoll) {
		return getStandardScore(currentRoll) == 10;
	}

	private int getSpareScore(int currentRoll) {
		return 10 + rolls[currentRoll+2];
	}

	private int getStandardScore(int currentRoll) {
		return rolls[currentRoll] + rolls[currentRoll+1];
	}

}
