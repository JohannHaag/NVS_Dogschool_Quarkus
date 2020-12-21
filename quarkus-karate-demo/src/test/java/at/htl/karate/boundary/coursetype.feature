Feature: Somebody will be greeting

  Background:
    * url baseUrl

  Scenario: GET a Coursetype
    Given path '/coursetype'
    When method GET
    Then status 200

  Scenario: GET one Coursetype
    Given path '/coursetype/1'
    When method GET
    Then status 200

  Scenario: POST a Coursetype

    Given path '/coursetype'
    And request {abbr:'welp', name:'Welpenkurs2'}
    When method POST
    Then status 201

  Scenario: PUT a Coursetype

    Given path '/coursetype/4'
    And request {abbr:'wwweee', name:'Der Welpenkurs'}
    When method PUT
    Then status 200

  Scenario: DELETE a Coursetype

    Given path '/coursetype/4'
    And request {abbr:'wwweee', name:'Der Welpenkurs'}
    When method DELETE
    Then status 204


