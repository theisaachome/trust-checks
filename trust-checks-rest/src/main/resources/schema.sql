CREATE SCHEMA IF NOT EXISTS trust_checks;
DROP TABLE IF EXISTS trust_checks.countries;
DROP TABLE IF EXISTS trust_checks.payment_method_types;
CREATE TABLE IF NOT EXISTS trust_checks.countries (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    iso_code CHAR(2) NOT NULL UNIQUE
);


CREATE TABLE IF NOT EXISTS  trust_checks.payment_method_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE  -- e.g., 'BANK', 'EWALLET'
);
