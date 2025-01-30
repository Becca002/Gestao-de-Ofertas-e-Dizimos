delimiter $$

# apaga procedure caso ela já exista
drop procedure if exists p_salve_membro $$

# cria procedure
create procedure p_salve_membro(
    in pMembroId int,
    in pNome varchar(100),
    in pTelefone char(11),
    in pDataNascimento date,
    in pUsuarioId int
)
proc: begin

    declare exc smallint default 0;
    declare continue handler for sqlexception set exc = 1;

    # valida campos obrigatórios
    if pNome = '' then
        select 'erro' as type, 'Nome é obrigatório.' as msg;
        leave proc;
    end if;

    if pTelefone = '' then
        set pTelefone = null;
    end if;

    if pDataNascimento is null then
        set pDataNascimento = null;
    end if;

    if pUsuarioId = -1 or pUsuarioId is null then
        select 'erro' as type, 'Usuário é obrigatório.' as msg;
        leave proc;
    end if;

    # inicia a transação
    start transaction;

    # caso não exista insere
    if pMembroId = -1 then

        # insere
        insert into membro (nome, data_cadastro, telefone, data_nascimento, usuario_id)
        values (pNome, curdate(), pTelefone, pDataNascimento, pUsuarioId);

        select last_insert_id() into pMembroId;

    else

        set sql_safe_updates = 0;

        # atualiza
        update membro set nome = pNome, telefone = pTelefone, data_nascimento = pDataNascimento, usuario_id = pUsuarioId
        where membro_id = pMembroId;

    end if;

    if exc = 1 then
        rollback;
        select 'erro' as type, 'Não foi possível registrar o membro.' as msg;
    else
        commit;
        select pMembroId as id, 'sucesso' as type, 'Membro registrado.' as msg;
    end if;

end $$