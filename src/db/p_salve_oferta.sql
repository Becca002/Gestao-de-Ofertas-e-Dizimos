delimiter $$

# apaga procedure caso ela já exista
drop procedure if exists p_salve_oferta $$

# cria procedure
create procedure p_salve_oferta(
    in pOfertaId int,
    in pValor decimal(10,2),
    in pPago int,
    in pCategoria enum('di', 'of', 'do'),
    in pUsuarioId int,
    in pMembroId int
)
proc: begin

    declare exc smallint default 0;
    declare continue handler for sqlexception set exc = 1;

    # valida campos obrigatórios
    if pValor < 0 then
        select 'erro' as type, 'Valor é obrigatório.' as msg;
        leave proc;
    end if;

    if pCategoria not in ('di', 'of', 'do') then
        select 'erro' as type, 'Categoria informada não é válida.' as msg;
        leave proc;
    end if;

    if pUsuarioId = -1 or pUsuarioId is null then
        select 'erro' as type, 'Usuário é obrigatório.' as msg;
        leave proc;
    end if;

    if pMembroId = -1 or pMembroId is null then
        select 'erro' as type, 'Membro é obrigatório.' as msg;
        leave proc;
    end if;

    # inicia a transação
    start transaction;

    # caso não exista insere
    if pOfertaId = -1 then

        # insere
        insert into oferta (valor, data_hora, pago, categoria, usuario_id, membro_id)
        values (pValor, current_timestamp, pPago, pCategoria, pUsuarioId, pMembroId);

        select last_insert_id() into pOfertaId;

    else

        set sql_safe_updates = 0;

        # atualiza
        update oferta set valor = pValor, pago = pPago, categoria = pCategoria, usuario_id = pUsuarioId, membro_id = pMembroId
        where oferta_id = pOfertaId;

    end if;

    if exc = 1 then
        rollback;
        select 'erro' as type, 'Não foi possível a oferta.' as msg;
    else
        commit;
        select 'sucesso' as type, 'Oferta registrada.' as msg;
    end if;

end $$