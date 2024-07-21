create table orders(
    id bigint NOT NULL auto_increment,
    name VARCHAR(100) NOT NULL,
    ingredients VARCHAR(500) NOT NULL,
    type VARCHAR(100) NOT NULL,
    price VARCHAR(100) NOT NULL,

    PRIMARY KEY(id)
);