-- data with negative ids to avoid auto generated sequences starting from 1

insert into LAND (id, name, location, soil_type, irrigated_at, area)
values (0, 'test area1', 'location1 ', 1, null, 100);
insert into LAND (id, name, location, soil_type, irrigated_at, area)
values (-1, 'test area2', 'location1 ', 2, null, 150);
insert into LAND (id, name, location, soil_type, irrigated_at, area)
values (-2, 'test area3', 'location2 ', 0, null, 170);
insert into LAND (id, name, location, soil_type, irrigated_at, area)
values (-3, 'test area4', 'location2 ', 1, null, 140);
insert into LAND (id, name, location, soil_type, irrigated_at, area)
values (-4, 'test area5', 'location3 ', 0, null, 1200);
insert into LAND (id, name, location, soil_type, irrigated_at, area)
values (-5, 'test area6', 'location3 ', 2, null, 300);

-- ids for agricultural_crop , insecticide , tractor refers to enum values in constant package
insert into LAND_CONFIGUARTION(id, land_id, agricultural_crop, insecticide, tractor, needed_amount_of_water, time_slot)
values (0, 0, 2, 0, 0, 150, 0);

insert into LAND_CONFIGUARTION(id, land_id, agricultural_crop, insecticide, tractor, needed_amount_of_water, time_slot)
values (-1, -1, 1, 2, 0, 50, 0);

insert into LAND_CONFIGUARTION(id, land_id, agricultural_crop, insecticide, tractor, needed_amount_of_water, time_slot)
values (-2, -2, 1, 2, 0, 300, 1);

insert into LAND_CONFIGUARTION(id, land_id, agricultural_crop, insecticide, tractor, needed_amount_of_water, time_slot)
values (-3, -4, 1, 2, 0, 500, 1);



insert into TIME_SLOT(id, slot_day, slot, irrigation_done)
values (0, CURRENT_DATE, 0, 0);


insert into TIME_SLOT(id, slot_day, slot, irrigation_done)
values (1, CURRENT_DATE, 1, 0);

insert into SENSOR_DEVICE(id, available)
values (1, 1);
