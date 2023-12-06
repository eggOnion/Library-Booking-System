# Library-Booking-System 
###

## Books Table

    * availability is based on quantity. Eg; if (quantity == 0) then availability = FALSE
    * the quantity count will be compute over at `loan_period` table

###

## Users Table

    * Can create new user accounts
    * Can set password
    * login authentication

    ### Challenge
    * Can create `admin` account to have CRUD operation over:
        * `Books` table
        * `Users` table

###

## LoanPeriod Table

    * starttime to endtime can be fixed. Eg; 7 days. The **data type** should be `LocalDate`
    * It will compute the quantity count for the `books` table based on it's `loan_status`
        Eg; if the book is on `.BORROWED` or `OVERDUE` then  quantity=quantity-1
            if the book is on `.RETURNED` then  quantity=quantity+1
    * If book has passed the enddate but not yet returned, then the `loan_status` should change to `OVERDUE` automatically.


