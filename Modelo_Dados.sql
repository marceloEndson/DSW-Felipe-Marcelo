CREATE TABLE usuarios 
(
	id           	int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	login        	varchar(40) NOT NULL,
	nome         	varchar(80) NOT NULL,
	email        	varchar(40) NOT NULL,
	cidade       	varchar(80) NOT NULL,
	foto         	BLOB,
	senha         	varchar(255) NOT NULL,
	numeroPontos	int NOT NULL DEFAULT 0,
	administrator	boolean NOT NULL,
	numeroLogins	int NOT NULL DEFAULT 0,
	ultimoLogin 	datetime,
	
	UNIQUE(login),
	UNIQUE(email)
);

CREATE TABLE tokens 
(
	id         		int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idUsuario 		int NOT NULL,
	token      		varchar(255) NOT NULL,
	validade		datetime NOT NULL,

	CONSTRAINT FOREIGN KEY (idUsuario) REFERENCES usuarios(id) ON DELETE CASCADE
);

CREATE TABLE grupos 
(
	id      		int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome    		varchar(80) NOT NULL,
	idDono	 		int NOT NULL,

	UNIQUE (nome),
	CONSTRAINT FOREIGN KEY (idDono) REFERENCES usuarios(id)
);

CREATE TABLE usuariosGrupo
(
	idUsuario		int NOT NULL,
	idGrupo			int NOT NULL,

	PRIMARY KEY (idUsuario, idGrupo),
	CONSTRAINT FOREIGN KEY (idUsuario) REFERENCES usuarios(id),
	CONSTRAINT FOREIGN KEY (idGrupo) REFERENCES grupos(id) ON DELETE CASCADE
);

CREATE TABLE times 
(
	id 				int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome          	varchar(40) NOT NULL,
	nomeCurto		char(3) NOT NULL,
	pontosGanhos 	int NOT NULL DEFAULT 0,
	numeroJogos  	int NOT NULL DEFAULT 0,
	golsPro      	int NOT NULL DEFAULT 0,
	golsContra   	int NOT NULL DEFAULT 0
);

CREATE TABLE jogos 
(
	id             	int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idMandante		int NOT NULL,
	idVisitante   	int NOT NULL,
	rodada         	int NOT NULL,
	estadio        	varchar(80) NOT NULL,
	datahora		datetime NOT NULL,

	CONSTRAINT FOREIGN KEY (idMandante) REFERENCES times(id) ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY (idVisitante) REFERENCES times(id) ON DELETE CASCADE
);

CREATE TABLE resultadosJogo
(
	id             	int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idJogo			int NOT NULL,
	golsMandante  	int NOT NULL,
	golsVisitante 	int NOT NULL,

	CONSTRAINT FOREIGN KEY (idJogo) REFERENCES jogos(id) ON DELETE CASCADE
);

CREATE TABLE palpites 
(
	idUsuario		int NOT NULL,
	idJogo			int NOT NULL,
	golsMandante	int NOT NULL,
	golsVisitante	int NOT NULL,

	PRIMARY KEY (idUsuario, idJogo),
	CONSTRAINT FOREIGN KEY (idUsuario) REFERENCES usuarios(id),
	CONSTRAINT FOREIGN KEY (idJogo) REFERENCES jogos(id) ON DELETE CASCADE
);

CREATE TABLE DebugMessages
(
	message VARCHAR(255) NOT NULL
);

