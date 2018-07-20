package com.toadordragon.kata;

import com.toadordragon.kata.SpinWords.SpinWords;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.core.Is.is;

public class MyStepdefs {

    SpinWords spinWords;
    String words;
    String spinnedWords;

    @Given("^I have the words \"([^\"]*)\"$")
    public void iHaveTheWords(String words) {
        spinWords = new SpinWords();
        this.words = words;
    }

    @When("I spin the words")
    public void spinWords() {
        spinnedWords = spinWords.processText(words);
    }

    @Then("^I have spinned words \"([^\"]*)\"$")
    public void iHaveSpinnedWords(String spinnedWords) {
        Assert.assertThat(this.spinnedWords, is(spinnedWords));
    }
}
