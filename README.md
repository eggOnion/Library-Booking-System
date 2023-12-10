# Library-Booking-System 
***

## Entity Relationship Diagram (ERD)

![Schema_Diagram](https://github.com/eggOnion/Library-Booking-System/blob/main/Schema%20Diagram.png?raw=true)


## Cardinalities Relationship between `loan_period` and `learner` Table

### load_period Table

**What is the min & max `learner` that a `loan_period` can have?**
```
Ans: 1

A learner is unique, and so does the loan_period. Only a single learner can belong to 1 specific loan_period - aka id
```
---
### learner Table 

**What is the min `loan_period` that a `learner` can have?** 
```
Ans: 0

A learner can exist and didn't borrowed any book, thus the learner have no loan_period
```

**What is the max `loan_period` that a `learner` can have?**
```
Ans: Many

A learner can borrow different books on multiple times or different days, thus the learner will have many set of different loan_period - aka id
```
***

## Cardinalities Relationship between `loan_period` and `book` Table

### loan_period Table

**What is the min `book` that a `loan_period` can have? **
```
Ans: 1

In order for a loan_period to exist, it must have a minimum of 1 book borrowed.
```

**What is the max `book` that a `loan_period` can have? **
```
Ans: Many

A single loan_period can contain many different set of books borrowed.
```
---

### Book Table
**What is the min `loan_period` that a `book` can have?**
```
Ans: 0

A book is available for borrowed, but nobody wants to borrow it.
```

**What is the max `loan_period` that a `book` can have?**
```
Ans: Many

A book is available for borrowed, and it is so popular that many learner wants to borrow it.
```




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
