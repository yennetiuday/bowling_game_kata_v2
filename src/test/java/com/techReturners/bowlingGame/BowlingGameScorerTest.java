package com.techReturners.bowlingGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BowlingGameScorerTest {
	
	private BowlingGameScorer bowlingGameScorer;
	
	@BeforeEach
	public void setUp() {
		bowlingGameScorer = new BowlingGameScorer();
	}
	
	@Test
	public void testScoreZero(){
		assertEquals(0, bowlingGameScorer.scoreCalculator("-"));
	}
	
	@Test
	public void testScoreStrike(){
		assertEquals(10, bowlingGameScorer.scoreCalculator("X"));
	}
	
	@Test
	public void testScoreSpare(){
		assertEquals(10, bowlingGameScorer.scoreCalculator("5/"));
	}
	
	@Test
	public void testFrameScoreZero(){
		assertEquals(0, bowlingGameScorer.scoreCalculator("--"));
	}
	
	@Test
	public void testAllFramesScoreZero(){
		assertEquals(0, bowlingGameScorer.scoreCalculator("-- -- -- -- -- -- -- -- -- --" ));
	}
	
	@Test
	public void testAllFramesScoreOnes(){
		assertEquals(20, bowlingGameScorer.scoreCalculator("11 11 11 11 11 11 11 11 11 11" ));
	}
	
	@Test
	public void testFramesHavingDifferentScoresWithNoZerosStrikesAndSpares(){
		assertEquals(75, bowlingGameScorer.scoreCalculator("21 35 53 45 81 24 54 43 62 17" ));
	}
	
	@Test
	public void testFramesHavingFirstFrameSpareAndSecondFrameFirstValueFour(){
		assertEquals(16, bowlingGameScorer.scoreCalculator("4/ 3- -- -- -- -- -- -- -- --" ));
	}
	
	@Test
	public void testFirstFrameStrikeFollowedByThreeAndSix() {
		assertEquals(28, bowlingGameScorer.scoreCalculator("X 36 -- -- -- -- -- -- -- --" ));
	}

}
