Feature: SpinWords

  Scenario: Spin my first words
    Given I have the words "abcdef a"
    When I spin the words
    Then I have spinned words "fedcba a"