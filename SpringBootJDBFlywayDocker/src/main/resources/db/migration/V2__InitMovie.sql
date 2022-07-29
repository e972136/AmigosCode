create table movie (
    id BIGSERIAL primary key,
    name text not null,
    release_date date not null,
    unique (name)
);