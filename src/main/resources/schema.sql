create table weather_condition
(
   day integer not null,
   drought char not null,
   rain char not null,
   max_rain char not null,
   optimal_cond char not null,
   perimeter bigint,
   primary key(day)
);
