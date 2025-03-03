CREATE TABLE IF NOT EXISTS  books  (
    book_id int  PRIMARY KEY,
    book_name  varchar(100) NOT NULL,
    author  varchar(100) NOT NULL,
    genre  varchar(100) NOT NULL,
    is_issuable  boolean NOT NULL,
    is_available  boolean NOT NULL,
    created_at  date NOT NULL,
    created_by  varchar(20) NOT NULL,
    updated_at  date DEFAULT NULL,
    updated_by  varchar(20) DEFAULT NULL
);