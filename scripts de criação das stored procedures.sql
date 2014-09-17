DROP PROCEDURE IF EXISTS AtualizarResultadoJogo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `AtualizarResultadoJogo`(pIdJogo int, pGolsMandante int, pGolsVisitante int)
BEGIN
	DECLARE lGolsHojeMandante, lGolsHojeVisitante int;
	
	SELECT golsMandante, golsVisitante
	INTO lGolsHojeMandante, lGolsHojeVisitante
	FROM resultadosJogo
	WHERE idJogo = pIdJogo;
	
	/*
	IF( NOT lGolsHojeMandante IS NULL AND NOT lGolsHojeVisitante IS NULL) THEN
		CALL DescontaPontos(lGolsHojeMandante, lGolsHojeVisitante);
	END IF;
	*/
	
	UPDATE resultadosJogo
	SET golsMandante = pGolsMandante, golsVisitante = pGolsVisitante
	WHERE idJogo = pIdJogo;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS AtualizarUsuario;
DELIMITER //
CREATE DEFINER =`root`@`localhost` PROCEDURE `AtualizarUsuario`(pIdUsuario int, pNome varchar(80), pEmail varchar(40), 
pCidade varchar(80), pSenha varchar(255), pFoto BLOB)
BEGIN
	UPDATE usuarios
	SET nome = pNome, email = pEmail, cidade = pCidade, foto = pFoto
	WHERE id = pIdUsuario AND senha = pSenha;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CriarGrupo;
DELIMITER //
CREATE DEFINER =`root`@`localhost` PROCEDURE `CriarGrupo`(pIdUsuarioDono int, pNome varchar(80), OUT pId int)
BEGIN
	INSERT INTO grupos(nome, idDono)
	VALUES (pNome, pIdUsuarioDono);
	SET pId = LAST_INSERT_ID();
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CriarResultadoJogo;
DELIMITER //
CREATE DEFINER =`root`@`localhost` PROCEDURE `CriarResultadoJogo`(pIdJogo int, pGolsMandante int, pGolsVisitante int)
BEGIN
	INSERT INTO resultadosJogo (idJogo, golsMandante, golsVisitante)
	VALUES (pIdJogo, pGolsMandante, pGolsVisitante);
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS CriarTokenSenha;
DELIMITER //
CREATE DEFINER =`root`@`localhost` PROCEDURE `CriarTokenSenha`(pIdUsuario int, pToken varchar(255), pValidade DateTime)
BEGIN
	INSERT INTO tokens (idUsuario, token, validade)
	VALUES (pIdUsuario, pToken, pValidade);
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CriarUsuario;
DELIMITER //
CREATE DEFINER =`root`@`localhost` PROCEDURE `CriarUsuario`(pNomeUsuario varchar(80), pNome varchar(80), pEmail varchar(40),
pCidade varchar(80), pSenha varchar(255), out pId int)
BEGIN
	INSERT INTO usuarios (login, nome, email, cidade, senha, administrator)
	VALUES (pNomeUsuario, pNome, pEmail, pCidade, pSenha, false);
	SELECT id
	INTO pId
	FROM usuarios
	WHERE login = pNomeUsuario;
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
CREATE DEFINER=`root`@`localhost` PROCEDURE `IndicarPalpite`(pIdUsuario int, pIdJogo int, pGolsMandante int,
pGolsVisitante int)
BEGIN
	INSERT INTO palpites(idUsuario, idJogo, golsMandante, golsVisitante)
	VALUES (pIdUsuario, pIdJogo, pGolsMandante, pGolsVisitante);
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS InserirUsuarioGrupo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `InserirUsuarioGrupo`(pIdUsuario int, pIdGrupo int)
BEGIN
	INSERT INTO usuariosGrupo(idUsuario, idGrupo)
	VALUES(pIdUsuario, pIdGrupo);
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS RetirarUsuarioGrupo;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `RetirarUsuarioGrupo`(pIdUsuario int, pIdGrupo int)
BEGIN
	DELETE FROM usuariosGrupo
	WHERE idUsuario = pIdUsuario AND idGrupo = pIdGrupo;
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
	SET numeroLogins = 0, ultimoLogin = CURRENT_DATE()
	WHERE id = idUsuario;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS AcertouResultado;
DELIMITER //
CREATE PROCEDURE `AcertouResultado` (golsMandante int, golsVisitante int, palpiteMandante int, palpiteVisitante int, out acertou int)
BEGIN
	IF(golsMandante > golsVisitante AND palpiteMandante > palpiteVisitante) THEN
		SET acertou = 1;
	ELSEIF(golsMandante < golsVisitante AND palpiteMandante < palpiteVisitante) THEN
		SET acertou = 1;
	ELSEIF(golsMandante = golsVisitante AND palpiteMandante = palpiteVisitante) THEN
		SET acertou = 1;
	ELSE
		SET acertou = 0;
	END IF;
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS debug;
DELIMITER //
CREATE PROCEDURE `debug` (msg VARCHAR (255), Condicao BIT)
BEGIN
	IF not Condicao THEN
		INSERT INTO DebugMessages(message) VALUES(msg);
	END IF;
END //
DELIMITER ;

DROP PROCEDURE IF EXISTS CalcularPontosUsuarios;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CalcularPontosUsuarios`(golsMandante int, golsVisitante int, 
palpiteMandante int, palpiteVisitante int, acertouResultado int, OUT pontos int)
BEGIN
	IF (golsMandante = palpiteMandante AND golsVisitante = palpiteVisitante) THEN
		SET pontos = 10;
	ELSEIF (acertouResultado = 1 AND (golsMandante = palpiteMandante OR
	golsVisitante = palpiteVisitante)) THEN
		SET pontos = 7;
	ELSEIF (acertouResultado = 1) THEN
		SET pontos = 5;
	ELSEIF (golsMandante = palpiteMandante OR golsVisitante = palpiteVisitante) THEN
		SET PONTOS = 2;
	ELSE
		SET pontos = 0;
	END IF;
END //
DELIMITER ;


DROP PROCEDURE IF EXISTS AtualizarSenha;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `AtualizarSenha`(idUsuario int, novaSenha varchar(255))
BEGIN
	UPDATE usuarios
	SET senha = novaSenha
	WHERE id = idUsuario;
END //
DELIMITER 

/*
DROP PROCEDURE IF EXISTS DescontarPontos;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `DescontarPontos`(golsMandante int, golsVisitante int, idUsuario int, idJogo int)
BEGIN
	
END //
DELIMITER ;
*/

DROP PROCEDURE IF EXISTS CalcularPontosTimes;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `CalcularPontosTimes`(golsMandante int, golsVisitante int, idMandante int, idVisitante int, out pontosMandante int, out pontosVisitante int)
BEGIN
	IF (golsMandante = golsVisitante) THEN
		SET pontosMandante = 1;
		SET pontosVisitante = 1;
	ELSEIF (golsMandante > golsVisitante) THEN
		SET pontosMandante = 3;
		SET pontosVisitante = 0;
	ELSE
		SET pontosMandante = 0;
		SET pontosVisitante = 3;
	END IF;
END //
DELIMITER ;
