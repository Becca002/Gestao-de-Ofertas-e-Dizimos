delimiter $$

# apaga procedure caso ela já exista
drop procedure if exists p_delete_membro $$

# cria procedure
create procedure p_delete_membro(
    in pMembroId int
)
proc: begin

    declare exc smallint default 0;
    declare continue handler for sqlexception set exc = 1;

    # inicia a transação
    start transaction;

    # remove
    delete from membro where membro_id = pMembroId;

    if exc = 1 then
        rollback;
        select 'erro' as type, 'Não foi possível remover o membro.' as msg;
    else
        commit;
        select pMembroId as id, 'sucesso' as type, 'Membro removido.' as msg;
    end if;

end $$