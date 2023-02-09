package com.techReturners.bowlingGame;

import org.junit.jupiter.api.Test;

public class BowlingGameScorerTest {
	
	@Test
	public void TestScoreContainsZero(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		bowlingGameScorer.scoreCalculator("-");
	}

}
