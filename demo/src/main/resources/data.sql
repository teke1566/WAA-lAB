INSERT INTO users (id, email, firstname, lastname, password)
VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (3, 'dean@miu.edu', 'Dean', 'Altarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CLIENT');


INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (3, 2);


--INSERT INTO posts (id, author, content, title)
--VALUES (1, 'iPhone', "1200", "1");
--INSERT INTO posts (id, author, content, title)
--VALUES (2, 'iPhone', "1200", "1");
--INSERT INTO posts (id, author, content, title)
--VALUES (3, 'iPhone', "1200", "1");
INSERT INTO posts (id, author, content, title, user_id)
VALUES (1, 'JohnDoe', 'This is the content of the post.',
'Sample Post Title', 1);
