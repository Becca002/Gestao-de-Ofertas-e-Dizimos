delimiter $$

# apaga procedure caso ela já exista
drop procedure if exists p_delete_oferta $$

# cria procedure
create procedure p_delete_oferta(
    in pOfertaId int
)
proc: begin

    declare exc smallint default 0;
    declare continue handler for sqlexception set exc = 1;

    # inicia a transação
    start transaction;

    # remove
    delete from oferta where oferta_id = pOfertaId;

    if exc = 1 then
        rollback;
        select 'erro' as type, 'Não foi possível remover a oferta.' as msg;
    else
        commit;
        select pOfertaId as id, 'sucesso' as type, 'oferta removida.' as msg;
    end if;

end $$