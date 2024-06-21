CREATE TABLE tt_projects(
    id UUID NOT NULL,
    version BIGINT NOT NULL,
    title varchar NOT NULL,
    first_name varchar NOT NULL,
    last_name varchar NOT NULL,
    category varchar NULL DEFAULT 'Uncategorized',
    city varchar NULL,
    country varchar NOT NULL,
    description varchar NOT NULL,
    needed_amount float NOT NULL,
    gathered_amount float DEFAULT 0.0,
    PRIMARY KEY (id)
);