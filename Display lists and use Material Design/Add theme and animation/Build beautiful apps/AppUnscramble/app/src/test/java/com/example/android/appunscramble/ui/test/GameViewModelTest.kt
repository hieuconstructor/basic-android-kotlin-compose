package com.example.android.appunscramble.ui.test

import com.example.android.appunscramble.data.MAX_NO_OF_WORDS
import com.example.android.appunscramble.data.SCORE_INCREASE
import com.example.android.appunscramble.data.getUnscrambledWord
import com.example.android.appunscramble.ui.GameViewModel
import org.junit.Assert.*
import org.junit.Test

class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_CorrectWordGuessed_ScoreUpdatedAndErrorFlagUnset() {
        var currentGameUiState = viewModel.uiState.value
        val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        viewModel.updateUserGuess(correctPlayerWord)
        viewModel.checkUserGuess()

        currentGameUiState = viewModel.uiState.value
        // Assert that checkUserGuess() method updates isGuessedWordWrong is updated correctly.
        assertFalse(currentGameUiState.isGuessedWordWrong)
        // Assert that score is updated correctly.
        assertEquals(SCORE_AFTER_FIRST_CORRECT_ANSWER, currentGameUiState.score)
    }

    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet() {
        // Given an incorrect word as input
        val incorrectPlayerWord = "and"

        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        val currentGameUiState = viewModel.uiState.value
        // Assert that score is unchanged
        assertEquals(0, currentGameUiState.score)
        // Assert that checkUserGuess() method updates isGuessedWordWrong correctly
        assertTrue(currentGameUiState.isGuessedWordWrong)
    }

    companion object {
        private const val SCORE_AFTER_FIRST_CORRECT_ANSWER = SCORE_INCREASE
    }

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        val gameUiState = viewModel.uiState.value
        val unScrambledWord = getUnscrambledWord(gameUiState.currentScrambledWord)

        // Assert that current word is scrambled.
        assertNotEquals(unScrambledWord, gameUiState.currentScrambledWord)
        // Assert that current word count is set to 1.
        assertTrue(gameUiState.currentWordCount == 1)
        // Assert that initially the score is 0.
        assertTrue(gameUiState.score == 0)
        // Assert that the wrong word guessed is false.
        assertFalse(gameUiState.isGuessedWordWrong)
        // Assert that game is not over.
        assertFalse(gameUiState.isGameOver)
    }

    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly() {
        var expectedScore = 0
        var currentGameUiState = viewModel.uiState.value
        var correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        repeat(MAX_NO_OF_WORDS) {
            expectedScore += SCORE_INCREASE
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()
            currentGameUiState = viewModel.uiState.value
            correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
            // Assert that after each correct answer, score is updated correctly.
            assertEquals(expectedScore, currentGameUiState.score)
        }
        // Assert that after all questions are answered, the current word count is up-to-date.
        assertEquals(MAX_NO_OF_WORDS, currentGameUiState.currentWordCount)
        // Assert that after 10 questions are answered, the game is over.
        assertTrue(currentGameUiState.isGameOver)
    }
}