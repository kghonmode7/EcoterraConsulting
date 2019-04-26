Feature: Ecoterra site testing as an admin
Scenario Outline: Ecoterra Login testing as admin
Given launch site
When click on dropdown and select admin from dropdown
And fill username "<uid>"
And fill password "<pwd>"
And click login button
Then validate output for admin criteria "<uid criteria>" for "<uid>" and "<pwd criteria>" for "<pwd>"
And close site
Examples:
|         uid        |uid criteria|  pwd   |pwd criteria|
|    admin@admin.com | valid      |pass@123|valid       |
|                    | uid_blank  |pass@123|valid       |
|   admin@admin.com  | valid      |        |pwd_blank   |
|   admin@admon.cim  |invalid     |pass@123|valid       |


Scenario Outline: Ecoterra Login testing as an employee
Given launch site
When click on dropdown and select employee from dropdown
And fill username "<uid>"
And fill password "<pwd>"
And click login button
Then validate output for employee criteria "<uid criteria>" for "<uid>" and "<pwd criteria>" for "<pwd>"
When close site for employee
Examples:
|         uid       |uid criteria|  pwd   |pwd criteria|
|         kj        | valid      |pass@123|valid       |
|                   | uid_blank  |pass@123|valid       |
|         kj        | valid      |        |pwd_blank   |
|   admin@admon.cim |invalid     |pass@123|valid       |


Scenario Outline: Ecoterra Login testing as an customer
Given launch site
When click on dropdown and select customer from dropdown
And fill username "<uid>"
And fill password "<pwd>"
And click login button
Then validate output for customer criteria "<uid criteria>" for "<uid>" and "<pwd criteria>" for "<pwd>"
When close site for customer
Examples:
|         uid       |uid criteria|  pwd   |pwd criteria|
|         itecy     | valid      | 123456 |valid       |
|                   | uid_blank  | 123456 |valid       |
|         itecy     | valid      |        |pwd_blank   |
|   admin@admon.cim |invalid     | 123456 |valid       |

