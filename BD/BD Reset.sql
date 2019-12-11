use urna_bd;

update candidato set votos = "0";
update eleitor set `status` = "fechado";

select * from candidato;
select * from eleitor;