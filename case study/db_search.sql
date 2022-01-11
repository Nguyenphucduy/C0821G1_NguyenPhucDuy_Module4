select service_resort.service_resort_id,service_resort.code_service_resort,service_resort.description_other_convenience,service_resort.number_of_floors,service_resort.number_of_people,service_resort.pool_area,service_resort.standard_room,service_resort.usable_area
,service_resort.rent_type_rent_type_id,service_resort.service_type_service_type_id
from service_resort
join service_type on service_resort.service_type_service_type_id = service_type.service_type_id
where service_type.service_type_name like 'V%';

select *
from service_resort
join service_type on service_resort.service_type_service_type_id = service_type.service_type_id
where service_type.service_type_name like 'V%';

-- select contract.contract_id,contract.contract_code,contract.contract_deposit,contract.contract_end_date,contract.contract_start_date,
-- contract.contract_total_money,contract.customer_customer_id,contract.employee_employee_id,contract.service_resort_service_resort_id
-- from contract
-- join customer on contract.customer_customer_id = customer.customer_id
-- join contract_detail on contract.contract_id= contract_detail.contract_contract_id
-- join attach_service on contract_detail.attach_service_attach_service_id= attach_service.attach_service_id;

-- select customer.customer_id,customer.address,customer.card_id,customer.date_of_birth,customer.email,customer.gender,customer.name,customer.phone_number,
-- customer.customer_code,customer.customer_type_customer_type_id
-- from contract
-- join customer on contract.customer_customer_id = customer.customer_id
-- join contract_detail on contract.contract_id= contract_detail.contract_contract_id
-- join attach_service on contract_detail.attach_service_attach_service_id= attach_service.attach_service_id;

select attach_service.attach_service_id,attach_service.attach_service_code,attach_service.attach_service_cost,attach_service.attach_service_name,
attach_service.attach_service_quantity,attach_service.attach_service_status,attach_service.attach_service_status,attach_service.attach_service_unit
from contract
join customer on contract.customer_customer_id = customer.customer_id
join contract_detail on contract.contract_id= contract_detail.contract_contract_id
join attach_service on contract_detail.attach_service_attach_service_id= attach_service.attach_service_id;