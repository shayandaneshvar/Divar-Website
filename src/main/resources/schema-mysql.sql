create table divar
(
    id bigint auto_increment,
    primary key (id)
) engine = MyISAM;

create table user
(
    id       bigint auto_increment,
    mobile   varchar(15) not null,
    divar_id bigint,
    primary key (id),
    foreign key (divar_id)
        references divar (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table city
(
    id    bigint auto_increment,
    _name varchar(40) not null unique,
    primary key (id)
) engine = MyISAM;

create table zone
(
    id      bigint auto_increment,
    _name   varchar(30) not null,
    city_id bigint      not null,
    primary key (id),
    foreign key (city_id)
        references city (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table advertisement
(
    id          bigint auto_increment,
    ad_type     varchar(255),
    description varchar(255),
    exchange    boolean,
    has_image   boolean,
    mobile      varchar(15),
    picture     varchar(255),
    title       varchar(100),
    urgent      boolean,
    city_id     bigint not null,
    zone_id     bigint,
    primary key (id),
    foreign key (zone_id) references zone (id)
        on update cascade on delete cascade,
    foreign key (city_id) references city (id)
        on update cascade on delete cascade
) engine = MyISAM;


create table user_ads
(
    divar_id bigint not null,
    ad_id    bigint not null,
    foreign key (divar_id)
        references divar (id),
    foreign key (ad_id)
        references advertisement (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table marked_ads
(
    divar_id bigint not null,
    ad_id    bigint not null,
    foreign key (divar_id)
        references divar (id),
    foreign key (ad_id)
        references advertisement (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table recent_ads
(
    divar_id bigint not null,
    ad_id    bigint not null,
    foreign key (divar_id)
        references divar (id),
    foreign key (ad_id)
        references advertisement (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table vehicle
(
    for_rent        boolean,
    model           varchar(30),
    price           double,
    production_year bigint,
    id              bigint not null,
    primary key (id),
    foreign key (id)
        references advertisement (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table electronics
(
    price double,
    id    bigint not null,
    primary key (id),
    foreign key (id)
        references advertisement (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table real_estate
(
    area  double,
    rooms integer,
    type  varchar(255),
    id    bigint not null,
    primary key (id),
    foreign key (id)
        references advertisement (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table car
(
    kilometerage double,
    id           bigint not null,
    primary key (id),
    foreign key (id)
        references vehicle (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table truck
(
    kilometerage double,
    id           bigint not null,
    primary key (id),
    foreign key (id)
        references vehicle (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table console
(
    id bigint not null,
    primary key (id),
    foreign key (id)
        references electronics (id)
        on update cascade on delete cascade
) engine = MyISAM;


create table laptop
(
    brand varchar(30),
    id    bigint not null,
    primary key (id),
    foreign key (id)
        references electronics (id)
        on update cascade on delete cascade
) engine = MyISAM;


create table mobile
(
    brand  varchar(30),
    tablet boolean,
    id     bigint not null,
    primary key (id),
    foreign key (id)
        references electronics (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table pc
(
    id bigint not null,
    primary key (id),
    foreign key (id)
        references electronics (id)
        on update cascade on delete cascade
) engine = MyISAM;


create table commercial_sell
(
    legal_instrument boolean,
    price            double,
    id               bigint not null,
    primary key (id),
    foreign key (id) references real_estate (id)
        on update cascade on delete cascade
) engine = MyISAM;


create table residential_rent
(
    deposit double,
    rent    double,
    id      bigint not null,
    primary key (id),
    foreign key (id)
        references real_estate (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table residential_sell
(
    price double,
    id    bigint not null,
    primary key (id),
    foreign key (id)
        references real_estate (id)
        on update cascade on delete cascade
) engine = MyISAM;

create table support
(
    id          bigint auto_increment,
    description varchar(255),
    email       varchar(100),
    subject     varchar(100),
    primary key (id)
) engine = MyISAM;
