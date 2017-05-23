--DB: ammdb ; user: jackmedda ; pass: jackjack ;

CREATE TABLE postType (
    posttype_id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    posttype_name VARCHAR(32)
);

CREATE TABLE users (
    user_id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(256) UNIQUE,
    surname VARCHAR(256),
    username VARCHAR(256) NOT NULL UNIQUE,
    password VARCHAR(256) NOT NULL,
    user_date DATE,
    presentation VARCHAR(1024),
    profImagePath VARCHAR(256)
);

CREATE TABLE groups (
    group_id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    group_name VARCHAR(256),
    group_image VARCHAR(256)
);

CREATE TABLE friends (
    usr1_id INTEGER,
    FOREIGN KEY (usr1_id) REFERENCES users(user_id) ON DELETE CASCADE,
    usr2_id INTEGER,
    FOREIGN KEY (usr2_id) REFERENCES users(user_id) ON DELETE CASCADE,
    PRIMARY KEY (usr1_id, usr2_id)
);

CREATE TABLE posts (
    post_id  INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    shared_on_user BOOLEAN,
    shared_user INTEGER,
    FOREIGN KEY (shared_user) REFERENCES users(user_id) ON DELETE CASCADE,
    shared_group INTEGER,
    FOREIGN KEY (shared_group) REFERENCES groups(group_id) ON DELETE CASCADE,
    sharer INTEGER,
    FOREIGN KEY (sharer) REFERENCES users(user_id) ON DELETE CASCADE,
    content VARCHAR(1024),
    type INTEGER,
    FOREIGN KEY (type) REFERENCES postType(postType_id),
    postContent VARCHAR(1024)
);

CREATE TABLE group_registered (
    grp_id INTEGER,
    FOREIGN KEY (grp_id) REFERENCES groups(group_id) ON DELETE CASCADE,
    usr_id INTEGER,
    FOREIGN KEY (usr_id) REFERENCES users(user_id) ON DELETE CASCADE,
    PRIMARY KEY (grp_id, usr_id)
);

--Popolamento tabella users
INSERT INTO users (user_id, name, surname, username, 
                   password, user_date, presentation, profImagePath)
VALUES (default,
        'Cookie',
        'Monster',
        'cookiemnoster@gmail.com',
        'cookiem',
        '1992-06-29',
        'La vita è un biscotto, ma se piove si scioglie',
        'images/cookieMonsterProf.jpg');

INSERT INTO users (user_id, name, surname, username, 
                   password, user_date, presentation, profImagePath)
VALUES (default,
        'Ciccio',
        'Gamer',
        'ciccio@gmail.com',
        'cicciog',
        '1990-07-04',
        'Chi è senza peccato scagli la prima pietra, oppure un croissant.',
        'images\ciccioGamerProf.jpg');

INSERT INTO users (user_id, name, surname, username,
                   password, user_date, presentation, profImagePath)
VALUES (default,
        'Pippons',
        'Pap',
        'pap@gmail.com',
        'pappap',
        '1987-04-23',
        'Pippiamo il mondo per la libertà',
        'images/pipponsProf.png');

INSERT INTO users (user_id, name, surname, username,
                   password, user_date, presentation, profImagePath)
VALUES (default,
        'LaLumaca',
        'Sbirulina',
        'sbirulo@gmail.com',
        'sbiri',
        '1998-12-03',
        'Aio a tutta birra',
        'images/sbirulinaProf.jpg');

INSERT INTO users (user_id, name, surname, username,
                   password, user_date, presentation, profImagePath)
VALUES (default,
        'Emografia',
        'Piraccia',
        'empir@gmail.com',
        'pirace',
        '1996-08-22',
        'E si va a portu banda',
        'images/piracciaProf.jpg');

--Popolamento tabella PostType
INSERT INTO posttype (posttype_id, posttype_name)
VALUES (default, 'TEXT');

INSERT INTO posttype (posttype_id, posttype_name)
VALUES (default, 'IMAGE');

--Popolamento tabella Post
INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        false,
        null,
        2,
        1,
        'Tutti al caddozzone a festeggiare',
        1,
        null);

INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        true,
        1,
        null,
        1,
        'Cassato',
        2,
        'images\cookieMonster.gif');

INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        true,
        2,
        null,
        3,
        '130 Martin Garrix',
        2,
        'images\130SiVola.jpg');

INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        true,
        2,
        null,
        4,
        'Guarda questo video zio!',
        1,
        'https://www.youtube.com/watch?v=FWHneYtED8I&t=4s');

INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        false,
        null,
        5,
        5,
        'La migliore delle vite',
        1,
        null);

INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        false,
        null,
        4,
        3,
        '',
        2,
        'images\FiredJob.jpg');

INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        true,
        4,
        null,
        5,
        'Lo svapo delle tenebre',
        2,
        'images\svapo.jpg');

INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        true,
        1,
        null,
        5,
        'Just be sure to notice the collateral beauty!',
        1,
        null);

INSERT INTO posts (post_id, shared_on_user, shared_user, shared_group,
                    sharer, content, type, postContent)
VALUES (default,
        false,
        null,
        4,
        2,
        'Grazie Pippo!!',
        1,
        'https://www.youtube.com/watch?v=pLvuEWlwT4Y');

--Popolamento gruppi
INSERT INTO groups (group_id, group_name, group_image)
VALUES (default,
        'Fuori Corso',
        '');

INSERT INTO groups (group_id, group_name, group_image)
VALUES (default,
        'Mantenuti',
        '');

INSERT INTO groups (group_id, group_name, group_image)
VALUES (default,
        'Pignette',
        '');

INSERT INTO groups (group_id, group_name, group_image)
VALUES (default,
        'Gureu',
        '');

INSERT INTO groups (group_id, group_name, group_image)
VALUES (default,
        'Scapestrati',
        '');

--Popolamento registrazione gruppi
INSERT INTO group_registered (grp_id, usr_id)
VALUES (1, 1),
       (3, 1),
       (4, 1);

INSERT INTO group_registered (grp_id, usr_id)
VALUES (2, 2),
       (4, 2),
       (5, 2);

INSERT INTO group_registered (grp_id, usr_id)
VALUES (1, 3),
       (2, 3),
       (3, 3),
       (4, 3);

INSERT INTO group_registered (grp_id, usr_id)
VALUES (5, 4);

INSERT INTO group_registered (grp_id, usr_id)
VALUES (1, 5),
       (4, 5),
       (5, 5);

--Popolamento amici
INSERT INTO friends (usr1_id, usr2_id)
VALUES (1, 2),
       (1, 3),
       (1, 5);

INSERT INTO friends (usr1_id, usr2_id)
VALUES
       (2, 3),
       (2, 4),
       (3, 4),
       (3, 5);
       