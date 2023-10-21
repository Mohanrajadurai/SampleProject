Feature: Registration Form for Student

  Background: 
    Given Launch the Browser
    And Enter the URL

  Scenario Outline: Fillup the Student Registration Form
    When Enter the First Name "<First Name>"
    And Enter the Last Name "<Last Name>"
    And Enter the Email "<Email>"
    And Select the Gender
    And Enter the Mobile Number "<Mobile>"
    And Enter the Date of Birth "<DOB>"
    And Enter the Subjects "<Subject>"
    And Select the Hobbies
    And Select the Picture from desktop directory
    And Enter the Current Address "<Address>"
    And Click the SubmitButton
    Then Validate the details

    Examples: 
      | First Name | Last Name | Email         | Mobile     | DOB        | Subject          | Address                    |
      | Mohan      | Rajadurai | abc@gmail.com | 9876543210 | 19/10/2020 | Computer Science | 123, Ist Street, abc City  |
      | Praveen    | Kumar     | bcd@gmail.com | 9876543888 | 19/10/2019 | Maths            | 234, IInd Street, abc City |
      | Divakar    | Raj       | cde@gmail.com | 9876511888 | 19/10/2018 | English          | 567, 3rd Street, abc City  |
