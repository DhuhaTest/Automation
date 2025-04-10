Feature:Registration


  Scenario: Register new user successfully
    Given I am on basketballengland page
    When I fill in the correct member details
    And I press Confirm and join
    Then I successfully become a member

  Scenario: Missing lastname
    Given I am on basketballengland page
    When I fill in the correct member details but not filling on lastname
    And I press Confirm and join
    Then I see the error message for the lastname missing



  Scenario: Password don't match
    Given I am on basketballengland page
    When I fill in the correct member details but password don't match
    And I press Confirm and join
    Then I see the error message for the passowrd

  Scenario: Term and conditions not selected
    Given I am on basketballengland page
    When I fill in the correct member details but Term and conditions not selected
    And I press Confirm and join
    Then I see the error message for the term and condition



