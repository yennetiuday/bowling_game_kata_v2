package com.techReturners.bowlingGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BowlingGameScorerTest {
	
	@Test
	public void TestScoreZero(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(0, bowlingGameScorer.scoreCalculator("-"));
	}
	
	@Test
	public void TestScoreStrike(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(10, bowlingGameScorer.scoreCalculator("X"));
	}	

}
