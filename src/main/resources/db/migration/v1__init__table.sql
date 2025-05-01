DROP TABLE IF EXISTS
    flight_time_point,
    flight_city_node,
    flight_shared,
    flight,
    gate,
    admin,
    gate_flight
    CASCADE;

DROP TYPE IF EXISTS gate_status  CASCADE;
DROP TYPE IF EXISTS flight_type  CASCADE;
DROP TYPE IF EXISTS admin_ident  CASCADE;



create type admin_ident as enum ('Airport','Airlines','GroundStaff');
create type flight_type as enum (
    'Departure', 'Arrival', 'Transfer'
);
create type gate_status as enum (
    'Standby', 'TakeASeat', 'StartBoarding', 'GroupBoarding',
    'AreaBoarding', 'AllBoarding', 'LastCall', 'BoardingCompleted',
    'GateClose', 'GateOpen'
);

create table admin (
    id integer primary key,
    ident admin_ident not null
);

create table gate (
    number text primary key
);

create table flight (
    number varchar(12) primary key,
    airlines_code varchar(4) not null,
    flight_type flight_type not null
);
create table flight_shared (
    flight_number varchar(12) references flight(number) on delete cascade,
    shared_number varchar(12) not null,
    primary key (flight_number, shared_number)
);
create table flight_city_node (
    flight_number varchar(12) references flight(number) on delete cascade,
    flight_type flight_type not null,
    city_name text not null,
    primary key (flight_number, flight_type, city_name)
);
create table flight_time_point (
    flight_number varchar(12) references flight(number) on delete cascade,
    gate_status gate_status not null,
    time_point time not null,
    primary key (flight_number, gate_status, time_point)
);

create table gate_flight (
    gate text references gate(number) on delete cascade,
    flight varchar(12) references flight(number) on delete cascade,
    primary key (gate, flight)
);
