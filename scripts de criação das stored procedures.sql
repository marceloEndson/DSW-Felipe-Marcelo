DROP PROCEDURE IF EXISTS AtualizarResultadoJogo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `AtualizarResultadoJogo`(idJogo int, golsMandante int, golsVisitante int)
BEGIN
	UPDATE resultadosJogo
	SET resultadosJogo.golsMandante = golsMandante, resultadosJogo.golsVisitante = golsVisitante
	WHERE resultadosJogo.idJogo = idJogo;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS AtualizarUsuario;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `AtualizarUsuario`(idUsuario int, Nome varchar(80), Email varchar(40), 
Cidade varchar(80), Senha varchar(255), Foto BLOB)
BEGIN
	UPDATE usuarios
	SET nome = NOME, email = Email, cidade = Cidade, foto = FOTO
	WHERE id = idUsuario AND senha = Senha;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CriarGrupo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CriarGrupo`(idUsuarioDono int, Nome varchar(80), OUT id int)
BEGIN
	INSERT INTO grupos(nome, idDono)
	VALUES (Nome, idUsuarioDono);
	SELECT id
	INTO id
	FROM grupos
	where nome = Nome;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CriarResutadoJogo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CriarResultadoJogo`(idJogo int, golsMandante int, golsVisitante int)
BEGIN
	INSERT INTO resultadosJogo (idJogo, golsMandante, golsVisitante)
	VALUES (idJogo, golsMandante, golsVisitante);
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CriarTokenSenha;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CriarTokenSenha`(idUsuario int, token varchar(255), validade DateTime)
BEGIN
	INSERT INTO tokens (idUsuario, token, validade)
	VALUES (idUsuario, token, validade);
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CriarUsuario;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CriarUsuario`(NomeUsuario varchar(80), Nome varchar(80), Email varchar(40),
Cidade varchar(80), Senha varchar(255), out id int)
BEGIN
	INSERT INTO usuarios (login, nome, email, cidade, senha, administrator)
	VALUES (NomeUsuario, Nome, Email, Cidade, Senha, false);
	SELECT id
	INTO id
	FROM usuarios
	WHERE login = NomeUsuario;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS ExcluirGrupo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ExcluirGrupo`(idGrupo int)
BEGIN
	DELETE FROM grupos
	WHERE id = idGrupo;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS IndicarPalpite;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `IndicarPalpite`(idUsuario int, idJogo int, golsMandante int,
golsVisitante int)
BEGIN
	INSERT INTO palpites(idUsuario, idJogo, golsMandante, golsVisitante)
	VALUES (idUsuario, idJogo, golsMandante, golsVisitante);
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS InserirUsuarioGrupo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `InserirUsuarioGrupo`(idUsuario int, idGrupo int)
BEGIN
	INSERT INTO usuariosGrupo(idUsuario, idGrupo)
	VALUES(idUsuario, idGrupo);
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS RetirarUsuarioGrupo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `RetirarUsuarioGrupo`(idUsuario int, idGrupo int)
BEGIN
	DELETE FROM usuariosGrupo
	WHERE usuariosGrupo.idUsuario = idUsuario AND usuariosGrupo.idGrupo = idGrupo;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS LoginFalha;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoginFalha`(idUsuario int)
BEGIN
	UPDATE usuarios
	SET numeroLogins = numeroLogins + 1
	WHERE id = idUsuario;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS LoginSucesso;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `LoginSucesso`(idUsuario int)
BEGIN
	UPDATE usuarios
	SET numeroLogins = 0
	WHERE id = idUsuario;
END //
DELIMITER ;