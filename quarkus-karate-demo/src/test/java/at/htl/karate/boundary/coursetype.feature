Feature: Somebody will be greeting

  Background:
    * url baseUrl

  Scenario: GET a Coursetype
    Given path '/course_type'
    When method GET
    Then status 200


  Scenario: GET one Coursetype
    Given path '/course_type/1'
    When method GET
    Then status 200

  Scenario: POST a Coursetype

    Given path '/course_type'
    And request {abbr:'schutz', name:'Schutzhunde-Ausbildung'}
    When method POST
    Then status 201

  Scenario: PUT a Coursetype

    Given path '/course_type/4'
    And request {abbr: 'such', name: 'Suchhunde-Ausbildung'}
    When method PUT
    Then status 200

  Scenario: DELETE a Coursetype

    Given path '/course_type/4'
    And request {abbr: 'such' , name: 'Suchhunde-Ausbildung'}
    When method DELETE
    Then status 204


