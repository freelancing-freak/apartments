create sequence apartment_id_seq;

create table apartment
(
    id              bigint primary key default nextval('apartment_id_seq'),
    created_date    timestamp not null default CURRENT_TIMESTAMP,
    name            varchar   not null,
    description     varchar   not null,
    location        varchar   not null,
    location_src    varchar   not null,
    measurement     integer   not null,
    number_of_rooms integer   not null,
    price           varchar   not null,
    main_image      varchar   not null,
    images          json      not null
);
