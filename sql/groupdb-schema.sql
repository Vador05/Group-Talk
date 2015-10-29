drop database if exists groupdb;
create database groupdb;

use groupdb;

CREATE TABLE users (
    id BINARY(16) NOT NULL,
    loginid VARCHAR(15) NOT NULL UNIQUE,
    password BINARY(16) NOT NULL,
    email VARCHAR(255) NOT NULL,
    fullname VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_roles (
    userid BINARY(16) NOT NULL,
    role ENUM ('registered', 'admin'),
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
    PRIMARY KEY (userid, role)
);

CREATE TABLE auth_tokens (
    userid BINARY(16) NOT NULL,
    token BINARY(16) NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(id) on delete cascade,
    PRIMARY KEY (token)
);

CREATE TABLE groups (
	id BINARY(16) NOT NULL,
	Title VARCHAR(15) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE relUserGroup (
	user BINARY(16) NOT NULL,
	grup BINARY(16) NOT NULL,
	FOREIGN KEY (user) REFERENCES users(id) on delete cascade,
	FOREIGN KEY (grup) REFERENCES groups(id) on delete cascade, 
	PRIMARY KEY (userid,groupid)
);


CREATE TABLE tema (
	id BINARY(16) NOT NULL,
	groupid BINARY(16) NOT NULL,
	creator BINARY (16) NOT NULL,
        subject VARCHAR(100) NOT NULL,
	content VARCHAR(100) NOT NULL,
	FOREIGN KEY (autor_tema) REFERENCES users (id) on delete cascade,
	FOREIGN KEY (idgrupo) REFERENCES groups(id) on delete cascade,
	PRIMARY KEY (id)
);

CREATE TABLE respuesta (
	id BINARY(16) NOT NULL,
	creator BINARY(16) NOT NULL,
	temaid BINARY(16) NOT NULL,
	content VARCHAR(100) NOT NULL,
	FOREIGN KEY (autor_respuesta) REFERENCES users (id) on delete cascade,
	FOREIGN KEY (idtema) REFERENCES tema(id) on delete cascade,
	PRIMARY KEY (id)
);
