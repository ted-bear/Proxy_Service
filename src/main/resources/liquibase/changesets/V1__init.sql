create table if not exists users
(
    id       bigserial primary key,
    username varchar(255) not null unique,
    password varchar(255) not null
);

create table if not exists users_roles
(
    user_id bigint       not null,
    role    varchar(255) not null,
    primary key (user_id, role),
    constraint fk_users_roles_users foreign key (user_id) references users (id) on delete cascade on update no action
);

create table if not exists aud_action
(
    id           bigserial primary key,
    created_at   date         not null,
    created_by   varchar(255) not null,
    url          varchar(255) not null,
    method       varchar(255) not null,
    request_body varchar(1024)
);