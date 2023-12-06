# Library-Booking-System 
***


### Books Table

1. availability is based on quantity. Eg; if (quantity == 0) then availability = FALSE

2. the quantity count will be compute over at `loan_period` table

***


## Users Table

1. Can create new user accounts
2. Can set password
3. login authentication

    ## Challenge
    * Can create `admin` account to have CRUD operation over:
        * `Books` table
        * `Users` table

***


## LoanPeriod Table

1. starttime to endtime can be fixed. Eg; 7 days. The **data type** should be `LocalDate`

2.  It will compute the quantity count for the `books` table based on it's `loan_status`.
        > Eg; if the book is on `.BORROWED` or `OVERDUE` then  quantity=quantity-1
             > if the book is on `.RETURNED` then  quantity=quantity+1
            
3. If book has passed the enddate but not yet returned, then the `loan_status` should change to `OVERDUE` automatically.

***
