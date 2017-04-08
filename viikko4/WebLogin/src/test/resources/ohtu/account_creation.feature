Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation successful with correct username and password
    Given new user is selected
    When  valid username "testi" and password "Test1111" are given
    Then  account has been created

  Scenario: creation fails with too short username and valid password
    Given new user is selected
    When  too short username "te" and valid password "Test1111" are given
    Then user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When  valid username "testi" and too short password "Test1" are given
    Then user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When  valid username "testi" and password consisting of only letters "Testiiii" are given
    Then user is not created and error "password can not contain only letters" is reported

  Scenario: creation fails with already taken username and valid pasword
    Given new user is selected
    When  taken username "jukka" and valid password "Testi1111" are given
    Then user is not created and error "username is already taken" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given new user is selected
    When  username "testi" password "Test1111" and pssword confirmation "Testi1211" are given
    Then user is not created and error "password and password confirmation do not match" is reported