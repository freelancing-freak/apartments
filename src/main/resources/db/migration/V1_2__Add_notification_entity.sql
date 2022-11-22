create sequence notification_id_seq;

create table notification
(
    id           bigint primary key default nextval('notification_id_seq'),
    created_date timestamp not null default CURRENT_TIMESTAMP,
    apartment_id bigint,
    name         varchar   not null,
    subject      varchar   not null,
    phone_number varchar   not null,
    message      varchar   not null,
    type         varchar   not null,
    error        varchar,
    success      bool      not null
);
