--ROLE
insert into msched.role(role_id,name, enabled) values(1,'ADMIN', 1);
insert into msched.role(role_id,name, enabled) values(2,'FACULTY', 1);
insert into msched.role(role_id,name, enabled) values(3,'STUDENT', 1);

--USER
insert into msched.user(user_id,username, password, enabled) values(1,'kloem', 'password', 1);
insert into msched.user(user_id,username, password, enabled) values(2,'dkheiv', 'password', 1);
insert into msched.user(user_id,username, password, enabled) values(3,'sean', 'tmptmp', 1);
insert into msched.user(user_id,username, password, enabled) values(4,'fitsum', 'pass222', 1);
insert into msched.user(user_id,username, password, enabled) values(5,'feven', 'pass111', 1);
insert into msched.user(user_id,username, password, enabled) values(6,'pukar', 'pass333', 1);

--USERS_ROLES

insert into msched.users_roles(user_id, role_id) values(1, 1);
insert into msched.users_roles(user_id, role_id) values(2, 3);
insert into msched.users_roles(user_id, role_id) values(3, 2);
insert into msched.users_roles(user_id, role_id) values(4, 2);
insert into msched.users_roles(user_id, role_id) values(5, 3);
insert into msched.users_roles(user_id, role_id) values(6, 3);