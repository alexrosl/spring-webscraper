DROP SEQUENCE IF EXISTS user_id_seq;

CREATE SEQUENCE user_id_seq START WITH 1;
ALTER SEQUENCE user_id_seq RESTART WITh 1;

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS "users";

CREATE TABLE "users" (
    id INTEGER PRIMARY KEY DEFAULT nextval('user_id_seq'),
    username varchar(50) NOT NULL,
    password varchar(80) NOT NULL
);
CREATE UNIQUE INDEX users_unique_username_idx ON "users" (username);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES "users" (id) ON DELETE CASCADE
);