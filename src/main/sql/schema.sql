drop table if exists bookings CASCADE
drop table if exists hotels CASCADE
drop table if exists person_address CASCADE
drop table if exists persons CASCADE
drop table if exists rooms CASCADE

drop sequence if exists hibernate_sequence

create sequence hibernate_sequence start with 1 increment by 1

create table bookings
(
    id                      bigint not null,
    check_in                timestamp,
    check_out               timestamp,
    duration_of_nights      integer,
    reservation_description varchar(255),
    status_booking          varchar(255),
    person_id               bigint not null,
    room_id                 bigint,
    primary key (id)
)

create table hotels
(
    id                bigint not null,
    hotel_address     varchar(255),
    hotel_description varchar(255),
    primary key (id)
)

create table person_address
(
    person_id     bigint not null,
    city          varchar(255),
    street_number varchar(255),
    zip_code      varchar(255)
)

create table persons
(
    id             bigint not null,
    first_name     varchar(255),
    last_name      varchar(255),
    city           varchar(255),
    street_number  varchar(255),
    zip_code       varchar(255),
    account_name   varchar(255),
    account_type   varchar(255),
    password       varchar(255),
    reset_password boolean,
    primary key (id)
)

create table rooms
(
    id                bigint not null,
    category          varchar(255),
    check_in          boolean,
    check_out         boolean,
    is_room_available boolean,
    price             integer,
    room_description  varchar(255),
    hotel_id          bigint,
    primary key (id)
)

alter table bookings
    add constraint FK_persons_2_bookings foreign key (person_id) references persons
alter table bookings
    add constraint FK_rooms_2_bookings foreign key (room_id) references rooms
alter table person_address
    add constraint FK_person_addresses_2_persons foreign key (person_id) references persons
alter table rooms
    add constraint FK_rooms_2_hotels foreign key (hotel_id) references hotels
