--ROLE
insert into msched.role(role_id,name, enabled) values(0,'ADMIN', 1);
insert into msched.role(role_id,name, enabled) values(1,'FACULTY', 1);
insert into msched.role(role_id,name, enabled) values(2,'STUDENT', 1);

--USER
insert into msched.user(user_id,username, password, enabled) values(0,'kloem', 'password', 1);
insert into msched.user(user_id,username, password, enabled) values(1,'dkheiv', 'password', 1);
insert into msched.user(user_id,username, password, enabled) values(2,'sean', 'tmptmp', 1);
insert into msched.user(user_id,username, password, enabled) values(3,'fitsum', 'pass222', 1);
insert into msched.user(user_id,username, password, enabled) values(4,'feven', 'pass111', 1);
insert into msched.user(user_id,username, password, enabled) values(5,'pukar', 'pass333', 1);

--USERS_ROLES

insert into msched.users_roles(user_id, role_id) values(0, 0);
insert into msched.users_roles(user_id, role_id) values(1, 2);
insert into msched.users_roles(user_id, role_id) values(2, 1);
insert into msched.users_roles(user_id, role_id) values(3, 1);
insert into msched.users_roles(user_id, role_id) values(4, 2);
insert into msched.users_roles(user_id, role_id) values(5, 2);