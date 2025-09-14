USE test_db;

CREATE TABLE users (
    `username` varchar(50) not null,
    `password` varchar(100) not null,
    `enabled` tinyint not null,

    primary key (username)
);

INSERT INTO users VALUES
    ('user4', '{bcrypt}$2a$12$O5nWjGBxQV5CLiPrTTY4puw02ywmNWCftiwNEghT62H3ujzkpbmkq', 1), -- user1234
    ('user5', '{bcrypt}$2a$12$O5nWjGBxQV5CLiPrTTY4puw02ywmNWCftiwNEghT62H3ujzkpbmkq', 1),
    ('user6', '{bcrypt}$2a$12$O5nWjGBxQV5CLiPrTTY4puw02ywmNWCftiwNEghT62H3ujzkpbmkq', 1);

CREATE TABLE authorities (
    `username` varchar(50) not null,
    `authority` varchar(50) not null,

    unique key authorities_idx_1 (username, authority),

    constraint authorities_ibfk_1
    foreign key(username) references users(username)
);

INSERT INTO authorities VALUES
    ('user4', 'ROLE_EMPLOYEE'),
    ('user5', 'ROLE_EMPLOYEE'),
    ('user5', 'ROLE_MANAGER'),
    ('user6', 'ROLE_EMPLOYEE'),
    ('user6', 'ROLE_MANAGER'),
    ('user6', 'ROLE_ADMIN');

------ Sec 3 için: custom jdbc table'ları

CREATE TABLE custom_authorities (
    `name` varchar(50) not null,
    `role` varchar(50) not null,

    unique key authorities_idx_2 (name, role),

    constraint authorities_ibfk_2
    foreign key(name) references users(username)
);

INSERT INTO custom_authorities VALUES
    ('user4', 'ROLE_EMPLOYEE'),
    ('user5', 'ROLE_EMPLOYEE'),
    ('user5', 'ROLE_MANAGER'),
    ('user6', 'ROLE_EMPLOYEE'),
    ('user6', 'ROLE_MANAGER'),
    ('user6', 'ROLE_ADMIN');