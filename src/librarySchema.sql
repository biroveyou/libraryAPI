CREATE TABLE publisher (
    publisher_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    address VARCHAR(200),
    website VARCHAR(200),
    foundation_year INT
);

CREATE TABLE author (
    author_id BIGINT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    birthday DATE,
    death DATE,
    nationality VARCHAR(100)
);

CREATE TABLE book (
    book_id BIGINT PRIMARY KEY,
    title VARCHAR(300) NOT NULL,
    author BIGINT NOT NULL,
    publisher BIGINT NOT NULL,
    edition VARCHAR(50),
    publication_year DATE,
    original_language VARCHAR(100),
    page_number INT,
    isbn CHAR(13),
    genre VARCHAR(100),
    CONSTRAINT fk_author
                  FOREIGN KEY (author)
                  REFERENCES author (author_id)
                  ON DELETE CASCADE
                  ON UPDATE CASCADE,
    CONSTRAINT fk_publisher
                  FOREIGN KEY (publisher)
                  REFERENCES publisher (publisher_id)
                  ON DELETE CASCADE
                  ON UPDATE CASCADE
);