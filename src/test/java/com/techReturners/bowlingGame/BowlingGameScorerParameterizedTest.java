package com.techReturners.bowlingGame;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class BowlingGameScorerParameterizedTest {

	@ParameterizedTest
	@CsvFileSource(resources = "bowlingGameTestInputs.csv", numLinesToSkip = 1)
	public void testBowligGameScorerUsingValuesFromCSVFile(Integer expected, String input) {
		BowlingGameScorer bowlingGameScorer = new BowlingGameScorer();
		assertEquals(expected, bowlingGameScorer.scoreCalculator(input));
	}
}
