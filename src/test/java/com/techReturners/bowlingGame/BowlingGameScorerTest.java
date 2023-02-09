package com.techReturners.bowlingGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BowlingGameScorerTest {
	
	@Test
	public void TestScoreContainsZero(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(0, bowlingGameScorer.scoreCalculator("-"));
	}

}
