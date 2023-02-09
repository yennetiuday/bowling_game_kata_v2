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
	
	@Test
	public void TestScoreSpare(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(10, bowlingGameScorer.scoreCalculator("5/"));
	}
	
	@Test
	public void TestFrameScoreZero(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(0, bowlingGameScorer.scoreCalculator("--"));
	}
	
	@Test
	public void TestAllFramesScoreZero(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(0, bowlingGameScorer.scoreCalculator("-- -- -- -- -- -- -- -- -- --" ));
	}
	
	@Test
	public void TestAllFramesScoreOnes(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(20, bowlingGameScorer.scoreCalculator("11 11 11 11 11 11 11 11 11 11" ));
	}
	
	@Test
	public void TestFramesHavingDifferentScoresWithNoZerosStrikesAndSpares(){
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(75, bowlingGameScorer.scoreCalculator("21 35 53 45 81 24 54 43 62 17" ));
	}

}
