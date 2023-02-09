package com.techReturners.bowlingGame;

public class BowlingGameScorer {
	
	private static final String ZERO = "-";
	private static final String STRIKE = "X";
	private static final String SPARE = "/";
	private static final int MAX_SCORE = 10;
	private static final int MIN_SCORE = 0;
	
	private int roll;
	private int[] rolls = new int[21]; 
			
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
		int framesLength = frames.length;
		for (int frame =0; frame<framesLength-1; frame++) {
			if (frames[frame].contains("-")) {
				String[] frameRolls = frames[frame].split("");
				for (String score : frameRolls) {
					addScoreToRolls(score.equals(ZERO)? MIN_SCORE: Integer.valueOf(score));
				}
			} else if (frames[frame].startsWith(STRIKE)) {
				addScoreToRolls(MAX_SCORE);
			} else if (frames[frame].endsWith(SPARE)) {
				String[] frameRolls = frames[frame].split("");
				addScoreToRolls(Integer.valueOf(frameRolls[0]));
				addScoreToRolls(MAX_SCORE - Integer.valueOf(frameRolls[0]));
			} else {
				String[] frameRolls = frames[frame].split("");
				for (String score : frameRolls) {
					addScoreToRolls(Integer.valueOf(score));
				}
			}
		}
		lastFrameScoreConverter(frames[framesLength-1]);
	}

	private void lastFrameScoreConverter(String lastFrameScoreBoard) {
		String[] lastFrameScores = lastFrameScoreBoard.split("");
		if(lastFrameScores.length==3) {
			if(lastFrameScoreBoard.contains(SPARE)) {
				addScoreToRolls(Integer.valueOf(lastFrameScores[0]));
				addScoreToRolls(MAX_SCORE -Integer.valueOf(lastFrameScores[0]));
				addScoreToRolls(lastFrameScores[2].equals(ZERO)? MIN_SCORE: Integer.valueOf(lastFrameScores[2]));
			} else {
				for (String score : lastFrameScores) {
					if(score.equals(STRIKE))
						addScoreToRolls(MAX_SCORE);
					else if (score.equals(ZERO))
						addScoreToRolls(MIN_SCORE);
					else {
						addScoreToRolls(Integer.valueOf(score));
					}
				}
			}
		} else {
			for (String score : lastFrameScores) {
				if (score.equals(ZERO))
					addScoreToRolls(MIN_SCORE);
				else {
					addScoreToRolls(Integer.valueOf(score));
				}
			}
		}
	}

	private void addScoreToRolls(int score) {
		rolls[roll++] = score;
	}
	
	private boolean isStrike(int currentRoll) {
		return rolls[currentRoll] == MAX_SCORE;
	}

	private int getStrikeScore(int currentRoll) {
		return MAX_SCORE + rolls[currentRoll+1] + rolls[currentRoll+2];
	}

	private boolean frameScoreZero(String frameScore) {
		return frameScore.startsWith(ZERO) && frameScore.endsWith(ZERO);
	}
	
	private boolean isSpare(int currentRoll) {
		return getStandardScore(currentRoll) == MAX_SCORE;
	}

	private int getSpareScore(int currentRoll) {
		return MAX_SCORE + rolls[currentRoll+2];
	}

	private int getStandardScore(int currentRoll) {
		return rolls[currentRoll] + rolls[currentRoll+1];
	}

}
