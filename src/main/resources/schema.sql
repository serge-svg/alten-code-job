DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES
(
    ID BIGINT auto_increment primary key,
    BRAND_ID INT not null,
    START_DATE DATETIME not null,
    END_DATE DATETIME not null,
    PRICE_LIST SMALLINT not null,
    PRODUCT_ID INT not null,
    PRIORITY TINYINT not null,
    PRICE NUMERIC(10,2) not null,
    CURRENCY VARCHAR(4) not null
);