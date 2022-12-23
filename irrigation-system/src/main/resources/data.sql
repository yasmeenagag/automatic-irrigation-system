insert into LAND (id, name, location, soil_type, irrigated_at, area)
values (0, 'test area1', 'location1 ', 1, null, 100);


insert into LAND_CONFIGUARTION(id, land_id, agricultural_crop, insecticide, tractor, needed_amount_of_water, time_slot)
values (0, 0, 0, 0, 0, 100, 0);

insert into TIME_SLOT(id, slot_day, slot, status)
values (0, CURRENT_DATE, 0, 0);


insert into TIME_SLOT(id, slot_day, slot, status)
values (1, CURRENT_DATE, 1, 0);

insert into SENSOR_DEVICE(id, available)
values (1, 0)
