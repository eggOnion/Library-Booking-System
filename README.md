# Library-Booking-System 
***


![Schema_Diagram](https://github.com/eggOnion/Library-Booking-System/blob/main/Schema%20Diagram.png?raw=true)


### Book Table

1. `availability` is based on the `quantity`. Eg; if (quantity == 0) then availability = FALSE

2. the `quantity` count will be compute over at `loan_period` table

***


## Learner Table

1. Can create new user accounts
2. Can set password
3. login authentication

    ## Challenge
    * Can create `admin` account to have CRUD operation over:
        * `Book` table
        * `Learner` table

***


## LoanPeriod Table

1. `starttime` to `endtime` can be fixed. Eg; 21 days. The **data type** should be `LocalDate`

2.  To compute the `quantity` count for the `book` table based on it's `loan_status`.
    * Examples; 
        * if the book is on `.BORROWED` or `.OVERDUE` then **quantity=quantity-1**
        * if the book is on `.RETURNED` then  **quantity=quantity+1**
            
3. If book has passed the enddate but not yet returned, then the `loan_status` should change to `OVERDUE` automatically.

***
