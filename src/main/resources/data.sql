insert into todos (summary, description ,isCompleted) values ('テスト概要1','テスト説明1',false);
insert into todos (summary, description ,isCompleted) values ('テスト概要2','テスト説明2',false);
insert into todos (summary, description ,isCompleted) values ('テスト概要3','テスト説明3',false);

--password1234--
-- password1234
insert into users (username, password, authority) values ('tom', '$2a$10$A9jOtQVeXZLzFC2faGIbC.3RybDPqdnk87OoLFpDwZ7aLvUxjdURO', 'ADMIN');
-- password1234
insert into users (username, password, authority) values ('bob', '$2a$10$H3EsCJ1GVXj9Zg/v1xFc9.psEx5G/uI4j0wLNg3zaM9zQEdBnCH4.', 'USER');