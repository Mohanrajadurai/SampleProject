Feature: Booking Ticket in MakeMyTrip

  Scenario: Search the Flight and Book a Ticket
    Given Launch the Browser
    And Enter the URL
    When Select the way of trip to One Way
    And Enter the From City
    And Enter the To City
    And Select the date for Departure
    And Select the Travellers Count
    And Click the SearchButton
    Then Get the Flight Results
    When Select the Flight to Book
    And Enter the Travellers Details
    And Click the ContinueButton
    Then Validate the Review Details
    And Click the ContinueButton
    When Select the Desired Seat
    And Click the ContinueButton
    Then Validate Airport Pick & Drop
    And Validate Baggage
    When Click Proceed to PayButton
    Then Validate the Payment Options
    
