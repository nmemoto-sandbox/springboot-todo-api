create table todo (
  id serial primary key,
  name varchar(255) not null,
  done boolean not null default false
);